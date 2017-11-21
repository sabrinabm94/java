package bookRegistry;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class View  {
	private JFrame frame;
	private JTextField userTextField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel statusLabel;
	
	public void LoginView(){
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
		

		JLabel labelUser = new JLabel("Usuário",JLabel.RIGHT);
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
	
	public String getUser(){
		return userTextField.getText();
	}
	
	public String getPassword(){
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
}
