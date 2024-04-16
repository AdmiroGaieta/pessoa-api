# Use uma imagem base que tenha o Java e o Maven instalados
FROM maven:3.8.3-openjdk-17 AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Baixa as dependências do Maven (isso pode ser em cache se o pom.xml não mudar)
RUN mvn dependency:go-offline -B

# Copia todo o código-fonte para o diretório de trabalho
COPY src ./src

# Compila o código-fonte
RUN mvn package -DskipTests

# Use uma imagem base leve do Java para a execução da aplicação
FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da etapa de construção para o diretório de trabalho
COPY --from=build /app/target/*.jar app.jar

# Define o comando de inicialização da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
