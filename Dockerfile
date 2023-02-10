FROM adoptopenjdk/maven-openjdk11:latest
FROM selenium/standalone-chrome
FROM selenium/standalone-firefox
FROM selenium/standalone-edge
COPY src /home/SeleniumAutomationFramework/src
COPY pom.xml /home/SeleniumAutomationFramework
COPY testng.xml /home/SeleniumAutomationFramework
COPY extent-test-output /home/SeleniumAutomationFramework/extent-test-output
RUN mvn -f /home/SeleniumAutomationFramework/pom.xml clean install -DskipTests=true