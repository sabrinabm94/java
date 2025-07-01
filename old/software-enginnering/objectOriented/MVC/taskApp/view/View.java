package objectOriented.MVC.taskApp.view;

import javaRepositories.Print;
import objectOriented.MVC.taskApp.model.Task;
import java.text.SimpleDateFormat;
import java.util.List;

public class View {
    public void show(List<Task> tasks){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Print.print("==============================");
        Print.print(" Task\t\t\t\t\tDate\t\tDone\tPriority");
        Print.print("==============================");

        for(Task task : tasks){
            Print.print(task.getName()
            + "\t"
            + f.format(task.getDate())
            + "\t"
            + task.isDone()
            + "\t"
            + task.getPriority());
        }
    }
}
