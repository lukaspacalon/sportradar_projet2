package com.sportdata;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScoreBoardTest {
    private ScoreBoard scoreBoard;

    @Before
    public void setUp() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    public void testStartGame() {
        scoreBoard.startGame("Mexico", "Canada");
        assertEquals(1, scoreBoard.getSummary().size());
    }

    @Test
    public void testUpdateScore() {
        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.updateScore("Mexico", "Canada", 2, 1);
        assertEquals("Mexico 2 - 1 Canada", scoreBoard.getSummary().get(0).toString());
    }

    @Test
    public void testFinishGame() {
        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.finishGame("Mexico", "Canada");
        assertEquals(0, scoreBoard.getSummary().size());
    }

    @Test
    public void testGetSummary() {
        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.updateScore("Mexico", "Canada", 0, 5);

        scoreBoard.startGame("Spain", "Brazil");
        scoreBoard.updateScore("Spain", "Brazil", 10, 2);

        scoreBoard.startGame("Germany", "France");
        scoreBoard.updateScore("Germany", "France", 2, 2);

        scoreBoard.startGame("Uruguay", "Italy");
        scoreBoard.updateScore("Uruguay", "Italy", 6, 6);

        scoreBoard.startGame("Argentina", "Australia");
        scoreBoard.updateScore("Argentina", "Australia", 3, 1);

        List<Game> summary = scoreBoard.getSummary();

        assertEquals("Uruguay 6 - 6 Italy", summary.get(0).toString());
        assertEquals("Spain 10 - 2 Brazil", summary.get(1).toString());
        assertEquals("Mexico 0 - 5 Canada", summary.get(2).toString());
        assertEquals("Argentina 3 - 1 Australia", summary.get(3).toString());
        assertEquals("Germany 2 - 2 France", summary.get(4).toString());
    }
}
