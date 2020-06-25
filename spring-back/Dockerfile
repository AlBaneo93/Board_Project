FROM openjdk:11.0.7-jdk

WORKDIR /app

ADD . .

RUN ./gradlew build

COPY ./build/libs/*.jar ./app.jar

EXPOSE 10001

ENTRYPOINT [ "java","-jar","app.jar" ]