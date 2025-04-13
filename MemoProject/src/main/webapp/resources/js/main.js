const logout = document.querySelector(".signOut");
logout.addEventListener("click", ()=>{

  if(!confirm("정말 로그아웃하시겠습니까?"))return;
    location.href = "/logout";
})

window.addEventListener("popstate", function(event) {
    history.pushState(null, "", location.href);
});