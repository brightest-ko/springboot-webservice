# 스프링 부트와 AWS로 혼자 구현하는 웹 서비스

[^참고하여 공부함]: https://velog.io/@swchoi0329/series/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-AWS%EB%A1%9C-%ED%98%BC%EC%9E%90-%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94-%EC%9B%B9-%EC%84%9C%EB%B9%84%EC%8A%A4



## SPEC 

- Java 8

- Gradle 4.10.2 

  [ Gradel 버전 변경]: https://github.com/brightest-ko/springboot-webservice/commit/69d2401e13464c0e69644add41ab43162204be35

- Spring Boot 2.1.7.RELEASE





## 요구사항 분석

- **03 ~ 06장** 하나의 게시판(**웹** 어플리케이션) **만들기**
  - 게시판 기능(조회/등록/수정/삭제)
  - 회원 기능(구글/네이버 로그인 / 로그인한 사용자 글 작성 권한 / 본인 작성 글에 대한 권한 권리)
- **07 ~ 10장** 서비스 **AWS**에 **무중단 배포** 진행





## 공부시 체크 사항

- [ ] **Gradle** 에 대해서?

- [ ] **TDD** vs 단위테스트(xUnit)

- [ ] **롬복**이란? 롬복의 효과?

- [ ] **iBatis** (**SQL Mapper**)  vs **JPA** (**O**bject**R**elational**M**apping)

  - **SQL Mapper** ; **관계형 데이터베이스**의 어떻게 데이터를 저장할지에 초점이 맞춰진 **데이터 모델링**에만 집중하고, 메세지를 기반으로 기능과 속성을 한곳에 관리하는 **객체지향 프로그래밍**과의 패러다임이 다르다. 즉, **패러다임 불일치** 발생 )

- [ ] **구현체**란???

  - 인터페이스인 JPA를 사용하기 위해서는 **구현체**가 필요합니다.
  - 대표적으로 Hibernate, Eclipse Link 등이 있습니다.

- [ ] **Spring Data JPA** (JPA ← Hibernate ← Spring Data JPA )

  [JPA, Hibernate, 그리고 Spring Data JPA의 차이점]: https://suhwan.dev/2019/02/24/jpa-vs-hibernate-vs-spring-data-jpa/

  - 구현체 교체의 용이성 (Hibernate  외에 다른 구현체로 쉽게 교체하기 위함)
  - 저장소 교체의 용의성 (관계형 데이터베이스 외에 다른 저장소로 쉽게 교체하기 위함)

- [ ] **네이티브 쿼리**란?

- [ ] 무중단 배포란?

  - 현재 회사에서는 무중단 배포를 사용하지 못하고 있는 이유는?
  - 또는 현재 회사에서는 무중단 배포를 사용하고 있는가?
  - 무중단 배포와 그렇지 않은 배포와의 차이점은 무엇인가?
  
- [ ] **더티체킹**이란?

  - 여기서 신기한 것이 있습니다. update 기능에서 데이터베이스에 **쿼리를 날리는 부분이 없습니다.** 이게 가능한 이유가 JPA의 **영속성 컨텍스트** 때문입니다.

    영속성 컨텍스트란, **엔티티를 영구 저장하는 환경**입니다. 일종의 놀리적 개념이라고 보시면 되며, JPA의 핵심 내용은 **엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐**로 갈립니다.

    JPA의 엔티티 매니저(EntityManager)가 활성화된 상태로(Spring Data Jpa를 쓴다면 기본옵션) **트랜잭션 안에서 데이터베이스에서 데이터를 가져오면** 이 데이터는 영속성 컨텍스트가 유지된 상태입니다.

    이 상태에서 해당 데이터의 값을 변경하면 **트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영**합니다. 즉 Entity 객체의 값만 변경하면 별도로 **Update 쿼리를 날릴 필요가 없다**는 것이죠, 이 개념을 **더티 체킹**이라고 합니다.

  - https://jojoldu.tistory.com/415

