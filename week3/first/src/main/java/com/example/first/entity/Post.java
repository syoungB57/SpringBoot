package com.example.first.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 해당 어노테이션이 붙은 클래스 기반으로 DB에 테이블(클래스 이름과 동일 - Post) 생성됨
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    // Id 어노테이션 - DB에서 주민번호와 같은 역할 (1,2,3,...)
    // Primary key - 데이터가 중복이어도 구분할 수 있게 하는 값
    @Id
    @GeneratedValue // ID 값 자동 생성해줌
    private Long id;
    @Column // 'title' 열 생성
    private String title;

    @Column // 'content' 열 생성
    private String content;

}
