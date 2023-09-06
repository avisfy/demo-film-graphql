package com.avisfy.trygraphql.model;

import lombok.Data;

@Data
public class Film {
    private final String title;

    private final Integer releaseYear;

    private final String directedBy;
}
