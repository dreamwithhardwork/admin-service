FROM openjdk:8
ADD build/libs/admin-0.0.1-SNAPSHOT.jar admin-0.0.1.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar", "admin-0.0.1.jar"]