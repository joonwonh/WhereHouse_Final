window.onload = function () {
	var nn = document.getElementById('curNickName').value;
	console.log(nn);
	var nickName = document.getElementById('writeRuleHead');
	var writePage = document.getElementById('writePage');
	
	if(nn) { // 로그인 안 한 상태
	  nickName.innerText = "로그인을 해주세요.";
	  writePage.style.display = "none";
	}
	else	{
		nickName.innerText = nn + " 님";
		writePage.style.display = "block";
	}

}

