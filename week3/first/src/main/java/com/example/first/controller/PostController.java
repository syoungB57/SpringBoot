package com.example.first.controller;

import com.example.first.dto.PostForm;
import com.example.first.entity.Post;
import com.example.first.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Slf4j
@Controller
public class PostController {

    // 스프링부트가 생성해놓은 객체를 주입
    // new 명령어로 객체 생성 안해도 PostRepository 객체 생성 후 전달
    @Autowired
    // repository로 사용할 객체 선언
    private PostRepository postRepository;

    @GetMapping("/posts/new")
    public String newPostform() {
        return "posts/new";
    }

    // 뷰 페이지에서 method 항목을 post로 했으니 Get이 아닌 PostMapping으로 받아야함
    // 뷰 페이지에서 action 항목과 같이 /posts/create 주소 입력
    @PostMapping("/posts/create")
    // 입력한 내용을 PostForm(dto)로 받기
    public String createPost(PostForm form) {
        log.info(form.toString());
        // System.out.println(form.toString());
        // 1. DTO를 엔티티로 변환
        Post post = form.toEntity();
        log.info(post.toString());
        //System.out.println(post.toString());
        // 2. Repository로 엔티티를 DB에 저장
        // 1번에서 변환한 엔티티를 'saved' 객체에 저장
            // postRepository 객체를 new 명령어로 생성 안해줘도 자동 생성
            // -> @Autowired 어노테이션으로 가능
        Post saved = postRepository.save(post);
        log.info(saved.toString());
        // System.out.println(saved.toString());
        return "";
    }

    @GetMapping("/posts/{id}")
    // Id (key값)으로 게시글 조회
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        // 1. id 값으로 데이터 조회
        // orElse(null) - 해당 id값으로 조회 시, 데이터 없으면 null 반환
        Post postEntity = postRepository.findById(id).orElse(null);
        // 2. 모델에 데이터 등록
        model.addAttribute("post", postEntity);
        // 3. 뷰 페이지 반환
        return "posts/show";
    }
}
