package com.example.football_scoreboard.service;

import java.util.List;

import com.example.football_scoreboard.model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ScoreboardService {

    public final List<Game> games = new ArrayList<>();

    // void startGame(String homeTeam, String awayTeam);

    public default void startGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        games.add(game);
    }

    void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore);

    void finishGame(String homeTeam, String awayTeam);

    List<Game> getGamesInProgress();

    List<Game> getSummary();
}
