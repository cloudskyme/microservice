FROM java:8
MAINTAINER zhangfeng "cloudskyme@163.com"
VOLUME /tmp
ADD target/chapter-04-07-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar