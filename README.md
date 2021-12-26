A Spring Boot web-ui for evaluating simple Apache Velocity templates against a JSON context

# Running the Project
## From an IDE
Run the Application.kt class

## As a JAR
```bash
gradle clean build
java -jar build/libs/apache-velocity-testbed-1.0-SNAPSHOT.jar
```

## As a Docker image

```bash
export PORT=8080
docker pull ghcr.io/jamesphilipps/apache-velocity-testbed:latest
docker run -p8080:$PORT ghcr.io/jamesphilipps/apache-velocity-testbed
```

Using this example, the UI will be available on http://localhost:8080

# Building the Project
Run the following script to generate the jar and docker image:
```bash
./build.sh
```

