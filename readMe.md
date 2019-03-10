# Mars Rover

## requirements
 JDK 1.8
Maven


# Run the server

The class `Application.java` in `api` package launch the http server containing the POST api to control the Rover :
for example POST "F-B-L-R" http/localhost:8080/commandRover


if command line passed into request body is wrong, return 400 http error code
otherwise return 201 with new rover position and Obstacle position if detected

# Acceptance tests

IT folder has a acceptance test suites ( see feature file in resources )


# Run the tests
command `mvn test` for unit tests
command `mvn integration-test -Pacceptance-tests` for acceptance tests

