args1="$1"
args2="$2"
mvn package && java -cp target/JImageColor-1.0-SNAPSHOT.jar imageColor.Coloring "$args1" "$args2"
