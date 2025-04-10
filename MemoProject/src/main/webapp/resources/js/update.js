const updateBtn = document.querySelector(".update.btn");

updateBtn.addEventListener("click", ()=>{
    const now = new Date();
    let year = now.getFullYear();
    let month = now.getMonth();
    let date = now.getDate();
    let hour = now.getHours();
    let minutes = now.getMinutes();

    if(month<10) month = '0' + month;
    if(date<10) date = '0' + date;
    if(hour<10) hour = '0' + hour;
    if(minutes<10) minutes = '0' + minutes;
})