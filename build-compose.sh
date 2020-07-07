cd ./spring-back
./gradlew clean build
cd ../spring-image
./gradlew clean build

# remote docker container
docker rm -f $(docker ps -a -q)
# remove before network
docker network rm mynet

# create project network
docker network create mynet
# project deploy
docker-compose up -d --force-recreate
