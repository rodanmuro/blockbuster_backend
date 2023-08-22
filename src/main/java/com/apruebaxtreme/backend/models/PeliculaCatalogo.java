package com.apruebaxtreme.backend.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PeliculaCatalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPelicula;

    private String poster_path;
    private String title;
    private Date release_date;
    private String original_language;
    private Float vote_average;

    @Column(columnDefinition = "TEXT")
    private String overview;

    public PeliculaCatalogo(String poster_path, String title, Date release_date, String original_language,
            Float vote_average, String overview) {
        this.poster_path = poster_path;
        this.title = title;
        this.release_date = release_date;
        this.original_language = original_language;
        this.vote_average = vote_average;
        this.overview = overview;
    }

}
