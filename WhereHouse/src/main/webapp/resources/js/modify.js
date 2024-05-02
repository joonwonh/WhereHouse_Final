window.onload = function () {


    document.getElementById('memberEditBtn').addEventListener("click", function () {


        var pw = $('input[id="pw"]').val();  
        var pwcheck = $('input[id="pwcheck"]').val(); 
        var nickname = $('input[id="nickname"]').val();
        var tel = $('input[id="tel"]').val();  
        var email = $('input[id="email"]').val();  

        if (pw == '') {
            alert('비밀번호를 입력하세요!');
            return;
        } else if (pwcheck == '') {
            alert('비밀번호 확인 정보를 입력하세요!');

            return;
        } else if (pw != pwcheck) {
            alert('비밀번호와 비밀번호 확인 내용이 다릅니다!');

            return;

        } else if (nickname == '') {
            alert('닉네임을 입력하세요!');
            return;
        } else if (tel == '') {
            alert('전화번호를 입력하세요!');
            return;
        } else if (email == '') {
            alert('이메일을 입력하세요!');
            return;
        }

		if(confirm("수정하시겠습니까?"))	{
			alert("수정되었습니다.");
			document.getElementById('reg_frm').submit();
		}
		else	{
			alert("취소되었습니다.");
		}
         
    });
}
