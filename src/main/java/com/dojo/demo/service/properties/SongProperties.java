package com.dojo.demo.service.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongProperties {

    private String artist;
    private String song;
    private Integer year;

}
