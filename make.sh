FILE="$1"
mvn package && java -cp target/JImageColor-1.0-SNAPSHOT.jar imageColor."$FILE"
