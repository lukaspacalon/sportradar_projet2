package com.sportdata;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScoreBoard {
    private final GameRepository gameRepository;

    public ScoreBoard(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void startGame(String homeTeam, String awayTeam) {
        validateTeams(homeTeam, awayTeam);
        if (gameRepository.exists(homeTeam, awayTeam)) {
            throw new IllegalStateException("This game is already in progress");
        }
        gameRepository.add(new Game(homeTeam, awayTeam));
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        validateScores(homeScore, awayScore);
        Game game = findGame(homeTeam, awayTeam);
        game.updateScore(homeScore, awayScore);
    }

    public void finishGame(String homeTeam, String awayTeam) {
        if (!gameRepository.remove(homeTeam, awayTeam)) {
            throw new IllegalStateException("Game not found on the scoreboard");
        }
    }

    public List<Game> getSummary() {
        return gameRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Game::getTotalScore)
                        .thenComparing(Game::getStartTime).reversed())
                .collect(Collectors.toList());
    }

    private Game findGame(String homeTeam, String awayTeam) {
        return gameRepository.find(homeTeam, awayTeam)
                .orElseThrow(() -> new IllegalStateException("Game not found on the scoreboard"));
    }

    private void validateTeams(String homeTeam, String awayTeam) {
        if (homeTeam == null || homeTeam.trim().isEmpty() ||
                awayTeam == null || awayTeam.trim().isEmpty()) {
            throw new IllegalArgumentException("Team names must not be null or empty");
        }
        if (homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException("A team cannot play against itself");
        }
    }

    private void validateScores(int homeScore, int awayScore) {
        if (homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Scores must be non-negative");
        }
    }
}
