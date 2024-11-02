# Etapa 1: Compilação e build da aplicação
FROM openjdk:17-jdk-slim AS build

# Instalar o Maven
RUN apt-get update && apt-get install -y maven

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos de projeto para o contêiner
COPY . .

# Executa a instalação do projeto, ignorando testes
RUN mvn clean install -DskipTests

# Etapa 2: Imagem final de execução (leve)
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho para execução da aplicação
WORKDIR /app

# Copia o .jar gerado na etapa de build
COPY --from=build /app/target/pos-lanchonete-0.0.1-SNAPSHOT.jar app.jar

# Expondo a porta da aplicação
EXPOSE 8080

# Define o ponto de entrada do contêiner
ENTRYPOINT ["java", "-jar", "app.jar"]
