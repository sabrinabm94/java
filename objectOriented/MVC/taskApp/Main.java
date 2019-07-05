package objectOriented.MVC.taskApp;

import objectOriented.MVC.taskApp.dao.DAO;
import objectOriented.MVC.taskApp.model.Priority;
import objectOriented.MVC.taskApp.model.Task;
import objectOriented.MVC.taskApp.view.View;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Task> tasks = dao.getAll();

        View view = new View();
        view.show(tasks);

		Task task = new Task();
        task.setName("Creating task...");
        task.setDate(new Date());
        task.setDone(true);
        task.setPriority(Priority.LOW);
		dao.add(task);

		task = new Task();
		task.setName("Listar todos os itens da cole��o");
		task.setDate(new Date());
		task.setDone(true);
		task.setPriority(Priority.NORMAL);
		dao.add(task);

        task = new Task();
		task.setName("Listar as tarefas n�o realizadas");
		task.setDate(new Date());
		task.setDone(true);
		task.setPriority(Priority.HIGHT);
		dao.add(task);

        task = new Task();
		task.setName("Listar as tarefas por prioridade");
		task.setDate(new Date());
		task.setPriority(Priority.HIGHT);
		dao.add(task);

		tasks = dao.getAll();
		view.show(tasks);
    }
}
