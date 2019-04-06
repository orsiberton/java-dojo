package com.dojo.demo.service;

import com.dojo.demo.service.model.Song;
import com.dojo.demo.service.properties.DummyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DummyService {

    private DummyProperties dummyProperties;

    @Autowired
    public DummyService(DummyProperties dummyProperties) {
        this.dummyProperties = dummyProperties;
    }

    public List<Song> getFavoriteSongs() {
        return dummyProperties.getFavoriteSongs()
                .stream()
                .map(s -> new Song(s.getArtist(), s.getSong(), s.getYear()))
                .collect(Collectors.toList());
    }
}
