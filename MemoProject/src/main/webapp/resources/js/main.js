const deleteBtn = document.querySelector("#deleteBtn");

deleteBtn.addEventListener("click",()=>{
	
	//정말 삭제할 것인지 confirm()을 이용해서 확인
	//confirm()은 확인 클릭시 true,취소 클릭시 false반환
	
	//취소 클릭시 
	if(!confirm("정말 삭제했시겠습니까?")){
		return;
	}
	
	//확인 클릭시
	// /todo/delete?todoNo=6 GET방식 보내기
	location.href="/memo/delete?memoNo="+memoNo;
});