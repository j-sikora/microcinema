package com.microcinema.cinema.api;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.TreeSet;

@NoArgsConstructor
@Data
public class Movie {
    private Long id;
    private String title;
    private String publishYear;
    private  Integer minutesLength;
    private  Set<Genre> genres;

    public enum Genre {ACTION, ADVENTURE, COMEDY, CRIMINAL, DRAMA, HISTORICAL, HORROR, MUSICAL, SCIENCE_FICTION, WAR, WESTERN}

}
