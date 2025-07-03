package client;

import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            new MessageReceiver(socket).start();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);

            System.out.println("Connected to chat. Type your messages below:");

            while (true) {
                String msg = scanner.nextLine();
                out.println(msg);
            }

        } catch (IOException e) {
            System.out.println("Error connecting to server.");
        }
    }
}
