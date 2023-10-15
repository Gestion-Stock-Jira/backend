FROM openjdk:8
EXPOSE 8080
ADD target/devops-gestion.jar devops-gestion.jar
ENTRYPOINT ["java","-jar","/devops-gestion.jar"]