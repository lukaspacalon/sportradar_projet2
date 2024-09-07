package com.sportdata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScoreBoard {
    private final List<Game> games;

    public ScoreBoard() {
        this.games = new ArrayList<>();
    }

    public void startGame(String homeTeam, String awayTeam) {
        // Validate team names
        if (homeTeam == null || homeTeam.trim().isEmpty() ||
                awayTeam == null || awayTeam.trim().isEmpty()) {
            throw new IllegalArgumentException("Team names must not be null or empty");
        }
        if (homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException("A team cannot play against itself");
        }
        // Ensure the game does not already exist
        if (games.stream()
                .anyMatch(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam))) {
            throw new IllegalStateException("This game is already in progress");
        }
        games.add(new Game(homeTeam, awayTeam));
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        // Validate scores
        if (homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Scores must be non-negative");
        }
        Optional<Game> gameOpt = games.stream()
                .filter(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam))
                .findFirst();

        if (gameOpt.isPresent()) {
            gameOpt.get().updateScore(homeScore, awayScore);
        } else {
            throw new IllegalStateException("Game not found on the scoreboard");
        }
    }

    public void finishGame(String homeTeam, String awayTeam) {
        boolean removed = games
                .removeIf(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam));
        if (!removed) {
            throw new IllegalStateException("Game not found on the scoreboard");
        }
    }

    public List<Game> getSummary() {
        return games.stream()
                .sorted(Comparator.comparingInt((Game game) -> game.getScore().getTotalScore())
                        .thenComparing(Game::getStartTime).reversed())
                .collect(Collectors.toList());
    }
}
