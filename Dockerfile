FROM openjdk:11
ADD build/libs/admin-0.0.1-SNAPSHOT.jar admin-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "admin-0.0.1.jar"]