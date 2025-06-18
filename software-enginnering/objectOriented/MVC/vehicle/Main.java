package objectOriented.MVC.vehicle;

import objectOriented.MVC.vehicle.controller.Controller;
import objectOriented.MVC.vehicle.model.dao.DAO;
import objectOriented.MVC.vehicle.model.Vehicle;
import objectOriented.MVC.vehicle.view.View;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.init();
    }
}

