package com.todoList;

import java.time.LocalDate;
import java.util.Comparator;


public class Task {

    public enum Status {
        todo,
        doing,
        done
    }

    private String name;
    private String description;
    private LocalDate deadline;
    private int priority;
    private String category;
    private Status status;
    public static final Comparator<Task> taskComparator = new Comparator<Task>() {
        @Override
        public int compare(Task task, Task t1) {
            return Integer.compare(task.getPriority(), t1.getPriority());
        }
    };


    public Task(String name, String description, LocalDate deadline, int priority, String category, Status status) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }


    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", priority=" + priority +
                ", category='" + category + '\'' +
                ", status=" + status +
                '}';
    }

    //getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
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
