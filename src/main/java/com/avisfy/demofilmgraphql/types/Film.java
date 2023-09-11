package com.avisfy.demofilmgraphql.types;

import lombok.Data;

@Data
public class Film {
    private final String title;

    private final Integer releaseYear;

    private final Integer directedById;
}
