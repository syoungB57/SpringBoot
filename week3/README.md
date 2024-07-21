### RESTful API
HTML 페이지를 생성하지 않고, JSON 형식의 데이터 송수신

### H2 Database
Java로 작성된 db로 용량이 매우 가벼움 -> 테스트 환경에서 주로 사용

서버 restart하면 초기화되기 때문에 서버 재시작 후 jdbc 주소 입력해서 연결해줘야함
<http://localhost:8080/h2-console>

게시글 submit한 후 h2 db에 정상적으로 데이터 저장되었는지 확인
(sql 문 입력하여 조회 가능)

또한, Entity 이름으로 설정해준 클래스 명으로 DB 생성됨을 확인 할 수 있음

- Entity = 하나의 행과 열을 가진 데이터 객체

### H2 DB에서 데이터 호출 후 출력
    Entity 저장 시, key 값이 되는 id 값을 같이 저장 했음
    해당 Id 값으로 URL 요청을 받아 해당 데이터를 조회해 출력
    
    1. 컨트롤러에서 URL 요청 받기 
      1) @GetMapping("/posts/{id}") - id는 변수로 입력
      2) PathVariable로 해당 id값 수신
      
    2. 저장된 DB에서 해당 Id 값으로 데이터 조회
      1) Post postEntity = postRepository.findById(id).orElse(null);
      2) Id 값으로 조회 시, 데이터가 없을 수 있으니 orElse(null)로 null 반환
      
    3. 조회한 데이터를 model 객체(이름은 post)에 저장
      1) model.addAttribute("post", postEntity);
      
    4 해당 데이터로 뷰페이지 반환
      1) mustache 파일에서 <body> 부분에 {{#post}}로 감싸고 컬럼명({{id}})을 반환
        {{#post}}
        <tr>
            <th>{{id}}</th>
            <td>{{title}}</td>
            <td>{{content}}</td>
        </tr>
        {{/post}}

    
