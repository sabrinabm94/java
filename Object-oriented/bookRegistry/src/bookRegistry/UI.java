package bookRegistry;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI extends JFrame {
	private JLabel statusLabel;
	private JButton loginButton;
	
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("books registry");
		setSize(300, 400);
		setResizable(true);
		layoutA();
		loginPainel();
	}
	
	private void layoutA() {
		JPanel painel = new JPanel(); //para evitar os recursos concorrerem
		painel.setLayout(null);
		painel.setSize(300, 400);
		painel.setBackground(Color.BLUE);
		
		JLabel label = new JLabel("Sou uma linda Janela zo/", JLabel.CENTER);
		label.setOpaque(true);
		label.setBackground(Color.decode("#FF0096"));
		label.setBackground(Color.WHITE);
		label.setFont(new Font("French Script MT", Font.BOLD, 36));
		label.setBounds(10, 10, 280, 30);
		painel.add(label);
		
		JButton botao = new JButton("OK"); //titulo botão
		botao.setBounds(10, 100, 280, 30);
		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicou!");
				label.setText("Cliquei no botão!");
				if(label.getBackground().equals(Color.BLACK)) {
					label.setBackground(Color.WHITE);
					label.setForeground(Color.BLACK);
				} else {
					label.setBackground(Color.BLACK);
					label.setForeground(Color.WHITE);
				}
			}
		});
		
		painel.add(botao);
		add(painel);
	}
	
	//painel de login
	private void loginPainel() {
		JPanel loginPainel = new JPanel(); 
		Client client = new Client();
		getLoginButton().addActionListener(e -> doLogin(client));
	}
	
	public JButton getLoginButton() {
		return loginButton;
	}
	
	private void doLogin(Client client) {
		if(client.getUser().length() < 1){
			setErrorMessage("Favor informar o usuário.");
		}else if(client.getPassword().length() < 1){
			setErrorMessage("Favor informar a senha.");
		}else if(client.getPassword().length() < 6){
			setErrorMessage("A senha deve conter no mínimo 6 caracteres.");
		}else if ("usuario".equals(client.getUser())
		   && "senha123".equals(client.getPassword())){
			setSuccessMessage("Seja bem vindos!");
		}else{
			setErrorMessage("O usuário ou a senha está incorreto");
		}
	}

	private void setErrorMessage(String msg) {
		statusLabel.setText(msg);
		statusLabel.setForeground(Color.RED);
	}

	private void setSuccessMessage(String msg){
		statusLabel.setText(msg);
		statusLabel.setForeground(Color.BLUE);
	}
	//fim painel de login
}


