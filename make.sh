args1="$1"
args2="$2"
args3="$3"
height="$4"
width="$5"
if [ "$args1" == "Generator" ] 
then
    mvn package && java -Xms512m -Xmx2048m -cp target/JImageColor-1.0-SNAPSHOT.jar imageColor.Generator "$args2" "$args3" "$height" "$width"
else
    mvn package && java -Xms512m -Xmx2048m -cp target/JImageColor-1.0-SNAPSHOT.jar imageColor.Coloring "$args1" "$args2"
fi
