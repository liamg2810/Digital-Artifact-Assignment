# Digital Artifact Assignment

A text-based, Dungeons & Dragons style adventure written in Java. A central server acts as the Game Master (GM), and players connect to it with a client to take part in a shared story. Players send messages describing what their characters do, and the GM responds by moving the story forward.

This project was built for a university assignment.

## Overview

The project is split into two programs that talk to each other over HTTP:

- **Server (the GM)**: Hosts the game, receives messages from every connected player and decides how the story develops. The GM can also view each character's stats and use them when running the game.
- **Client (the player)**: Connects to the server, sends messages for the player's character and shows the story as it unfolds.

## Features

Status of the main features:

- [x] Client and server communicating over HTTP (basic test endpoints)
- [ ] Multiple clients connected at the same time
- [ ] Sending and receiving story messages between clients and the server
- [ ] Character creation and stats (strength, dexterity, etc.)
- [ ] GM view of all character stats
- [ ] GM controls for changing the story based on player input
- [ ] Saving and loading a session

## Project Structure

```
src/main/java/mmu/liam/ac/uk/
    Client/Main.java                       Client entry point
    Config/Config.java                     Shared settings (server IP and port)
    Server/Main.java                       Server entry point (Spring Boot)
    Server/Controllers/TestController.java Test endpoints used to check messaging works
```

## Requirements

- Java (a recent JDK, the project is built with Gradle)
- Gradle (the included Gradle wrapper is used, so no separate install is needed)

## Building

From the project root:

```
./gradlew build
```

On Windows you can use `gradlew.bat build` instead.

## Running

The server needs to be running before any client connects.

### Start the server

Run `mmu.liam.ac.uk.Server.Main` from your IDE, or use Gradle:

```
./gradlew bootRun
```

By default the server listens on `127.0.0.1:8080`.

### Start a client

Run `mmu.liam.ac.uk.Client.Main` from your IDE. The client will connect to the address set in the config.

## Configuration

The server address and port are set in `Config/Config.java`:

```java
public static String Ip = "127.0.0.1";
public static int Port = 8080;
```

Both the client and the server read from this file, so change the values here if you want to run them on different machines or use a different port.

## Current Endpoints

These are only test endpoints for now, used to make sure messages can travel between the client and the server.

| Method | Path | Description                                      |
|--------|------|--------------------------------------------------|
| GET    | `/`  | Returns a simple greeting                        |
| POST   | `/`  | Accepts a message in the body and logs it server-side |

## Technologies

- Java
- Spring Boot (web)
- Gradle
- JUnit (testing)

## Author

Liam Gardner
