package com.example.first.dto;

import com.example.first.entity.Post;

public class PostForm {
    // name="title"에 입력한 데이터를 받을 변수
    private String title;
    // name="content"에 입력한 데이터를 받을 변수
    private String content;

    // 전달받은 내용을 선언한 변수에 저장
    public PostForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 테스트를 위해 받은 데이터 출력해보기
    @Override
    public String toString() {
        return "PostForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    // 데이터를 담은 DTO 객체를 엔티티로 변환
    public Post toEntity() {
        // 변수 순서 = Post 클래스의 생성자와 동일
        return new Post(null, title, content);
    }
}
