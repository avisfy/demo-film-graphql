package com.avisfy.demofilmgraphql.services;

import com.avisfy.demofilmgraphql.types.Director;
import com.avisfy.demofilmgraphql.types.Film;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorServiceImpl implements DirectorService {
    private final List<Director> directors =  List.of(
            new Director(1,  "Nolan"),
            new Director(2,  "Villeneuve"),
            new Director(3,  "Refn")
            );

    @Override
    public List<Director> directorsByIds(List<Integer> ids) {
        return directors.stream().filter(d->ids.contains(d.getId())).collect(Collectors.toList());
    }
}
