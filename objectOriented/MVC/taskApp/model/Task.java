package objectOriented.MVC.taskApp.model;

import java.util.Date;

public class Task {
    private long id;
    private String name;
    private int priority;
    private Date date;
    private boolean done;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
}
