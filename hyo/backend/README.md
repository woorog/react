# Spring Boot + MariaDB 서버 구축

## 1. 환경 요구 사항

* OpenJDK 17
* MariaDB 10.6 이상
* Gradle 8.x (프로젝트 루트에 `gradlew` 스크립트 포함)

---

## 2. Java 17 설치

```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

설치 확인:

```bash
java -version    # 예상 결과: openjdk version "17.x"
```

---

## 3. MariaDB 설치 및 보안 설정

1. **패키지 설치**

   ```bash
   sudo apt update
   sudo apt install mariadb-server
   ```

2. **서비스 시작 및 부팅 시 자동 실행 확인**

   ```bash
   sudo systemctl start mariadb
   sudo systemctl enable mariadb
   ```

3. **보안 스크립트 실행**

   ```bash
   sudo mysql_secure_installation
   ```

   * 루트 비밀번호 설정
   * 익명 사용자 제거
   * 원격 루트 로그인 비활성화
   * 테스트 데이터베이스 삭제
   * 권한 테이블 다시 로드

4. **데이터베이스와 전용 사용자 생성**

   ```bash
   sudo mariadb -u root
   ```

   ```sql
   CREATE DATABASE react_backend;
   CREATE USER 'react_user'@'localhost' IDENTIFIED BY 'react_pass';
   GRANT ALL PRIVILEGES ON react_backend.* TO 'react_user'@'localhost';
   FLUSH PRIVILEGES;
   EXIT;
   ```

---

## 4. 프로젝트 빌드 및 실행

1. **의존성 다운로드 및 JAR 생성**

   ```bash
   ./gradlew build        # 전체 빌드, DB설정까지 완료된 이후 실행
   ```

2. **애플리케이션 실행(예시)**

   ```bash
   java -jar build/libs/<생성된-jar-파일>.jar
   ```

---

## 5. 사용된 Gradle 의존성

### spring-boot-starter-data-jpa 
[![JPA](https://img.shields.io/badge/JPA-Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)]()
### spring-boot-starter-web
[![Web](https://img.shields.io/badge/Web-Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)]()
### lombok
[![Lombok](https://img.shields.io/badge/Lombok-FF9E0F?style=for-the-badge&logo=lombok&logoColor=white)]()
### spring-boot-starter-security
[![Security](https://img.shields.io/badge/Security-Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)]()
### mariadb-java-client
[![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white)]()


---

## 6. 자주 사용하는 셸 명령어 모음

* 시스템 패키지 업데이트
  `sudo apt update`
* 특정 패키지 설치 예시
  `sudo apt install <패키지명>`
* MariaDB 서비스 제어
  `sudo systemctl start|stop|restart mariadb`
* Gradle 빌드
  `./gradlew build`
* Spring Boot 실행
  `java -jar build/libs/<jar파일>`
* MySQL/MariaDB 클라이언트 접속
  `sudo mariadb -u <사용자명> -p`

---

## 7. 데이터베이스 생성 및 사용자 설정

MariaDB에 접속한 뒤, 아래 SQL 명령어를 차례대로 입력합니다.

1. MariaDB 접속

```bash
sudo mariadb -u root
```

2. 데이터베이스 및 사용자 생성

```sql
-- 데이터베이스 생성
CREATE DATABASE react_backend;

-- 사용자 생성
CREATE USER 'react_user'@'localhost' IDENTIFIED BY 'react_pass';

-- 권한 부여
GRANT ALL PRIVILEGES ON react_backend.* TO 'react_user'@'localhost';

-- 권한 적용
FLUSH PRIVILEGES;

-- 종료
EXIT;
```

### 구성 설명

* `react_backend`: 사용할 데이터베이스 이름
* `react_user`: Spring Boot 애플리케이션에서 접근할 DB 사용자명
* `react_pass`: 해당 사용자의 비밀번호
* `'localhost'`: 동일 서버 내에서의 접근만 허용 (외부에서 접근하려면 `'%'`로 변경 필요)

이 작업을 통해 Spring Boot의 `application.yml` 또는 `application.properties`에서 DB 접속 정보를 다음과 같이 설정할 수 있습니다:

```yaml
spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/react_backend
    username: react_user
    password: react_pass
    driver-class-name: org.mariadb.jdbc.Driver
```

---

## 8. 참고 사항

* MariaDB를 로컬이 아닌 외부에서 접근해야 하는 경우, `my.cnf`에서 `bind-address`를 조정하고 사용자 계정을 `'%'` 호스트로 추가해야 합니다.
* 개발 중 DB 마이그레이션이 반복된다면 **Flyway**나 **Liquibase**를 추가 의존성으로 고려하십시오.
* Lombok 사용 시 IDE(예: VS Code, IntelliJ)에서 Lombok 플러그인을 활성화해야 어노테이션 기반 코드 생성이 정상 동작합니다.
