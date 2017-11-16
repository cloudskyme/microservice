FROM java:8
MAINTAINER zhangfeng "cloudskyme@163.com"
VOLUME /tmp
ADD target/gs-spring-boot-docker-0.1.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar