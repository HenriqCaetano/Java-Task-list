package com.todoList;
import java.util.Date;
import java.util.Objects;


public class Task implements Comparable{

    public enum Status{
        todo,
        doing,
        done
    }

    private String name;
    private String description;
    private Date deadline;
    private int priority;
    private String category;
    private Status status;


    public Task(String name, String description, Date deadline, int priority, String category, Status status) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }

    //overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    //TODO
    @Override
    public int compareTo(Object o) {
        return 0;
    }


    //getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public int getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    public Status getStatus() {
        return status;
    }
}
