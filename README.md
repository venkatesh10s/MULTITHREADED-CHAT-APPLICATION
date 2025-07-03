# Multithreaded Chat Application

This is a simple multithreaded client-server chat application developed using Java sockets and multithreading. It allows multiple clients to connect to a single server and exchange messages in real-time through the command line interface.

## Project Objective

To demonstrate the use of core Java features such as:
- Socket Programming
- Multithreading
- Input/Output Streams
- Basic UI enhancements using console styling

This project was built as **Task 3 (TOS3)** during my internship at **CodeTechIT Solutions**.

## Features

-  Real-time chat system using TCP sockets
-  Server can handle multiple clients simultaneously using threads
-  Each message is timestamped
-  Styled console output (client messages colored)
-  Clean separation of client, server, and utility logic
-  Graceful shutdown on `Ctrl+C`

## Technologies Used

- Java SE 8+
- Sockets (`java.net.Socket`, `ServerSocket`)
- Multithreading (`java.lang.Thread`)
- Input/Output (`BufferedReader`, `PrintWriter`)
- Time formatting (`java.time`)
- Basic terminal styling using ANSI escape codes

## How to Run

### 1. Compile the Code

javac -d out src\client\*.java src\client\utils\*.java src\server\*.java src\server\utils\*.java

### 2. Run the Server (in terminal 1)

java -cp out server.ServerMain

### 3. Run Clients (in terminal 2 )

java -cp out client.ClientMain
