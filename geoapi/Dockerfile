# --- 1. Etapa de Construcción (Build Stage) ---
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar archivos de dependencias
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Descargar dependencias (Caché)
RUN ./mvnw dependency:go-offline

# Copiar código fuente
COPY src ./src

# Compilar
RUN ./mvnw package -DskipTests

# --- 2. Etapa de Ejecución (Run Stage) ---
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copiar el JAR generado
COPY --from=build /app/target/*.jar app.jar

# Ejecutar
ENTRYPOINT ["java", "-jar", "app.jar"]