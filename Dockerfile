FROM maven:3.8.1-openjdk-11
WORKDIR /home/server
COPY Files/* Files/
COPY ./target/server-jenkins-1.0.jar /home/server
ENTRYPOINT java -cp server-jenkins-1.0.jar  lvc.cds.App