 :: Spring Boot ::                (v3.4.7)

# macOS/Linux Java
❯ java -version
❯javac -version

openjdk version "21.0.7" 2025-04-15 LTS
OpenJDK Runtime Environment Corretto-21.0.7.6.1 (build 21.0.7+6-LTS)

OpenJDK 64-Bit Server VM Corretto-21.0.7.6.1 (build 21.0.7+6-LTS, mixed mode, sharing)
javac 21.0.7


db 세팅 관련
brew services start mariadb
ps aux | grep mariadbd
test. -- mysql -u root


cd ~/Desktop/react/rho/backend/java21_backend

# macOS/Linux
시작
./gradlew bootRun
종료
./gradlew --stop      # (기존 데몬 정리)


