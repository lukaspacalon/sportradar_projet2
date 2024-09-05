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

## Endpoints

- POST `/api/scoreboard/start?homeTeam=TeamA&awayTeam=TeamB` : Démarrer un nouveau jeu.
- POST `/api/scoreboard/update?homeTeam=TeamA&awayTeam=TeamB&homeScore=1&awayScore=2` : Mettre à jour le score.
- POST `/api/scoreboard/finish?homeTeam=TeamA&awayTeam=TeamB` : Terminer le jeu.
- GET `/api/scoreboard/games` : Obtenir les jeux en cours.
- GET `/api/scoreboard/summary` : Obtenir un résumé des jeux.

## Assumptions

- Les noms des équipes sont uniques pour chaque match.
- Le système utilise un stockage en mémoire pour les jeux en cours.


////

Évaluation de la Solution
Voici une évaluation de la solution actuelle par rapport aux directives fournies :

1. Simplicité
Respecté : L'implémentation actuelle est relativement simple, avec une interface utilisateur minimale pour démarrer un match et afficher un message de bienvenue. Elle évite des complexités inutiles.
2. Solution de Stockage en Mémoire
Respecté : Le service ScoreboardService utilise une collection en mémoire (Map) pour stocker les jeux en cours, ce qui est conforme aux exigences de stockage en mémoire.
3. Pas de REST API, Command Line, ou Microservice
Respecté : L'implémentation actuelle est une application web avec une interface utilisateur simple, et non une API REST ou un service web.
4. Qualité (TDD, Conception OO, Code Propre, Principes SOLID)
Partiellement Respecté :
TDD : Vous avez mentionné des tests, mais ils ne sont pas inclus dans l'exemple fourni. Assurez-vous que les tests sont écrits pour vérifier toutes les fonctionnalités du service.
Conception OO et Code Propre : La conception est correcte, mais assurez-vous que le code est bien structuré et respecte les principes SOLID.
Principes SOLID : Vous devriez vérifier que les classes respectent les principes SOLID, notamment la séparation des responsabilités entre le contrôleur et le service.
5. Approche et Code Source
Non Démontré : Vous devez partager votre code source via un dépôt Git (GitHub, GitLab, BitBucket) pour que les examinateurs puissent examiner votre historique de commits et votre approche de codage.
6. README.md
Non Présent : Vous devez ajouter un fichier README.md à votre projet pour documenter les hypothèses, les instructions de configuration et d'exécution, et toute autre information pertinente.
7. Implémentation Frontend
Partiellement Respecté : L'implémentation actuelle est une application web simple, mais elle ne suit pas exactement les recommandations pour le frontend :
UI Framework : L'utilisation de Thymeleaf est appropriée pour une application web simple. Assurez-vous que le code UI est minimaliste et ne se concentre que sur la fonctionnalité.
Vanilla JavaScript/TypeScript : Si vous deviez utiliser JavaScript ou TypeScript, vous devriez créer une bibliothèque simple sans interface graphique complexe.
Recommandations
Ajouter des Tests Unitaires : Assurez-vous que vous avez écrit des tests unitaires pour le service de tableau de bord (ScoreboardService) et les contrôleurs. Utilisez JUnit et Mockito pour les tests.

Documentation : Créez un fichier README.md dans la racine de votre projet avec les informations suivantes :

Description du projet
Instructions pour la configuration et l'exécution
Comment exécuter les tests
Toute hypothèse ou décision prise pendant le développement
Partager le Code Source : Déployez le code sur une plateforme de gestion de code source (GitHub, GitLab, etc.) et fournissez le lien.

Vérification de la Conformité SOLID : Revérifiez que les principes SOLID sont respectés dans votre code. En particulier, assurez-vous que chaque classe a une responsabilité unique et que le code est facile à maintenir.

Correction des Erreurs : Résolvez l’erreur de modèle Thymeleaf pour vous assurer que l’application fonctionne correctement.

En suivant ces recommandations, vous pourrez vous assurer que votre solution est conforme aux directives et répond aux attentes du projet.