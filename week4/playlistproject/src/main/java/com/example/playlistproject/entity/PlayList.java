package com.example.playlistproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayList {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, message = "Artist Name should have at least 2 characters")
    private String artist;

    @Column(nullable = false)
    private String song;
}
