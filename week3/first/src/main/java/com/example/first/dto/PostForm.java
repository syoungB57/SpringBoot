package com.example.first.dto;

import com.example.first.entity.Post;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class PostForm {
    // name="title"에 입력한 데이터를 받을 변수
    private String title;
    // name="content"에 입력한 데이터를 받을 변수
    private String content;

    // 데이터를 담은 DTO 객체를 엔티티로 변환
    public Post toEntity() {
        // 변수 순서 = Post 클래스의 생성자와 동일
        return new Post(null, title, content);
    }
}
