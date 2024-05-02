var paginationbtns;    

window.onload = function () {
    var paginationbtns = document.querySelectorAll('.paginationbtn button');
    for (var i = 0; i < paginationbtns.length; i++) {
        (function(i) {
            paginationbtns[i].addEventListener('click', function () {
                window.location.href = `../list/${i}`;
                console.log("for문 i 값 : " + i);
                let n = i + 1;
            });
        })(i);
    }
}

function writepage() {

    var Nickname = document.querySelector(".nickname").value;

    if (Nickname != 'null') {

        alert("글 작성 페이지로 이동합니다.");
        window.location.href = '../writepage'

    } else {
        alert("글 작성은 로그인한 회원만 가능합니다.");
    }
}