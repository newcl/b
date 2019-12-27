FROM openjdk:9
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 7788/udp
EXPOSE 40123/udp
ENTRYPOINT ["java","-jar","/app.jar"]