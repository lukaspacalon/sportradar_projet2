# Football Scoreboard

## Description

Une application Spring Boot simple pour gérer un tableau de bord de score en direct pour la Coupe du Monde de Football. La solution utilise une approche TDD (Test-Driven Development) et respecte les principes SOLID.

## Fonctionnalités

- Démarrer un nouveau jeu avec un score initial de 0-0.
- Mettre à jour le score d'un jeu en cours.
- Terminer un jeu en cours.
- Obtenir un résumé des jeux en cours, triés par score total et par l'heure de début.

## Installation

Clonez le dépôt, puis exécutez `mvn install` pour installer les dépendances.

## Tests

Les tests sont fournis dans `ScoreboardServiceTest.java` et peuvent être exécutés avec `mvn test`.

## Exécution

Pour exécuter l'application, utilisez `mvn spring-boot:run`.
Puis visiter cet url : http://localhost:8080/

## Endpoints

- POST `/api/scoreboard/start?homeTeam=TeamA&awayTeam=TeamB` : Démarrer un nouveau jeu.
- POST `/api/scoreboard/update?homeTeam=TeamA&awayTeam=TeamB&homeScore=1&awayScore=2` : Mettre à jour le score.
- POST `/api/scoreboard/finish?homeTeam=TeamA&awayTeam=TeamB` : Terminer le jeu.
- GET `/api/scoreboard/games` : Obtenir les jeux en cours.
- GET `/api/scoreboard/summary` : Obtenir un résumé des jeux.

## Assumptions

- Les noms des équipes sont uniques pour chaque match.
- Le système utilise un stockage en mémoire pour les jeux en cours.


football-scoreboard
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── footballscoreboard
│   │   │               ├── FootballScoreboardApplication.java
│   │   │               ├── controller
│   │   │               │   └── ScoreboardController.java
│   │   │               ├── model
│   │   │               │   └── Game.java
│   │   │               └── service
│   │   │                   ├── ScoreboardService.java
│   │   │                   └── ScoreboardServiceImpl.java
│   ├── test
│   │   └── java
│   │       └── com
│   │           └── example
│   │               └── footballscoreboard
│   │                   ├── FootballScoreboardApplicationTests.java
│   │                   └── service
│   │                       └── ScoreboardServiceTest.java
├── pom.xml
└── README.md

