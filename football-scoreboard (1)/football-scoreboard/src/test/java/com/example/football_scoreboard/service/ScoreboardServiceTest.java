package com.example.football_scoreboard.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.football_scoreboard.model.Game;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardServiceTest {

    private ScoreboardService scoreboardService;

    @BeforeEach
    public void setUp() {
        scoreboardService = new ScoreboardServiceImpl();
    }

    @Test
    public void testStartNewGame() {
        scoreboardService.startGame("Mexico", "Canada");
        List<Game> games = scoreboardService.getGamesInProgress();
        assertEquals(1, games.size());
        assertEquals("Mexico", games.get(0).getHomeTeam());
        assertEquals("Canada", games.get(0).getAwayTeam());
    }

    @Test
    public void testUpdateScore() {
        scoreboardService.startGame("Mexico", "Canada");
        scoreboardService.updateScore("Mexico", "Canada", 0, 5);
        Game game = scoreboardService.getGamesInProgress().get(0);
        assertEquals(0, game.getHomeScore());
        assertEquals(5, game.getAwayScore());
    }

    @Test
    public void testFinishGame() {
        scoreboardService.startGame("Mexico", "Canada");
        scoreboardService.finishGame("Mexico", "Canada");
        assertEquals(0, scoreboardService.getGamesInProgress().size());
    }

    @Test
    public void testGetSummary() {
        scoreboardService.startGame("Mexico", "Canada");
        scoreboardService.updateScore("Mexico", "Canada", 0, 5);

        scoreboardService.startGame("Spain", "Brazil");
        scoreboardService.updateScore("Spain", "Brazil", 10, 2);

        scoreboardService.startGame("Germany", "France");
        scoreboardService.updateScore("Germany", "France", 2, 2);

        scoreboardService.startGame("Uruguay", "Italy");
        scoreboardService.updateScore("Uruguay", "Italy", 6, 6);

        scoreboardService.startGame("Argentina", "Australia");
        scoreboardService.updateScore("Argentina", "Australia", 3, 1);

        List<Game> summary = scoreboardService.getSummary();
        assertEquals("Germany", summary.get(0).getHomeTeam());
        assertEquals("France", summary.get(0).getAwayTeam());
        assertEquals("Argentina", summary.get(1).getHomeTeam());
        assertEquals("Australia", summary.get(1).getAwayTeam());
    }
}
