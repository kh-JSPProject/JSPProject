signUpBtn = document.querySelector('.signUpBtn');

document.querySelectorAll('.protectedLink').forEach(function(link) {
    link.addEventListener('click', function(e) {
        e.preventDefault(); // 링크 이동을 못하게 하는 이벤트 리스너
        alert("먼저 로그인해주세요.");
    });
});

// .protectedLink라는 css선택자를 클릭할 때마다  무조건 alert("먼저 로그인해주세요.")를 띄우고 링크 이동을 차단하는 스크립트 


signUpBtn.addEventListener('click', ()=>{
    location.href = "/signup";
}) 





/* 뒤로 가기  이벤트가 발생하면 현재 페이지 상태를 다시 푸시하여 메인 페이지를 유지시킴 
즉 뒤로가기를 해도 뒤로가기를 안한 상태를 유지시키는 밤식이 제일 나을듯 
브라우저의 '뒤로/앞으로' 기능 때문에 캐시에 저장된 페이지를 불러올 때 호출 되는 함수 즉 signIn으로 오려고 할때 
mian.js에 있는 코드는 그걸 막아주는데 다시 main을 보여주기 위해 이 코드가 꼭 필요하다.
오래된 상태의 페이지 대신 최신 상태의 페이지를 보여주는 코드라고 이해하면 쉽다. 
main.js도 참고하세요
*/


window.addEventListener('pageshow', function(event) {
    if (event.persisted) {  // 비포캐시, 즉 이전에 저장되었던 캐시가 복원되려는 명령이 생겼을 때
        window.location.reload(); // 비포 캐시에 있던 값은 무시하고 현재 페이지만 보여준다는 의미
    }
});
