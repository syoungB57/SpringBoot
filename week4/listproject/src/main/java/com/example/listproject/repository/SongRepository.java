package com.example.listproject.repository;

import com.example.listproject.entity.Playlist;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Playlist, Long> {
}
