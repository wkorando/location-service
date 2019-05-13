FROM adoptopenjdk/openjdk8-openj9

COPY target/location-service-0.0.2-SNAPSHOT.jar  /

ENTRYPOINT exec java -jar location-service-0.0.2-SNAPSHOT.jar --spring.datasource.username=$POSTGRES_USERNAME --spring.datasource.password=$POSTGRES_PASSWORD
