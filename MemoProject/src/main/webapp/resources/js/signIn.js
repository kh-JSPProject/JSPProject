console.log("singIn.js loaded");

document.addEventListener("DOMContentLoaded", () => {
  // .signUpBtn 클래스를 가진 요소를 선택하여 변수에 할당
  const signUpBtn = document.querySelector(".signUpBtn");

  if (signUpBtn) {
      signUpBtn.addEventListener("click", () => {
          console.log("signUpBtn clicked");
          // 버튼 클릭 시 /signup 페이지로 이동
          location.href = "/signup";
      });
  } else {
      console.error("signUpBtn 요소를 찾을 수 없습니다.");
  }
});
