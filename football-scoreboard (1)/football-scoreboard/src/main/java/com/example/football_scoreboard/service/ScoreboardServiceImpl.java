package com.example.football_scoreboard.service;

import org.springframework.stereotype.Service;

import com.example.football_scoreboard.model.Game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreboardServiceImpl implements ScoreboardService {

    private final List<Game> games;

    public ScoreboardServiceImpl() {
        this.games = new ArrayList<>();
    }

    @Override
    public void startGame(String homeTeam, String awayTeam) {
        games.add(new Game(homeTeam, awayTeam));
    }

    @Override
    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        for (Game game : games) {
            if (game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam)) {
                game.updateScore(homeScore, awayScore);
                return;
            }
        }
    }

    @Override
    public void finishGame(String homeTeam, String awayTeam) {
        games.removeIf(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam));
    }

    @Override
    public List<Game> getGamesInProgress() {
        return games;
    }

    @Override
    public List<Game> getSummary() {
        return games.stream()
                .sorted(Comparator.comparingInt(Game::getTotalScore).reversed()
                        .thenComparing(Game::getStartTime).reversed())
                .collect(Collectors.toList());
    }
}
