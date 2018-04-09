package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server implements Runnable {
	public Socket client;
	public Server(Socket client) {
		this.client = client;
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");
		
		while (true) {
		Socket soc = server.accept();
		Server
		System.out.println("Client " + soc.getInetAddress().getHostAddress());
		Scanner respost = new Scanner(soc.getInputStream());
		while (respost.hasNextLine()) {
			System.out.println(respost.nextLine());
		}
		
		//2 threads uma para envio outra para recebimento com compartilhamento de sockets
		respost.close();
		server.close();
		soc.close();
		System.out.println("O servidor encerrou conexões!");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
