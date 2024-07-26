package com.example.listproject.controller;

import com.example.listproject.dto.PlaylistForm;
import com.example.listproject.entity.Playlist;
import com.example.listproject.repository.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class PlayListController {
    @Autowired
    private SongRepository songRepository;

    @GetMapping("/playlist/new")
    public String newPlaylistForm() {
        return "playlists/new";
    }

    @PostMapping("/playlist/create")
    public String createPlaylist(PlaylistForm form) {
        log.info(form.toString());
        // System.out.println(form.toString());

        // 1. DTO를 엔티티로 변환
        Playlist playlist = form.toEntity();
        log.info(playlist.toString());
        // System.out.println(playlist.toString());

        // 2. Repository로 엔티티를 DB에 저장
        Playlist added = songRepository.save(playlist);
        log.info(added.toString());
        // System.out.println(added.toString());
        
        return "";
    }
}
