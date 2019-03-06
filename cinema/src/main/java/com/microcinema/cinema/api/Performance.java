package com.microcinema.cinema.api;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Performance {
    private @Getter Long id;
    private @Getter Long movieId;
    private @Getter Integer room;
    private @Getter Date startDate;
    private @Getter @Setter Date endDate;

    private Performance(Builder builder) {
        id = builder.id;
        movieId = builder.movieId;
        room = builder.room;
        startDate = builder.startDate;
        endDate = builder.endDate;
    }

    public static class Builder {
        private Long id;
        private Long movieId;
        private Integer room;
        private Date startDate;
        private Date endDate;


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder movieId(Long movieId) {
            this.movieId = movieId;
            return this;
        }

        public Builder room(Integer room) {
            this.room = room;
            return this;
        }

        public Builder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Performance build() {
            return new Performance(this);
        }
    }
}
