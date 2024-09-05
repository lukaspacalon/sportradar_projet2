package com.example.football_scoreboard.model;

public class Game {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private long startTime;

    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.startTime = System.currentTimeMillis();
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public long getStartTime() {
        return startTime;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public void updateScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}
