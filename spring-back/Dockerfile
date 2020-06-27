FROM mcr.microsoft.com/java/jre:11-zulu-alpine

WORKDIR /app

ADD ./build/libs/*.jar ./app.jar

EXPOSE 10001

ENTRYPOINT [ "java","-jar","app.jar" ]