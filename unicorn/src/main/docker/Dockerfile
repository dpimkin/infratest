FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD unicorn-1.0-SNAPSHOT.jar unicorn.jar
RUN sh -c 'touch /unicorn.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /unicorn.jar" ]