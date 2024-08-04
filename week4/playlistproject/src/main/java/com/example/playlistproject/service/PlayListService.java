package com.example.playlistproject.service;

import com.example.playlistproject.entity.PlayList;
import com.example.playlistproject.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PlayListService {

    @Autowired
    private PlayListRepository playListRepository;

    public List<PlayList> getPlayList() {
        return playListRepository.findAll();
    }

    public PlayList getSongById(final Long id) {
        return playListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Such Data"));
    }

    public PlayList createPlayList(PlayList playList) {
        return playListRepository.save(playList);
    }

    public PlayList updatePlayList(final Long id, final PlayList updateSong) {
        PlayList playList = getSongById(id);
        playList.setArtist(updateSong.getArtist());
        playList.setSong(updateSong.getSong());

        return playListRepository.save(playList);
    }

    public void deleteSongById(final Long id) {
        playListRepository.deleteById(id);
    }
}
