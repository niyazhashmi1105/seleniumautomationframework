FROM openjdk:8
EXPOSE 8080
ADD target/selenium-automation.jar selenium-automation.jar
ENTRYPOINT ["java","-jar","/selenium-automation.jar"]