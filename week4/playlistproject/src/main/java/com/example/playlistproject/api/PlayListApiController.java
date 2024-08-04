package com.example.playlistproject.api;

import com.example.playlistproject.entity.PlayList;
import com.example.playlistproject.repository.PlayListRepository;
import com.example.playlistproject.service.PlayListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlayListApiController {
    @Autowired
    private PlayListRepository playListRepository;
    @Autowired
    private PlayListService playListService;

    @GetMapping
    public List<PlayList> getPlayLists() {
        return playListService.getPlayList();
    }

    @GetMapping(value = "/{id}")
    public PlayList getSongById(@PathVariable(value = "id") Long id) {
        //PlayList aSongById = playListService.getSongById(id);
        //if (aSongById == null) throw new OrderNo
        return playListService.getSongById(id);
    }

    @PostMapping
    public PlayList createPlayList(@Valid @RequestBody PlayList playList) {
        return playListService.createPlayList(playList);
    }

    @PutMapping(value = "{id}")
    public PlayList updatePlayList(@PathVariable(value = "id") Long id, @RequestBody PlayList playList) {
        return playListService.updatePlayList(id, playList);
    }

    @DeleteMapping(value = "{id}")
    public void deleteSong(@PathVariable(value = "id") Long id) {
        playListService.deleteSongById(id);
    }
}
