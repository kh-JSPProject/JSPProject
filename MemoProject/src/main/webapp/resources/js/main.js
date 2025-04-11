const logout = document.querySelector(".signout");
logout.addEventListener("click", ()=>{
    location.href = "/logout";
})



window.addEventListener("pageshow", function(e) {
    if (e.persisted) {
      location.reload(); // 🔁 캐시로 열린 경우 강제로 새로고침
    }
  });

  // // 현재 페이지 상태를 히스토리에 
// history.pushState(null, "", location.href);

// /* 뒤로 가기  이벤트가 발생하면 현재 페이지 상태를 다시 푸시하여 메인 페이지를 유지시킴 
// 즉 뒤로가기를 해도 뒤로가기를 안한 상태를 유지시키는 밤식이 제일 나을듯 
// signIn.js도 참고하세요
// */


// window.addEventListener("popstate", function(event) {
//     history.pushState(null, "", location.href);
// });