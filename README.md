# Rectangles
## Rectangles analyser

It is a command line application that analyses 2 rectangles on criterion like Containment, Intersection and Adjacency.
This project is based on Java's AWT [Rectangle](https://docs.oracle.com/javase/7/docs/api/java/awt/Rectangle.html) 
implementation.

## Features:
* Visual debugging window - requires Xserver or Windows.
* Unit tests written in Spock and Junit5.
* Contains a Maven Wrapper.

## Project Structure
The project is bases on Java 11 and uses Maven as a dependency management tool.

### Usage:

This program will take 3 space-separated parameters:
1. rectangle 1 (expressed as "x,y,width,height" e.g. 0,0,100,200)
2. rectangle 2 (expressed as "x,y,width,height" e.g. 20,20,100,200)
3. debug (optional: Expects the word "true" and defaults to "false" if nothing is passed)

Example:
```bash
java -jar .\rectangles-1.0-SNAPSHOT-jar-with-dependencies.jar 0,0,100,200 20,20,100,200 true
```

Will produce an output as below: 
```
11:55:28.387 [main] INFO  org.rectangles.Main - Rectangle analysis:
11:55:28.390 [main] INFO  org.rectangles.Main - Containment: [No Containment]
11:55:28.391 [main] INFO  org.rectangles.Main - Intersection: [No Intersection]
11:55:28.391 [main] INFO  org.rectangles.Main - Adjacency: [Adjacent]
```

### Maven Goals
Maven goals could be executed using your local installation or via wrapper (preferred).

#### Package (build)
Maven Surefire plugin triggers the unit tests and generates Jacoco reports upon completion.
A new jar-with-dependencies will be generated into ./target directory. e.g. *target/rectangles-1.0-SNAPSHOT-jar-with-dependencies.jar*

```bash
./mvnw package
```
#### Sonar (Quality & Code Analysis)
Sonar plugin submits source code and Jacoco reports to a Sonar server (localhost:9000)
```bash
./mvnw sonar:sonar
```

## Libraries
This project uses the following libraries:
* Lombok
* Log4J2
* Slf4J
* JUnit5
* Spock