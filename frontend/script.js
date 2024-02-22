const submitButton = document.getElementById("submit-button");
const taskList = document.getElementById("task-list");
let tasks = [];

submitButton.onclick = (e) => {
    e.preventDefault();
    taskList.innerHTML = '';

    let form = document.getElementById("creation-form");
    let formData = new FormData(form);
    let task = {}

    //constroi o objeto tarefa
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
    for(let i in tasks){
        if(task.nome === tasks[i].nome){
            task = null;
            alert("Tarefa já existente")
            break;
        }
    }
    if(task) tasks.push(task);


    tasks.forEach((value) => {
        let taskDisplay = `Tarefa:${value.nome}, Descrição: ${value.descricao}, Prioridade: ${value.prioridade}, Categoria: ${value.categoria}, Entrega: ${value.dataLimite} Status:${value.status}.`
        taskList.innerHTML += `<li>${taskDisplay} <button>Deletar</button></li>`
    })
}


