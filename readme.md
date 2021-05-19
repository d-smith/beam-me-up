# beam me up

Samples etc. around Apache Beam

## basics


* Unified model for defining both batch and streaming, data-parallel pipelines
* Pipelines specifies transformations on data, and are executed on a distributed-processing backend.

PCollection
Interface in the Beam SDK; represents a multi-element data set which may or may not be distributed. Can be created by reading from an external data source, or by transforming another PCollection.

PTransform
Interface in the Beam SDK; represents single step of the pipeline that takes in an input PCollection and transforms it to zero or more output PCollections.

## archtype

export BEAM_VERSION=2.29.0
export JAVA_VERSION=11

mvn archetype:generate \
    -DinteractiveMode=false \
    -DarchetypeGroupId=org.apache.beam \
    -DarchetypeArtifactId=beam-sdks-java-maven-archetypes-starter \
    -DarchetypeVersion=$BEAM_VERSION \
    -DtargetPlatform=$JAVA_VERSION \
    -DartifactId=beam1 \
    -DgroupId=org.ds

