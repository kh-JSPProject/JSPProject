//제목이 작성되지 않은 경우 form 제출 막기

const addForm = document.querySelector("#addForm");//form태그
const title = document.querySelector("[name=title]");//input 태그


//addForm이 제출 될 때
addForm.addEventListener("submit",(e)=>{

//e: 이벤트 객체


//제목 입력된 값 가져와서 양쪽 공백 제거 
const input = title.value.trim();


//제목이 입력되지 않았을 때
if(input.length===0){
  //form태그 제출 이벤트 막기
  e.preventDefault();

  alert("제목을 입력해주세요!");
  title.focus();
}


}); 