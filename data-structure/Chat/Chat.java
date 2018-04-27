//alunos: Anne S., Sabrina B. e Rayssa S. engenharia de software - 3º ano - estrutura de dados
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Chat {
    private Socket client;

    public Chat(Socket client) {
        this.client = client;
    }

    public void writeToServer() {
        try {
            Scanner scanner = new Scanner(System.in);
            PrintStream result = new PrintStream(client.getOutputStream());
            while (scanner.hasNextLine()) {
                result.println("Message: " + scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromServer() {
        try {
            Scanner scanner = new Scanner(this.client.getInputStream());
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
