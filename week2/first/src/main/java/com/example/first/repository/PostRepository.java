package com.example.first.repository;

import com.example.first.entity.Post;
import org.springframework.data.repository.CrudRepository;

// CrudRepository<Post, Long> -> 2개의 제네릭 요소
// Post - 데이터를 담고있는 엔티티의 클래스 이름
// Long - 엔티티 클래스에서 Primary Key로 id 값을 Long 타입으로 지정했으니 변수 전달
public interface PostRepository extends CrudRepository<Post, Long> {
}
