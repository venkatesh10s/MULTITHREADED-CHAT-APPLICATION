package server;

import java.io.*;
import java.net.Socket;
import java.util.List;
import server.utils.TimeUtils;

public class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private List<ClientHandler> clients;

    public ClientHandler(Socket socket, List<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Welcome to the chat room!");

            String message;
            while ((message = in.readLine()) != null) {
                String timestamp = TimeUtils.getCurrentTime();
                broadcast("[" + timestamp + "] [Client " + socket.getPort() + "]: " + message);
            }

        } catch (IOException e) {
            System.out.println("Connection with client lost.");
        } finally {
            try {
                clients.remove(this);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.out.println(message);
        }
    }
}
