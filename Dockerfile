FROM adoptopenjdk/openjdk8-openj9

COPY target/location-service-0.0.1-SNAPSHOT.jar  /

ENTRYPOINT ["java", "-jar", "location-service-0.0.1-SNAPSHOT.jar" ]
