-- 1) 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS react_demo
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

-- 2) 사용자 생성 & 권한 부여
CREATE USER IF NOT EXISTS 'react_user'@'localhost'
  IDENTIFIED BY 'gusdn1005@';
GRANT ALL PRIVILEGES ON react_demo.* TO 'react_user'@'localhost';
FLUSH PRIVILEGES;

-- 3) 생성한 DB 사용
USE react_demo;

-- 4) 샘플 테이블 생성 
CREATE TABLE IF NOT EXISTS users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  email    VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB
  CHARACTER SET=utf8mb4
  COLLATE=utf8mb4_unicode_ci;
