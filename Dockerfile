# 1. Беремо Maven з Java 25 для збірки
FROM maven:3-eclipse-temurin-25 AS build
WORKDIR /app
COPY . .
# Збираємо проект
RUN mvn clean package -DskipTests

# 2. Беремо чисту Java 25 для запуску
FROM eclipse-temurin:25-jre
WORKDIR /app
# Копіюємо готовий файл з попереднього кроку
COPY --from=build /app/target/*.jar app.jar
# Відкриваємо порт
EXPOSE 8080
# Запускаємо локомотив!
ENTRYPOINT ["java","-jar","app.jar"]