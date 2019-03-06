package com.microcinema.movies.api;

import lombok.Getter;

import java.util.Set;
import java.util.TreeSet;

public class Movie {
    private @Getter Long id;
    private @Getter String title;
    private @Getter String publishYear;
    private @Getter Integer minutesLength;
    private @Getter Set<Genre> genres;

    public enum Genre {ACTION, ADVENTURE, COMEDY, CRIMINAL, DRAMA, HISTORICAL, HORROR, MUSICAL, SCIENCE_FICTION, WAR, WESTERN}

    private Movie(Builder builder) {
        id = builder.id;
        title = builder.title;
        publishYear = builder.publishYear;
        minutesLength = builder.minutesLength;
        genres = builder.genres;
    }

    public static class Builder {
        private Long id;
        private String title;
        private String publishYear;
        private Integer minutesLength;
        private Set<Genre> genres = new TreeSet<>();

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder publishYear(String publishYear) {
            this.publishYear = publishYear;
            return this;
        }

        public Builder minutesLength(Integer minutesLength) {
            this.minutesLength = minutesLength;
            return this;
        }

        public Builder genre(Genre genre) {
            this.genres.add(genre);
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
