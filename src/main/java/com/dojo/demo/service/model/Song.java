package com.dojo.demo.service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Song {

    private String title;
    private Integer year;

    public Song(String artist, String song, Integer year) {
        this.title = artist.concat(" - ").concat(song);
        this.year = year;
    }
}
