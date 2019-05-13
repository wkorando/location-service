FROM adoptopenjdk/openjdk8-openj9

COPY target/location-service-0.0.2-SNAPSHOT.jar  /

ENTRYPOINT ["java", "-jar", "location-service-0.0.2-SNAPSHOT.jar", "-Dspring.datasource.username=$POSTGRES_USERNAME", "-Dspring.datasource.password=$POSTGRES_PASSWORD" ]
