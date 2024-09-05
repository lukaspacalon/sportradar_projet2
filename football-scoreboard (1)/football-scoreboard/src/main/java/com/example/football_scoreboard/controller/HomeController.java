package com.example.football_scoreboard.controller;

import com.example.football_scoreboard.model.GameForm;
import com.example.football_scoreboard.service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private ScoreboardService scoreboardService;

    @GetMapping("/")
    public String home(Model model) {
        // Ajouter un message à afficher sur la page d'accueil
        model.addAttribute("message", "Welcome to the Football Scoreboard!");
        return "home"; // Assurez-vous que vous avez une vue 'home.html' dans 'templates'
    }

    @GetMapping("/start-game")
    public String showStartGameForm(Model model) {
        model.addAttribute("gameForm", new GameForm());
        return "start-game"; // Return the Thymeleaf template
    }

    @PostMapping("/start-game")
    public String startGame(GameForm gameForm) {
        scoreboardService.startGame(gameForm.getHomeTeam(), gameForm.getAwayTeam());
        return "redirect:/"; // Redirect to the home page or another view
    }
}