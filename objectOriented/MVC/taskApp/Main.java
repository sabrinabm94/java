package objectOriented.MVC.taskApp;

import objectOriented.MVC.taskApp.controller.Controller;
import objectOriented.MVC.taskApp.model.dao.DAO;
import objectOriented.MVC.taskApp.model.Priority;
import objectOriented.MVC.taskApp.model.Task;
import objectOriented.MVC.taskApp.view.View;

import java.util.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.init();
	}
}
