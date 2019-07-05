package objectOriented.MVC.taskApp.dao;

import objectOriented.MVC.taskApp.model.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Connection mConn;

    private List<Task> tasks;

    public DAO(){
        tasks = new ArrayList<Task>();
        mConn = (new ConnectionFactory()).getConnection();
    }

    public void add(Task task){
        String sql = "insert into tarefa(name, priority, date, done)" + "values(?,?,?,?);";

        try{
            PreparedStatement stmt = mConn.prepareStatement(sql);
            // troca os ? pelos valores da Tarefa.
            stmt.setString(1, task.getName());
            stmt.setInt(2, task.getPriority());
            // Para salvar a Data no banco de dados
            // tem que usar o java.sql.Date
            stmt.setDate(3, new java.sql.Date(task.getDate().getTime()));
            stmt.setBoolean(4, task.isDone());

            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");

        } catch (Exception e) {
            System.out.println("Erro "+e.getMessage());
            e.printStackTrace();
        }
    }

    public int getAmount(){
        return tasks.size();
    }

    public List<Task> getAll(){
        List<Task> lista = new ArrayList<>();
        String sql = "select * from tarefa ";

        try{
            PreparedStatement stmt = mConn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                Task t = new Task();
                // obtem o valor da coluna nome
                t.setName(result.getString("name"));
                t.setPriority(result.getInt("priority"));
                t.setDate(result.getDate("date"));
                t.setDone(result.getBoolean("done"));
                lista.add(t);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<Task> getAllNotDoneTasks(){
        List<Task> taskList = new ArrayList<Task>();

        for(Task task : tasks){
            if(!task.isDone()){
                taskList.add(task);
            }
        }

        return taskList;
    }
}
