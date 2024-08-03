## 1. Local DB 설치 (DBeaver & PostgreSQL 사용)
### 1) PostgreSQL 설치 (password 꼭 기억하기)
<https://www.enterprisedb.com/downloads/postgres-postgresql-downloads>

    port는 기본 port인 5432로 설정
### 2) pgAdmin4 실행하여 서버 생성
    a. Servers에 우클릭 - Register - Server
    b. 서버명(firstserver) & connection(localhost) 설정
    c. DB 생성 - DB명(playlistdb)
### 3) DBeaver 설치 후 PostgreSQL 연결
    a. Host : localhost
    b. Database : listdb
    c. password 입력 후 연결

---

## 2. Spring Project와 연결
### 1) pom.xml에 PostgreSQL dependency 추가
<https://mvnrepository.com/artifact/org.postgresql/postgresql>

    a. maven repository에서 postgreSQL 검색 후 dependency 복사
    	<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.7.3</version>
		</dependency>
### 2) application.properties에 datasource 정보 기재
    a. spring.datasource.jdbcUrl=jdbc:postgresql://[주소:포트/db이름]
    b. 주소 - localhost / port - 5432 / pw - **** / db 이름 - listdb
    spring.datasource.url=jdbc:postgresql://localhost:5432/listdb
    spring.datasource.username=postgres
    spring.datasource.password=****
    spring.datasource.platform=postgres

### 3) application.properties에 JPA 설정
	a.ddl-auto options
		- create : 엔티티 호출 시, 테이블 생성 (playlist1, playlist2, ...)
  		- createdrop : 테이블 있으면 삭제 후 생성
		- update : 테이블 있으면 데이터 적재 / 없으면 생성
  	b. format_sql : sql문 보기 좋게 수정 후 출력 여부
   	c. show-sql : sql문 출력 여부
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.properties.hibernate.format_sql=true 
	spring.jpa.properties.hibernate.show-sql=true
	spring.jpa.properties.hibernate.use_sql_comments=false
---
## 3. API용 클래스 생성
![image](https://github.com/user-attachments/assets/208ae97d-7ab2-4b58-8723-4140e68d8ac6)
	
### 1) entity
	a. primary key가 될 id 컬럼과 다른 컬럼들 선언

### 2) repository
	a. 기본적인 method를 사용하기 위해 extends JpaRepository<PlayList, Long>
 	- PlayList : Entity
  	- Long : id

### 3) service (Important)
#### Api에서 사용될 method 선언
	a. getPlayList()
 	- entity 전체 조회 (findAll())
  
 	b. getSongById(final Long id)
  	- PK(id)로 하나의 데이터 조회 (findById(id))
   
	c. createPlayList(PlayList playList)
 	- 전달받은 json 형식의 데이터를 entity에 저장 (save(playList)) 
  
	d. updatePlayList(final Long id, final PlayList updateSong)
 	- PK(id)로 데이터 조회 후, 수정 (
        PlayList playList = getSongById(id);
        playList.setArtist(updateSong.getArtist());
        playList.setSong(updateSong.getSong());
		
	e. deleteSongById(final Long id)
 	- PK(id)로 데이터 삭제 (deleteById(id))

### 4) api
	a. RestController 선언 (@RestController)
 	b. 요청 받을 url 선언 (@RequestMapping("/playlists")
  	c. 위 이미지대로 GET/POST/PUT/DELETE Mapping 
   	d. service에서 선언한 method 호출/사용



	
