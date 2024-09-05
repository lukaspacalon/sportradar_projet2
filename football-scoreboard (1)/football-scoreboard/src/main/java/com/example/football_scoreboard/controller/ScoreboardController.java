package com.example.football_scoreboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.football_scoreboard.model.Game;
import com.example.football_scoreboard.service.ScoreboardService;

import java.util.List;

@RestController
@RequestMapping("/api/scoreboard")
public class ScoreboardController {

    @Autowired
    private ScoreboardService scoreboardService;

    @PostMapping("/start")
    public void startGame(@RequestParam String homeTeam, @RequestParam String awayTeam) {
        scoreboardService.startGame(homeTeam, awayTeam);
    }

    @PostMapping("/update")
    public void updateScore(@RequestParam String homeTeam, @RequestParam String awayTeam,
            @RequestParam int homeScore, @RequestParam int awayScore) {
        scoreboardService.updateScore(homeTeam, awayTeam, homeScore, awayScore);
    }

    @PostMapping("/finish")
    public void finishGame(@RequestParam String homeTeam, @RequestParam String awayTeam) {
        scoreboardService.finishGame(homeTeam, awayTeam);
    }

    @GetMapping("/games")
    public List<Game> getGamesInProgress() {
        return scoreboardService.getGamesInProgress();
    }

    @GetMapping("/summary")
    public List<Game> getSummary() {
        return scoreboardService.getSummary();
    }
}
