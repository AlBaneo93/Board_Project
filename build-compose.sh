cd ./spring-back
./gradlew clean build
cd ../spring-image
./gradlew clean build
cd ../

# project deploy
docker-compose up -d --force-recreate
