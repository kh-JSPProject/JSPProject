const memoNo = new URLSearchParams(location.search).get("memoNo");

//로그아웃 버튼
const logOutBtn = document.querySelector("#logout");
logOutBtn.addEventListener("click",()=>{

  if(!confirm("정말 로그아웃하시겠습니까?"))return;
  location.href= "/logout";
});

// 삭제 버튼
const deleteBtn = document.querySelector("#deleteBtn");
deleteBtn.addEventListener("click",()=>{

  if(!confirm("정말 삭제하시겠습니까?"))return;

  location.href="/memo/delete?memoNo="+memoNo;
});

// 수정 버튼
const updateBtn = document.querySelector("#updateBtn");
updateBtn.addEventListener("click",()=>{
  //수정할 수 있는 화면을 요청(GET 방식)
  location.href="/memo/update?memoNo="+memoNo;
});

