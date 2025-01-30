# Usa una imagen base con Java
FROM openjdk:17-jdk-slim

# Copia el archivo JAR al contenedor
COPY target/url-shortener-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar tu aplicación
CMD ["java", "-jar", "app.jar"]