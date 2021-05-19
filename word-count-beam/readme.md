
Created via

```
mvn archetype:generate       -DarchetypeGroupId=org.apache.beam       -DarchetypeArtifactId=beam-sdks-java-maven-archetypes-examples       -DarchetypeVersion=2.29.0       -DgroupId=org.example       -DartifactId=word-count-beam       -Dversion="0.1"       -Dpackage=org.apache.beam.examples       -DinteractiveMode=false
```

Run via

```
mvn compile exec:java -Dexec.mainClass=org.apache.beam.examples.WordCount -Dexec.args="--inputFile=../0-starters/war_and_peace.txt --output=counts" -Pdirect-runner
```

Flink runner

```
mvn package exec:java -Dexec.mainClass=org.apache.beam.examples.WordCount \
-Dexec.args="--runner=FlinkRunner --flinkMaster=localhost --filesToStage=target/word-count-beam-bundled-0.1.jar \
--inputFile=$PWD/../0-starters/war_and_peace.txt --output=counts" -Pflink-runner

You can monitor the running job by visiting the Flink dashboard at http://localhost:8081
```