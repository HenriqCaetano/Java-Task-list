package com.todoList;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        //armazena as tarefas, não permite duplicatas
        LinkedHashSet<Task> taskList = new LinkedHashSet<>();
        //menu para criar, ler e destruir as tarefas

        Menu app = new Menu(taskList);
        app.start();

        //ordenar pela prioridade

        //opcional:
        //consultar número de atividades em cada status (todo, doing, done)
        //atualizar tarefas
        //filtrar por data
        //salvar os dados em arquivos

    }
}
