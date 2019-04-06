package com.dojo.demo.controller;

import com.dojo.demo.controller.dto.DummyResponseDto;
import com.dojo.demo.controller.dto.SongDto;
import com.dojo.demo.service.DummyService;
import com.dojo.demo.service.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/dummy", produces = MediaType.APPLICATION_JSON_VALUE)
public class DummyController {

    private DummyService dummyService;

    @Autowired
    public DummyController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @GetMapping
    public ResponseEntity<DummyResponseDto> getDummy() {

        List<Song> songs = dummyService.getFavoriteSongs();
        List<SongDto> songDtos = songs.stream()
                .map(s -> new SongDto(s.getTitle(), s.getYear()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new DummyResponseDto(songDtos));
    }
}
