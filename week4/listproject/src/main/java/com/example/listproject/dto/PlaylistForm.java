package com.example.listproject.dto;

import com.example.listproject.entity.Playlist;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class PlaylistForm {
    private String artist;
    private String song;

    public Playlist toEntity() {
        return new Playlist(null, artist, song);
    }
}
