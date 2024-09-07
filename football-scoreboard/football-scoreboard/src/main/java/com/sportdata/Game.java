package com.sportdata;

import java.time.LocalDateTime;

public class Game {
    private String homeTeam;
    private String awayTeam;
    private Score score;
    private LocalDateTime startTime;

    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = new Score(0, 0);
        this.startTime = LocalDateTime.now();
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Score getScore() {
        return score;
    }

    public void updateScore(int homeScore, int awayScore) {
        this.score = new Score(homeScore, awayScore);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return homeTeam + " " + score.toString() + " " + awayTeam;
    }
}
