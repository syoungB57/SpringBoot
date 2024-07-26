package com.example.listproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
public class Playlist {
    // DB에서 Primary Key 역할을 하게 함
    // 중복 데이터가 있어도 Id 값으로 조회 가능
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String artist;
    @Column
    private String song;

}
