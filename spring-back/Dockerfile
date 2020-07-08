FROM mcr.microsoft.com/java/jre:11-zulu-alpine

ARG type=default


WORKDIR /app

ADD ./build/libs/*.jar ./app.jar

EXPOSE 10001

ENTRYPOINT [ "java","-jar","-Dspring.profiles.active= $type","app.jar" ]