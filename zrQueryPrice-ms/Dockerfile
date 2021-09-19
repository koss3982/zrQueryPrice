# Imagen base con JDK16
FROM adoptopenjdk/openjdk16:x86_64-alpine-jdk-16.0.1_9-slim

# Configuramos usuario con menores privilegios de root para
# mitigar riegos de seguridad
RUN addgroup -S springboot && adduser -S springboot -G springboot
USER springboot:springboot

# Típico script genérico para copiar el JAR resultante dentro la imagen
# y ejecutarlo.
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]