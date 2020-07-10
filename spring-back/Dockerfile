FROM mcr.microsoft.com/java/jre:11-zulu-alpine

ENV TYPE default

WORKDIR /app

ADD ./build/libs/*.jar ./app.jar

EXPOSE 10001

ENTRYPOINT [ "java","-jar","-Dspring.profiles.active=${TYPE}","app.jar" ]