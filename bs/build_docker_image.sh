mvn install

docker build --build-arg JAR_FILE=./target/bs-1.0-SNAPSHOT.jar -t newcl/bs:latest .