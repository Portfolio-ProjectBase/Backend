# Temel imaj olarak OpenJDK kullanın
FROM openjdk:23

EXPOSE 8080

# Proje dosyalarını konteynere kopyalayın
ARG JAR_FILE=target/portfolio-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar
# Uygulamanın çalışacağı portu belirleyin


# Uygulamayı başlatın
ENTRYPOINT ["java", "-jar", "app.jar"]