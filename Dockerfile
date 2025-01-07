# Usa una imagen base con Java
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR al contenedor
COPY target/url-shortener-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que utiliza tu aplicación
EXPOSE 9000

# Comando para ejecutar tu aplicación
CMD ["java", "-jar", "app.jar"]