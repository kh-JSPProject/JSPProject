//목록으로 버튼 클릭시  "/"이동 (GET 요청)
const goToList = document.querySelector("#goToList");


//목록으로 버튼이 클릭된 경우
goToList.addEventListener("click",()=>{

  //  "/"메인페이지 요청 (get 방식)
  location.href="/";

});

//할일 상세 조회 페이지에서 쿼리스트링 값 얻어오기
//url 에서 얻어오면 된다!(쿼리스트링 부분 : 주소 ?todoNo=6)

//location.search :쿼리스트링만 얻어오기
//URLSearchParams():쿼리스트링을 객체 형태로 다룰 수 있는 객체
const todoNo = new URLSearchParams(location.search).get("memoNo");








