package com.example.football_scoreboard;

import org.springframework.boot.SpringApplication;

public class TestFootballScoreboardApplication {

	public static void main(String[] args) {
		SpringApplication.from(FootballScoreboardApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
