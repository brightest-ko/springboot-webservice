package com.lucy.webservice.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//DB Layer 접근자
//JpaRepository<Entity 클래스, PK 타입>
//Entity 클래스와 기본 Entity Repository는 함께 위치해야 하므로 도메인 패키지에서 함께 관리한다.
public interface PostsRepository extends JpaRepository<Posts, Long>{
}
