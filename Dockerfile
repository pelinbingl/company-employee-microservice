# Java 21 image'ını kullan
FROM eclipse-temurin:21-jdk-alpine

# Container içinde çalışma dizini
WORKDIR /app

# Maven build çıktısını kopyala
COPY target/*.jar app.jar

# Container başlayınca çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]