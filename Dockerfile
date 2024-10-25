FROM maven:3.9.9-eclipse-temurin-17

# Установите рабочую директорию
WORKDIR /app

# Копируйте файл pom.xml и загрузите зависимости
COPY pom.xml ./
RUN mvn dependency:go-offline

# Копируйте код источника
COPY src ./src

# Запустите тесты
CMD ["mvn", "clean", "test", "-P", "TEST_GROUP=UI"]
