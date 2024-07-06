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
#### 2-1.src/main/resources/templates에 템플릿 페이지 생성 (mustache 도구 사용)
    a. 현재는 변수 사용 x

    b. <h1>Hello Mr.Kim</h1>

greeting.mustache 파일 생성 후 doc 입력 -> 뷰 템플릿 자동 생성

해당 페이지를 보기 위한 컨트롤러&모델 사용

#### 2-2. 컨트롤러 생성
    a. src/main/java에 controller 패키지 생성
  
    b. FirstController 클래스 생성 

    c. greetUser 메소드 정의 (return값에 mustache 파일명인 'greeting' 입력)

    d. GetMapping annotation으로 접속할 때 사용하는 주소를 입력 (@GetMapping("/hi"))

      -> ~:8080/hi 접속 시, greeting.mustache에 입력해준 페이지 출력

#### 2-3. Model 생성 (뷰 페이지에 변수를 사용하기 위함)
    a. mustache 파일 속 'Kim' 대신 변수 사용

    b. 변수 사용 시 두겹의 중괄호 사용 ->  {{username}}

    c. FirstController에 Model 객체 생성하여 username이라는 변수 값 전달 -> model.addAttribute("username", "Lee");

---
## MVC (Model View Controller) 실행 흐름
    1. 컨트롤러임을 선언
    2. /hi라는 요청 접수
    3. greetUser 메서드 실행
    4. model에 사용할 변수 선언
    5. greeting.mustache에 변수값 전달 & 실행

























    
