const submitButton = document.getElementById("submit-button");
const taskList = document.getElementById("task-list");
let tasks = [];


submitButton.onclick = (e) => {
    e.preventDefault();
    taskList.innerHTML = '';

    let form = document.getElementById("creation-form");
    let formData = new FormData(form);
    let task = {}

    formData.forEach((value, key) => {
        if(!value){
            task = null;
            return;
        }
        task[key] = value;
    })
    if(task) tasks.push(task);

    console.log(tasks)
    tasks.forEach((value) => {
        taskList.innerHTML += `<li>${value.nome} ${value.descricao} ${value.dataLimite} ${value.categoria} ${value.prioridade}</li>`
    })
}


