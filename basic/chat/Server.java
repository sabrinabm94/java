//Rodar esse arquivo somente uma vez pois s� tem um servidor
//alunos: Anne S., Sabrina B. e Rayssa S. engenharia de software - 3º ano - estrutura de dados
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements Runnable {
    public static Socket client;

    public Server(Socket client) {
        //construtor do servidor
        this.client = client;
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        //porta que ser� liberada para conex�o
        int port = 12345;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started and port " + port + " opened!");
        System.out.println("Waiting for connection of clients...");

        while (true) {
            Socket client = server.accept();
            Server tratament = new Server(client);
            Thread t = new Thread(tratament);
            t.start();
        }
    }

    public void run() {
        System.out.println("New connection from ip: " + client.getInetAddress().getHostAddress());
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
