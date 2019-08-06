package objectOriented.MVC.login.controller;

import objectOriented.MVC.login.model.Model;
import objectOriented.MVC.login.view.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(){
        model = new Model();
        view = new View();
    }

    public void init(){
        view.getLoginButton().addActionListener(e -> doLogin());
    }

    private void doLogin(){
        if(view.getUser().length() < 1){
            view.setErrorMessage("Favor informar o usu�rio.");
        }else if(view.getPassword().length() < 1){
            view.setErrorMessage("Favor informar a senha.");
        }else if(view.getPassword().length() < 8){
            view.setErrorMessage("A senha deve conter no m�nimo 8 caracteres.");
        }else if ("usuario".equals(view.getUser())
                && "senha123".equals(view.getPassword())){
            view.setSuccessMessage("Seja bem vindos!");
        }else{
            view.setErrorMessage("O usu�rio ou a senha est� incorreto");
        }
    }
}
