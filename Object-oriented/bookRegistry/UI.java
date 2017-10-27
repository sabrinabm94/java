package bookRegistry;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI extends JFrame {
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("books registry");
		setSize(300, 400);
		setResizable(true);
		layoutA();
	}
	
	//configura a janela, adiciona labels, botoes...
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
			
			//classe anonima, sem nome
		});
		
		painel.add(botao);
		add(painel);
	}
}
