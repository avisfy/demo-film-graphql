package com.avisfy.demofilmgraphql.services;

import com.avisfy.demofilmgraphql.types.Film;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    private final List<Film> films =  List.of(
            new Film("Inception", 2010, 1),
            new Film("Interstellar", 2014, 1),
            new Film("Drive", 2011, 3)
    );

    @Override
    public List<Film> films() {
        return films;
    }
}
