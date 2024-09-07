package com.sportdata;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();

        // Start games
        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.startGame("Spain", "Brazil");

        // Update scores
        scoreBoard.updateScore("Mexico", "Canada", 0, 5);
        scoreBoard.updateScore("Spain", "Brazil", 3, 1);

        // Display the summary of ongoing games
        System.out.println("Match Summary:");
        scoreBoard.getSummary().forEach(System.out::println);

        // Finish a game
        scoreBoard.finishGame("Mexico", "Canada");

        // Display the summary after removing a game
        System.out.println("Summary after removing a game:");
        scoreBoard.getSummary().forEach(System.out::println);
    }
}
