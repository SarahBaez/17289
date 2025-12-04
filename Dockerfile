FROM rrojano/spring-boot

WORKDIR /app

# COPIAR EL POM DESDE EL DIRECTORIO ACTUAL
COPY SaludarDatos/pom.xml .

# COPIAR LA CARPETA SRC DESDE EL DIRECTORIO ACTUAL
COPY SaludarDatos/src ./src

# COMPILAR
RUN mvn package -DskipTests

# EJECUTAR (AL FINAL)
CMD ["java", "-jar", "target/SaludarDatos-0.0.1-SNAPSHOT.jar"]