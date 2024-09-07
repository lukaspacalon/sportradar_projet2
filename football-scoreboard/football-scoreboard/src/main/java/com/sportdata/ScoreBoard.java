package com.sportdata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoard {
    private List<Game> games;

    public ScoreBoard() {
        this.games = new ArrayList<>();
    }

    public void startGame(String homeTeam, String awayTeam) {
        games.add(new Game(homeTeam, awayTeam));
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        games.stream()
                .filter(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam))
                .findFirst()
                .ifPresent(game -> game.updateScore(homeScore, awayScore));
    }

    public void finishGame(String homeTeam, String awayTeam) {
        games.removeIf(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam));
    }

    public List<Game> getSummary() {
        return games.stream()
                .sorted(Comparator.comparingInt((Game game) -> game.getScore().getTotalScore())
                        .thenComparing(Game::getStartTime).reversed())
                .collect(Collectors.toList());
    }
}
