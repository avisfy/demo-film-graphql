package com.avisfy.trygraphql;

import com.avisfy.trygraphql.model.Film;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;


@DgsComponent
public class FilmDatafetcher {
    private final List<Film> films =  List.of(
            new Film("Inception", 2010, "Nolan"),
            new Film("Interstellar", 2014, "Nolan"),
            new Film("Drive", 2011, "Refn")
    );

    @DgsQuery
    public Flux<Film> films(@InputArgument String titleFilter) {
        if (titleFilter == null) {
            return Flux.fromIterable(films);
        }
        return Flux.fromStream(films.stream().
                filter(e->e.getTitle().contains(titleFilter)));

    }
}
