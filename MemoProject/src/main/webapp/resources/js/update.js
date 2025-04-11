const formUpdate = document.querySelector("#formUpdate");

formUpdate.addEventListener("submit", (e)=>{
    const check = confirm("수정하시겠습니까?");
    if (!check) {
        e.preventDefault();
        return;
    }

    const now = new Date();
    let year = now.getFullYear();
    let month = now.getMonth() + 1;
    let date = now.getDate();
    let hour = now.getHours();
    let minute = now.getMinutes();

    if(month<10) month = '0' + month;
    if(date<10) date = '0' + date;
    if(hour<10) hour = '0' + hour;
    if(minute<10) minute = '0' + minute;

    const update = `${year}-${month}-${date} ${hour}:${minute}`;

    const updateDate = document.querySelector(".updateDate");
    updateDate.value = update;
})