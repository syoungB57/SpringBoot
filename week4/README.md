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
    b. Database : playlistdb
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
    b. 주소 - localhost / port - 5432 / pw - **** / db 이름 - playlistdb
    spring.datasource.jdbcUrl=jdbc:postgresql://localhost:5432/playlistdb
    spring.datasource.username=postgres
    spring.datasource.password=****
    spring.datasource.platform=postgres
### 3) junit으로 db 연결되었나 확인
    a. junit dependency pom.xml에 추가
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13.2</version>
		</dependency>
    b. PostgreSQLConnectionTest에서 SQL 구문 실행해보기
