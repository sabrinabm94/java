package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements Runnable {
    public static Socket client;

    public Server(Socket client) {
        this.client = client;
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        //porta que ser� liberada para conex�o
        int port = 12345;
        ServerSocket server = new ServerSocket(port);
        Print.print("Server started and port " + port + " opened!");
        Print.print("Waiting for connection of clients...");

        while (true) {
            Socket client = server.accept();
            Server tratament = new Server(client);
            Thread t = new Thread(tratament);
            t.start();
        }
    }

    public void run() {
        Print.print("New connection from ip: " + client.getInetAddress().getHostAddress());
        Chat chat = new Chat(client);
        Thread read = new Thread(chat::readFromServer);
        Thread write = new Thread(chat::writeToServer);
        try {
            write.start();
            read.start();
            read.join();
            write.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
