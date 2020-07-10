cd ./spring-back
./gradlew clean build
cd ../spring-image
./gradlew clean build
cd ../

docker network create boardnet

# project deploy
docker-compose up -d --force-recreate
