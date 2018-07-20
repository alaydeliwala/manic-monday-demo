FROM openjdk:8
ADD manic-monday-demo.jar manic-monday-demo.jar
RUN bash -c 'touch /manic-monday-demo.jar'
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=container",  "-jar", "manic-monday-demo.jar"]