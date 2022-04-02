FROM maven:3.5.3-jdk-8-alpine

WORKDIR /code

# copy src files
COPY src /code/src

# copy pom.xml
COPY pom.xml /code

# copy testng.xml file
COPY testng.xml /code

# Running command
#RUN mvn -f /code/pom.xml clean test -DskipTests=true
#ENTRYPOINT mvn -f /code/pom.xml clean test -DHUB_HOST=$HUB_HOST
ENTRYPOINT mvn clean test -DHUB_HOST=$HUB_HOST -DDOCKER=true