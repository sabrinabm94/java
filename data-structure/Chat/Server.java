package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");
		Socket soc = server.accept();
		System.out.println("Cliente " + soc.getInetAddress().getHostAddress());
		Scanner respost = new Scanner(soc.getInputStream());
		while (respost.hasNextLine()) {
			System.out.println(respost.nextLine());
		}
		
		//2 threads uma para envio outra para recebimento com compartilhamento de sockets
		respost.close();
		server.close();
		soc.close();
	}
}
