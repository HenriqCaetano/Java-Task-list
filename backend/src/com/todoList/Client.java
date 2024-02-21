package com.todoList;


import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Client {
    public static void main(String[] args) {


        LinkedList<Task> taskList = new LinkedList<>();

        //menu para criar, ler e destruir as tarefas
        Application app = new Application(taskList);
        app.start();

        //todo:
        //consultar número de atividades em cada status
        //atualizar tarefas
        //filtrar por data
        //salvar os dados em arquivos

    }
}
