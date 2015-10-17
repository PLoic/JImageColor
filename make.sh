args1="$1"
args2="$2"
args3="$3"
if [ "$args1" == "Generator" ] 
then
    mvn package && java -cp target/JImageColor-1.0-SNAPSHOT.jar imageColor.Generator "$args2" "$args3"
else
    mvn package && java -cp target/JImageColor-1.0-SNAPSHOT.jar imageColor.Coloring "$args1" "$args2"
fi
