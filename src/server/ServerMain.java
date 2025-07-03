package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {
    public static final int PORT = 5000;
    static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("[Server] Starting Chat Server...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("[Server] Listening on port " + PORT + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("[Server] Client connected: " + clientSocket.getInetAddress());

                ClientHandler handler = new ClientHandler(clientSocket, clients);
                clients.add(handler);
                handler.start();
            }
        } catch (Exception e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }
}
