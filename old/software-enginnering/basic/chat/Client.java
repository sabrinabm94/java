package chat;

import javaRepositories.Print;
import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable {
    private Socket client;
    private Chat chat;

    public Client(Socket client) {
        this.client = client;
        this.chat = new Chat(client);
    }

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 12345);
        Client c = new Client(s);
        Thread t = new Thread(c);
        t.start();
    }

    public void run() {
        try {
            Print.print("You are connect.");
            Print.print("Start to write your message: ");
            Thread read = new Thread(chat::readFromServer);
            Thread write = new Thread(chat::writeToServer);
            read.start();
            write.start();
            read.join();
            write.join();
            client.close();
            Print.print("You are disconnected.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
