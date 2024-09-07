package com.sportdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryGameRepository implements GameRepository {
    private final List<Game> games = new ArrayList<>();

    @Override
    public void add(Game game) {
        games.add(game);
    }

    @Override
    public boolean remove(String homeTeam, String awayTeam) {
        return games.removeIf(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam));
    }

    @Override
    public Optional<Game> find(String homeTeam, String awayTeam) {
        return games.stream()
                .filter(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam))
                .findFirst();
    }

    @Override
    public boolean exists(String homeTeam, String awayTeam) {
        return find(homeTeam, awayTeam).isPresent();
    }

    @Override
    public List<Game> findAll() {
        return new ArrayList<>(games);
    }
}
