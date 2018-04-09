package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main (String[] args) throws IOException {
		Socket client = new Socket("127.0.0.1", 12345);
		System.out.println("O cliente se conectou no Servidor");
		Scanner keybord = new Scanner (System.in);
		PrintStream respost = new PrintStream(client.getOutputStream());
		while (keybord.hasNextLine()) {
			respost.println(keybord.nextLine());
		}
		
		//2 threads uma para envio outra para recebimento com compartilhamento de sockets
		respost.close();
		keybord.close();
		client.close();
	}
}
