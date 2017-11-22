package bookRegistry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class View {
	private JFrame frame;
	private JTextField userTextField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel statusLabel;
	
	public View(){
		frame = new JFrame("Login");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		
		panel.setBorder( new EmptyBorder(10,10,10,10));
		panel.setLayout(null);
		

		JLabel labelUser = new JLabel("Usu√°rio",JLabel.RIGHT);
		labelUser.setBounds(0,10,100,30);
		JLabel labelPass = new JLabel("Senha",JLabel.RIGHT);
		labelPass.setBounds(0,60,100,30);
		
		userTextField = new JTextField(20);
		userTextField.setBounds(110,10,200,30);
		passwordField = new JPasswordField(20);
		passwordField.setBounds(110,60,200,30);
		loginButton = new JButton("Login");
		loginButton.setBounds(110,140,200,30);
		statusLabel = new JLabel();
		statusLabel.setBounds(80,100,300,30);

		panel.add(labelUser);
		panel.add(labelPass);
		panel.add(userTextField);
		panel.add(passwordField);
		panel.add(loginButton);
		panel.add(statusLabel);
		frame.add(panel);
	}
	
	public JButton getLoginButton(){
		return loginButton;
	}
	
	public String getUserClientLogin(){
		return userTextField.getText();
	}
	
	public String getPasswordClientLogin(){
		return passwordField.getText();
	}
	
	public void setErrorMessage(String msg){
		statusLabel.setText(msg);
		statusLabel.setForeground(Color.RED);
	}
	
	public void setSuccessMessage(String msg){
		statusLabel.setText(msg);
		statusLabel.setForeground(Color.BLUE);
	}
	
	//VERIFICAR TODOS OS getDate e getInt O PORQUE EST¡ DANDO ERRO!!!!
	
	//cadastro author
	public String getNameAuthorRegistry(){
		return userTextField.getText(); 
	}
	
	//cadastro book
	public int getIsbnBookRegistry(){
		return userTextField.getInt(); 
	}
	
	public String getNameBookRegistry(){
		return userTextField.getText(); 
	}
	
	public int getYearBookRegistry(){
		return userTextField.getInt(); 
	}
	
	public String getDescriptionBookRegistry(){
		return userTextField.getText(); 
	}
	
	public int getIdAuthorBookRegistry(){
		return userTextField.getInt(); 
	}
	
	public int getStartsRankingBookRegistry(){
		return userTextField.getInt();
	}
	
	public Date getReleaseDateBookRegistry(){
		return userTextField.getDate(); 
	}
	
	public int getEditionBookRegistry(){
		return userTextField.getInt();
	}
	
	public int getIdCollectionBookRegistry(){
		return userTextField.getInt(); 
	}
	
	//cadastro client
	public String getUserClientRegistry(){
		return userTextField.getText(); 
	}
	
	public String getPasswordClientRegistry(){
		return userTextField.getText(); 
	}
	
	public String getNameClientRegistry(){
		return userTextField.getText(); 
	}
	
	public String getDescriptionClientRegistry(){
		return userTextField.getText(); 
	}
	
	public Date getBirtDateRegistry(){
		return userTextField.getDate(); 
	}
	
	//cadastro collection
	public String getNameCollectionRegistry(){
		return userTextField.getText(); 
	}
	
	public String getDescriptionCollectionRegistry(){
		return userTextField.getText(); 
	}
	
	public int getSizeCollectionRegistry(){
		return userTextField.getInt(); 
	}
	
	//cadastro publisher
	public String getnamePublisherRegistry(){
		return userTextField.getText(); 
	}
}
