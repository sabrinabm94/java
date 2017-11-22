package br.univille.poo.swing.login.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginView {
	
	private JFrame frame;
	private JTextField userTextField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel statusLabel;
	
	public LoginView(){
		frame = new JFrame("Login");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		//GroupLayout layout = new GroupLayout(panel);
		//layout.setAutoCreateGaps(true);
		//layout.setAutoCreateContainerGaps(true);
		
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

			
		
		/*
		layout.setHorizontalGroup(layout.createSequentialGroup()
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(labelUser)
			    .addComponent(userTextField))
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(labelPass)
					    .addComponent(passwordField))
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(statusLabel))
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(loginButton)));
		
		layout.linkSize(SwingConstants.HORIZONTAL, userTextField, passwordField,loginButton,statusLabel,labelUser,labelPass);
		*/
		/*
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(new JLabel("Password",JLabel.RIGHT))
					    .addComponent(passwordField)));*/
		
			    //

		
		
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
