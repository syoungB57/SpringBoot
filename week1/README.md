# SpringBoot
## DAY 1

---
### SpringBoot란? & Spring Boot 장점
    - 자바로 만든 웹 프레임워크 (= 웹 프로그램을 만들기 위한 스타터 키트)
    - 보안 공격을 막아주는 코드 작성 불필요
    - 웹 어플리케이션과 서버 환경을 연결해주는 WAS(Web Application Server) 필요 없음
---

## SpringBoot 구성 요소
#### Controller
+ user의 이벤트를 입력받아 어떤 로직을 실행할 수 있도록 업데이트 해주는 역할
#### Service
* Controller의 요청을 받아 알맞은 정보를 Controller에 재전달

#### Repoisitory
* 데이터 저장소

#### Entity
* 테이블 = Entity & 각 행 = Entity 객체

#### Annotation
> ##### @Controller
>> 하기 객체사 Controller임을 명시

> ##### @GetMapping
>> 요청이 들어온 서버와 일치하는 메소드 실행
>>
>> URL 변수 전달해줘야함

> ##### @RequestBody
>> 요청이 온 데이터를 바로 class나 model로 매핑하기 위함
>>
>> xml/json 기반의 메세지로 요청이 들어온 경우 유용

> ##### @RequestParam
>> request의 Parameter에서 데이터 수집 - method의 paramaeter에 전달
>> 
>> GET 방식으로 넘어온 URI의 queryString을 받기 적절

> ##### @PathVariable
>> method parameter 앞에 사용하여, 해당 URL에서 {특정값}을 변수로 받아옴
>> 
>> URI 경로의 일부를 파라미터로 사용

---

## SpringBoot 실습 준비
1. 에디터 설치
* IntelliJ 설치해주기 (Community ver.) - <https://www.jetbrains.com/ko-kr/idea/>

2. Spring initializr 페이지에서 프로젝트 생성(Generate) <start.spring.io>
* Maven, Java, Dependencies (Spring Web) 추가 후 생성

3. IntelliJ에서 프로젝트 open

---
