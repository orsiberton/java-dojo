package com.dojo.demo.service;

import com.dojo.demo.service.model.Song;
import com.dojo.demo.service.properties.DummyProperties;
import com.dojo.demo.service.properties.SongProperties;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DummyServiceTest {

    @Mock
    private DummyProperties dummyProperties;

    @InjectMocks
    private DummyService dummyService;

    @Test
    public void shouldGetFavoriteSongs() {
        // Given I have my favorite songs in the property
        SongProperties songProperties1 = new SongProperties("Dire Straits", "So Far Away", 1985);
        SongProperties songProperties2 = new SongProperties("Megadeth", "Dystopia", 2016);

        when(dummyProperties.getFavoriteSongs()).thenReturn(Lists.newArrayList(songProperties1, songProperties2));

        // When I call the service
        List<Song> songs = dummyService.getFavoriteSongs();

        // Then I expect
        assertNotNull(songs);
        assertEquals(2, songs.size());
        assertEquals("Dire Straits - So Far Away", songs.get(0).getTitle());
        assertEquals(1985, songs.get(0).getYear().intValue());
        assertEquals("Megadeth - Dystopia", songs.get(1).getTitle());
        assertEquals(2016, songs.get(1).getYear().intValue());
    }
}