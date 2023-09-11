package com.avisfy.demofilmgraphql.services;

import com.avisfy.demofilmgraphql.types.Director;

import java.util.List;

public interface DirectorService {
    List<Director> directorsByIds(List<Integer> ids);
}
