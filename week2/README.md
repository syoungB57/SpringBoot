##### Postman API 사용은 다음주에 해보는 걸로,,,
## REST API
Representational State Transfer API

: HTTP 요청에 대한 응답으로 서버의 자원(화면이 아닌 **데이터**를 반환)

해당 데이터는 JSON(JavaScript Object Notation) 형식
* JSON : key("문자열")-value형식으로 이루어진 정렬되지 않은 데이터들의 집합

## 입력받은 데이터를 H2 DB에 저장하는 순서
---
### 1. 데이터를 받을 DTO(Data Transfer Object) 생성
#### In dto/PostForm.java

    - 데이터를 받을 필드 생성 (저장할 데이터 항목의 수 대로 필드 생성) 
    - 현재 프로젝트에서는 title, content 두개의 필드 -> 생성자도 추가

### 2. 데이터를 DTO로 받기
#### In PostController.java
>**Post post = form.toEntity();**

    createPost 함수에 DTO 객체 전달받음
    해당 DTO 데이터를 Entity로 전환 (Entity는 DB에 저장하게 되는 데이터의 형태)
    
### 3. class 'Post' 생성
#### In entity/Post.java
    Annotation(@Entity)으로 해당 클래스가 Entity임을 명시 -> 클래스 이름으로 DB 생성
    DTO와 마찬가지로 필드 생성 -> Annotation(@Column)으로 해당 필드가 column임을 명시
    -> DB의 column으로 저장됨
    DB에서 primary key 값을 할 필드도 생성 (@Id, @GeneratedValue)

### 4. Entity로 변환시키는 메소드 생성
#### In dto/PostForm.java
>**return new Post(null, title, content);**

    Post 클래스(Entity)의 생성자와 변수 순서 동일 (null은 id-자동생성)

### 5. 데이터 저장할 Repository 생성 (interface)
1. CrudRepository 인터페이스 상속 - CRUD 기능을 따로 생성해주지 않아도 사용 가능
#### In repository/PostRepository.java
> extends CrudRepository<Post, Long>
>> Post : 데이터를 담고있는 엔티티의 클래스 이름
>> 
>> Long : 엔티티 클래스에서 Primary Key로 id 값을 Long 타입으로 지정했으니 Long 변수 전달

2. 해당 repository 선언
#### In PostController.java
> private PostRepository postRepository;

3. db에 데이터 저장
#### In PostController.java - createPost(PostForm form)
> 1. DTO를 Entity로 변환
>> Post post = form.toEntity();

> 2. Repository로 엔티티를 DB에 저장
> 변환한 엔티티를 'saved' 객체에 저장
>> Post saved = postRepository.save(post);
