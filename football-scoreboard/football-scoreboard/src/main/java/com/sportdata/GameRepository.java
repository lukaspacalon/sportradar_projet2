package com.sportdata;

import java.util.List;
import java.util.Optional;

public interface GameRepository {
    void add(Game game);

    boolean remove(String homeTeam, String awayTeam);

    Optional<Game> find(String homeTeam, String awayTeam);

    boolean exists(String homeTeam, String awayTeam);

    List<Game> findAll();
}
