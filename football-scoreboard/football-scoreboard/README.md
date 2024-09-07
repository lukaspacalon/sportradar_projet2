# Football World Cup Scoreboard

## Description

This project provides a simple scoreboard system for managing World Cup football matches. It allows users to start new games, update scores, finish games, and retrieve a summary of ongoing matches. The summary is ordered by the total score of the games, and in case of a tie, by the start time of the game. 

The implementation uses Java with Maven and follows object-oriented programming principles (OOP), Test-Driven Development (TDD), and SOLID principles to ensure a clean and maintainable codebase.

## Features

The scoreboard supports the following operations:

1. **Start a New Game**: Add a new game to the scoreboard with an initial score of 0-0.
2. **Update Score**: Update the score of an existing game.
3. **Finish a Game**: Remove a completed game from the scoreboard.
4. **Get a Summary of Ongoing Games**: Retrieve a summary of ongoing games, sorted by their total score in descending order, and by start time in case of a tie.

## Installation

### Prerequisites

- Java 8 or higher
- Maven 3.6 or higher

### Installation Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/football-scoreboard.git

### Navigate to the project directory:

cd football-scoreboard

### Build the project using Maven:

mvn clean install

### Usage
Running the Application
Compile and run the application:

mvn exec:java -Dexec.mainClass="com.sportdata.App"

Example Operations
Start a New Game:

scoreBoard.startGame("Mexico", "Canada");
Update Score:

scoreBoard.updateScore("Mexico", "Canada", 1, 2);
Finish a Game:

scoreBoard.finishGame("Mexico", "Canada");
Get Summary:

List<Game> summary = scoreBoard.getSummary();
summary.forEach(System.out::println);

### Testing
Running Tests
To run the unit tests, use the following Maven command:

mvn test
Code Structure
src/main/java/com/sportdata/: Contains the main application code.

App.java: The entry point of the application.
ScoreBoard.java: Manages the games and their scores.
Game.java: Represents a football game.
GameRepository.java: Interface for game storage.
InMemoryGameRepository.java: In-memory implementation of GameRepository.
src/test/java/com/sportdata/: Contains the test code.

ScoreBoardTest.java: Unit tests for ScoreBoard.

### Contributing
Contributions are welcome! Please follow these steps to contribute:

Fork the repository.
Create a new branch (git checkout -b feature/your-feature).
Make your changes and commit them (git commit -am 'Add some feature').
Push to the branch (git push origin feature/your-feature).
Open a pull request.

### License
This project is licensed under the MIT License - see the LICENSE file for details.

### Acknowledgements
Thanks to the Football World Cup for the inspiration!


### Improvements Made:
1. **Added Sections**: Included sections on usage, code structure, contributing, and license.
2. **Installation Instructions**: Provided detailed steps for cloning, building, and running the project.
3. **Usage Examples**: Added code snippets for common operations.
4. **Testing Instructions**: Added instructions for running tests.
5. **Code Structure**: Detailed the directory structure and key classes.

This updated `README.md` gives a clear, comprehensive overview of the project and its usage, improving usability and maintainability.
