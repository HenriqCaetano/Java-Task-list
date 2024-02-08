package com.todoList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.time.LocalDate;


public class Application {

    private LinkedList<Task> taskList;


    public Application(LinkedList<Task> taskList) {
        this.taskList = taskList;
    }

    public void start() {
        Scanner input = new Scanner(System.in);

        while (true) {
            writeMenu();

            try {
                int userInput = Integer.parseInt(input.nextLine());

                switch (userInput) {
                    case 1:
                        //criar nova tarefa
                        creationMenu(input);
                        break;
                    case 2:
                        //consultar tarefa por categoria, prioridade e status
                        displayMenu(input);
                        break;
                    case 3:
                        //deletar tarefas
                        deleteMenu(input);
                        break;
                    case 4:
                        return;
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void writeMenu() {
        System.out.println("1. Criar nova tarefa");
        System.out.println("2. Consultar tarefas atuais");
        System.out.println("3. Deletar uma tarefa");
        System.out.println("4. Finalizar programa");
        System.out.println("====================");
        System.out.print("Solicite uma ação: ");
    }

    private void creationMenu(Scanner s) {
        String name;
        String description;
        int priority;
        String category;

        int statusInput;
        Task.Status status;
        LocalDate deadline;

        try {
            System.out.print("Nome: ");
            name = s.nextLine();

            for (Task t : taskList) {
                if (t.getName().equals(name)) {
                    System.out.println("Já existe uma tarefa com este nome!");
                    return;
                }
            }

            System.out.print("Descrição: ");
            description = s.nextLine();

            System.out.print("Data limite no formato DD/MM/YYYY: ");
            String[] date = s.nextLine().split("/");
            deadline = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));

            System.out.print("Prioridade (1-5): ");
            priority = Integer.parseInt(s.nextLine());

            System.out.print("Categoria: ");
            category = s.nextLine();

            System.out.println("Status inicial:");
            System.out.println("1. Todo");
            System.out.println("2. Doing");
            System.out.println("3. Done");
            statusInput = Integer.parseInt(s.nextLine());

            if (statusInput == 1) status = Task.Status.todo;
            else if (statusInput == 2) status = Task.Status.doing;
            else status = Task.Status.done;
        } catch (Exception e) {
            System.out.println("Entrada inválida");
            System.out.println("A tarefa não foi criada com sucesso");
            return;
        }

        taskList.add(new Task(name, description, deadline, priority, category, status));
        taskList.sort(Task.taskComparator);
    }

    private void displayMenu(Scanner userIn) {
        try {
            System.out.println("1. Listar por Categoria");
            System.out.println("2. Listar por prioridade");
            System.out.println("3. Listar por status");
            System.out.println("Escolha como listar: ");
            int userChoice = Integer.parseInt(userIn.nextLine());

            if (userChoice == 1) {
                System.out.println("Categoria a ser listada: ");
                String targetCategory = userIn.nextLine();

                for (Task t : taskList) {
                    if (t.getCategory().equals(targetCategory)) {
                        System.out.println(t);
                    }
                }
            } else if (userChoice == 2) {
                System.out.println("Nível de prioridade a ser listado (1-5): ");
                int targetPriority = Integer.parseInt(userIn.nextLine());

                for (Task t : taskList) {
                    if (t.getPriority() == targetPriority) {
                        System.out.println(t);
                    }
                }

            } else if (userChoice == 3) {
                System.out.println("Status a ser listado: ");
                System.out.println("1. Todo");
                System.out.println("2. Doing");
                System.out.println("3. Done");
                int statusInput = Integer.parseInt(userIn.nextLine());

                Task.Status targetStatus;
                if (statusInput == 1) targetStatus = Task.Status.todo;
                else if (statusInput == 2) targetStatus = Task.Status.doing;
                else targetStatus = Task.Status.done;

                for (Task t : taskList) {
                    if (t.getStatus() == targetStatus) {
                        System.out.println(t);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida!");
        }
    }

    private void deleteMenu(Scanner userIn) {
        for (Task t : taskList) {
            System.out.println(t.getName());
        }
        System.out.println("Qual tarefa deve ser deletada?");
        System.out.println("Informe o nome: ");

        try {
            String targetTask = userIn.nextLine();

            taskList.removeIf(t -> t.getName().equals(targetTask));
        } catch (Exception e) {
            System.out.println("Entrada inválida.");
        }
    }
}


