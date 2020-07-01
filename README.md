# Resource Management Service

## Steps to run

### Development
* Create a seperate application-profile.yml file in resources directory.
* Add configurations to the file (Template is available in application-dev.yml)
* Run application with `mvn spring-boot:run -Dspring-boot.run.profiles=profile`

### Production
* Build application using `mvn clean install`
* Copy `rms-0.0.1-SNAPSHOT.jar` to the server you want to run.
* Add configurations to environment variables or config server
* Run `java -jar -Dspring.profiles.active=dev rms-0.0.1-SNAPSHOT.jar`