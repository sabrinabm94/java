package br.univille.poo.swing.login.controller;


import br.univille.poo.swing.login.model.LoginModel;
import br.univille.poo.swing.login.view.LoginView;

public class LoginController {
	
	private LoginModel model;
	private LoginView view;
	
	public LoginController(){
		model = new LoginModel();
		view = new LoginView();
	}
	
	public void initController(){
		view.getLoginButton().addActionListener(e -> doLogin());
	}
	
	private void doLogin(){
		
		if(view.getUser().length() < 1){
			view.setErrorMessage("Favor informar o usuário.");
		}else if(view.getPassword().length() < 1){
			view.setErrorMessage("Favor informar a senha.");
		}else if(view.getPassword().length() < 8){
			view.setErrorMessage("A senha deve conter no mínimo 8 caracteres.");
		}else if ("usuario".equals(view.getUser())
		   && "senha123".equals(view.getPassword())){
			view.setSuccessMessage("Seja bem vindos!");
		}else{
			view.setErrorMessage("O usuário ou a senha está incorreto");
		}
	}

}
