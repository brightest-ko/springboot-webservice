package com.lucy.webservice.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//어노테이션 순서를 주요 어노테이션을 클래스에 가깝게 둡니다
//롬복은 코드를 단순화 시켜주지만 필수 어노테이션은 아닙니다.
@Getter             // 3. 롬복의 어노테이션 //클래스 내 모든 필드의 Getter 메소드를 자동 생성
//Entity클래스에서는 절대 Setter 메소드를 만들지 않습니다.
@NoArgsConstructor  // 2. 롬복의 어노테이션 //기본생성자 자동 추가 = public Posts(){}
@Entity             // 1. JPA의 어노테이션
//테이블과 링크될 클래스임을 나타냅니다.
//기본값으로 클래스의 카멜케이스 이름을 언도스코어 네이밍(_)으로 테이블 이름을 배칭합니다.
//ex.SalesManager.java → sales_manager table
public class Posts {

    @Id //해당 테이블의 PK 필드를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //PK 생성 규칙을 나타냅니다.
    //스프링부트 2.0 GenerationType.IDENTITY → auto_increment
    private Long id;

    @Column(length = 500, nullable = false )
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
