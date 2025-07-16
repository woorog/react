-- 1) 데이터베이스 생성 + 문자 인코딩 오류 방지
CREATE DATABASE IF NOT EXISTS apidb
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

-- 2) 사용자 생성 (localhost 와 원격 접속용 %)
CREATE USER IF NOT EXISTS 'apidbuser'@'localhost' IDENTIFIED BY 'apidbuser';
CREATE USER IF NOT EXISTS 'apidbuser'@'%'         IDENTIFIED BY 'apidbuser';

-- 3) 권한 부여
GRANT ALL PRIVILEGES ON apidb.* TO 'apidbuser'@'localhost';
GRANT ALL PRIVILEGES ON apidb.* TO 'apidbuser'@'%';

FLUSH PRIVILEGES;
