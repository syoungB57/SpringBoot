### 1. Local DB 설치 (DBeaver & PostgreSQL 사용)
#### 1) PostgreSQL 설치 (password 꼭 기억하기)
<https://www.enterprisedb.com/downloads/postgres-postgresql-downloads>

    port는 기본 port인 5432로 설정
#### 2) pgAdmin4 실행하여 서버 생성
    a. Servers에 우클릭 - Register - Server
    b. 서버명(firstserver) & connection(localhost) 설정
    c. DB 생성 - DB명(playlistdb)
#### 3) DBeaver 설치 후 PostgreSQL 연결
    a. Host : localhost
    b. Database : playlistdb
    c. password 입력 후 연결

---

### **2. Spring Project와 연결**
