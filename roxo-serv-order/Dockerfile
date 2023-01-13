FROM openjdk:17
COPY src /home/app/src
COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package

COPY target /home/app/target
COPY target/roxo-serv-order-0.0.1-SNAPSHOT.jar ./roxo-serv-order-0.0.1.jar
ENTRYPOINT ["java","-jar","/roxo-serv-order-0.0.1.jar"]

