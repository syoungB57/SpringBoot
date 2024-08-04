package com.example.playlistproject.repository;

import com.example.playlistproject.entity.PlayList;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {
    // provided method
    // findAll()
    // findById
    // deleteById(PlayList id)
    // save(PlayList entity)

}
