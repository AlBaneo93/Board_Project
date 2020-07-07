#!/bin/bash
cd ./spring-back
./gradlew clean build
docker build -t board_back .
cd ../spring-image
./gradlew clean build
docker build -t board_image .
cd ../vue-front
docker build -t board_front .

# remote docker container
docker rm -f $(docker ps -a -q | grep board)
# remove before network
docker network rm mynet


# create network
docker network create mynet
# start mysql container
docker run -d --network mynet --name board_db --net-alias=db -e MYSQL_ROOT_PASSWORD=rootpwd -e MYSQL_DATABASE=board mysql
# start spring container
docker run -d --network mynet --name board_api -p 10001:10001 board_back
# start spring container 2
docker run -d --network mynet --name board_image -p 10101:10101 board_image
# start vue container
docker run -d --name board_front -p 80:80 board_front