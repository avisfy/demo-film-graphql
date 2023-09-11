package com.avisfy.demofilmgraphql.datadetchers;

import com.avisfy.demofilmgraphql.services.FilmService;
import com.avisfy.demofilmgraphql.types.Film;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;


@DgsComponent
@AllArgsConstructor
public class FilmDataFetcher {
    private final FilmService filmService;

    @DgsQuery
    public Flux<Film> films(@InputArgument String titleFilter) {
        if (titleFilter == null) {
            return Flux.fromIterable(filmService.films());
        }
        return Flux.fromStream(filmService.films().stream().
                filter(e->e.getTitle().contains(titleFilter)));

    }
}
