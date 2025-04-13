document.querySelectorAll('.formRow input').forEach(input => {
    input.addEventListener('focus', function() {
        this.parentElement.style.flexDirection = 'column';
        this.parentElement.style.alignItems = "flex-start";
        this.parentElement.style.gap = 0;

        this.parentElement.querySelector("label").style.fontSize = '12px';
        this.parentElement.querySelector("label").style.color = '#5B5B5B';
    });
    input.addEventListener('blur', function() {
        // 포커스 해제 시 원래대로
        this.parentElement.style.flexDirection = 'row'; 
        this.parentElement.style.alignItems = "center";
        this.parentElement.style.gap = "15px";

        this.parentElement.querySelector("label").style.fontSize = '16px';
        this.parentElement.querySelector("label").style.color = '#000';
    });
});
