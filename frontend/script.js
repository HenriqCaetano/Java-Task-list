const submitButton = document.getElementById("submit-button");
const taskList = document.getElementById("task-list");
let tasks = [];

//evento para processar o formulário
submitButton.onclick = (e) => {
    e.preventDefault();

    let formData = new FormData(form);
    let form = document.getElementById("creation-form");
    let task = {}

    //constrói o objeto tarefa
    formData.forEach((value, key) => task[key] = value)

    //verifica se todos os campos estão presentes
    for (let i in Object.values(task)) {
        if (!Object.values(task)[i]) {
            alert("campos em branco")
            task = null;
            return;
        }
    }

    //verifica se há duplicata
    let updatedFlag = false; //inicialmente considera que não haverá atualização
    tasks.forEach((value, index, array) => {
        //atualiza a tarefa, caso ela já exista
        if (value.nome === task.nome) {
            array[index] = task;
            updatedFlag = true
            alert(`Tarefa ${task.nome} atualizada`)
        }
    })

    if (task && !updatedFlag) tasks.push(task);
    taskList.innerHTML = '';
    tasks.forEach(displayTasks);
}

//lista para mostras as tarefas atuais
const displayTasks = (value) => {
    let taskDisplay = `Tarefa:${value.nome}, Descrição: ${value.descricao}, Prioridade: ${value.prioridade}, Categoria: ${value.categoria}, Entrega: ${value.dataLimite} Status:${value.status}.`
    taskList.innerHTML += `<li>${taskDisplay} <button onclick='deleteTask()'>Deletar</button></li>`
}

//lida com a deleção de tarefas
const deleteTask = () => {
    let taskToBeDeleted = event.target.parentNode.innerHTML.slice(7).split(",")[0]
    tasks.forEach((value, index, array) => {
        if (value.nome === taskToBeDeleted) {
            array.splice(index, 1); //retira a tarefa. como os nomes são únicos, apenas uma será deletada
        }
    })
    //atualiza o display de tarefas
    taskList.innerHTML = '';
    tasks.forEach(displayTasks);
}

