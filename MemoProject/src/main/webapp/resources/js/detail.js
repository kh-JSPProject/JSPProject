//목록으로 버튼 클릭 시 "/" 이동(GET 요청)
const gomain =document.querySelector("#goMain");

// 목록으로 버튼이 클릭된 경우
gomain.addEventListener("click",()=>{
  //"/" 메인페이지 요청(GET 방식)
  location.href= "/main";
});


// 할 일 상세 조회 페이지에서 쿼리스트링 값 얻어오기
// url 에서 얻어오면 된다 (쿼리스트링 부분 : ?todoNo=6)

//location.search : 쿼리스트링만 얻어오기
//URLSearchParams() : 쿠리스트링을 객체 형태로 다룰수 있는 객체
const memoNo = new URLSearchParams(location.search).get("memoNo");

// console.log(todoNo);


// 완료 여부 변경
// const completeBtn = document.querySelector("#completeBtn");
// completeBtn.addEventListener("click",()=>{

//   //현재 보고있는 Todo의 완료 여부를
//   //O(true) <-> X(false) 변경 요청하기 (GET 요청)
//   location.href="/todo/complete?todoNo="+todoNo;

// });


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


// 왼쪽 화살표 오른쪽 화살표

document.addEventListener("keyup", function(event) {
  const prevBtn = document.querySelector("#prevBtn");
  const nextBtn = document.querySelector("#nextBtn");

  if (event.key === "ArrowLeft") {
    if (prevBtn && !prevBtn.disabled) {
      prevBtn.click();
    }
  } else if (event.key === "ArrowRight") {
    if (nextBtn && !nextBtn.disabled) {
      nextBtn.click();
    }
  }
});