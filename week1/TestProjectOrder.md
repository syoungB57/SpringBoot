##### 해당 test는 "스프링 부트 3 자바 백엔드 개발 입문" 도서를 참고하여 실행됨
---
## Spring Initializr를 이용하여 Maven project 생성

* test를 쉽게 하기 위해 Dependencies에 도구 추가
  
  * H2 Database - 자료 저장을 위한 db
  * Mustache - html 템플릿 생성
  * Spring Data JPA - db 다루는 도구
 
---
## 프로젝트 소스 코드 개발
#### 기본 소스 코드 실행하여 build 되는지 확인 - <http://localhost:8080>
---

### 1. 기본 페이지 생성
생성한 HTML 파일명을 8080 뒤에 입력해주면 (ex : localhost:8080/hello.html)
작성한대로 페이지 출력

### 2. MVC 패턴을 활용하여 뷰 템플릿 페이지 생성
src/main/resources/templates에 템플릿 페이지 생성 (mustache 도구 사용)

greeting.mustache 파일 생성 후 doc 입력 -> 뷰 템플릿 자동 생성
