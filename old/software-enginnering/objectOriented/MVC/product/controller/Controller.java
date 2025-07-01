package objectOriented.MVC.product.controller;

import objectOriented.MVC.product.model.Product;
import objectOriented.MVC.product.model.dao.DAO;
import objectOriented.MVC.product.view.View;

public class Controller {
    private Product model;
    private View view;
    private DAO dao;

    public Controller(){
        model = new Product();
        view = new View();
        dao = new DAO();
    }

    public void init(){
        Product product = dao.createDefaultProduct();
        view.show(product);
    }
}