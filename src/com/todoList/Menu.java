package com.todoList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Scanner;

//menu não está um nome legal para essa classe...
public class Menu {

    private LinkedHashSet<Task> taskList;


    public Menu(LinkedHashSet<Task> taskList) {
        this.taskList = taskList;
    }

    public void start(){
        Scanner input = new Scanner(System.in);

        while(true){
            writeMenu();
            String userInput = input.nextLine();

            switch (userInput){
                case 1:
                    //criar nova tarefa
                    creationMenu(input);
                case 2:
                    //consultar tarefa por categoria, prioridade e status
                case 3:
                    //deletar tarefas
                case 4:
                    //indefinido, por enquanto
            }

        }
    }
    private void writeMenu(){
        System.out.println("1. Criar nova tarefa");
        System.out.println("2. Consultar tarefas atuais");
        System.out.println("3. Deletar uma tarefa");
        System.out.println("4. Finalizar programa");
        System.out.println("====================");
        System.out.print("Solicite uma ação: ");
    }


    private void creationMenu(Scanner s){
        String name;
        String description;
        Date deadline;
        int priority;
        String category;

        int statusInput;
        Task.Status status;


        System.out.print("Nome: ");
        name = s.nextLine();

        System.out.print("Descrição:");
        description = s.nextLine();

        System.out.print("Data limite: ");
        //TODO: trabalhar com datas
        deadline = new Date(s.nextLine());

        System.out.print("Prioridade: ");
        priority = s.nextInt();

        System.out.print("Categoria: ");
        category = s.nextLine();

        System.out.println("Status inicial:");
        System.out.println("1. Todo");
        System.out.println("2. Doing");
        System.out.println("3. Done");
        statusInput = s.nextInt();

        if(statusInput == 1) status = Task.Status.todo;
        else if(statusInput == 2) status = Task.Status.doing;
        else status = Task.Status.done;

        taskList.add(new Task(name, description, deadline, priority, category, status));
    }
}
