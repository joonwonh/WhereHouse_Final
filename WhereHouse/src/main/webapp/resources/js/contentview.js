window.onload = function () {

	document.querySelector('.editbutton').addEventListener('click', function () {
		var writerId = document.querySelector('.writerId').value; 	
		var sessionId = document.querySelector('.sessionId').value; 

		if (writerId == sessionId) {

			console.log('수정 페이지 "contentedit.jsp" 이동');
			document.getElementById('modifyform').submit();

		} else {	

			alert("현재 사용자는 게시글 작성자와 다릅니다.");
		}
	});

	document.querySelector('.deletebutton').addEventListener('click', function () {
		var sessionId = document.querySelector('.sessionId').value;
		var writerId = document.querySelector('.writerId').value; 	

		if (writerId == sessionId) {
			var bId = document.querySelector('.bId').value;
			if(confirm("삭제하시겠습니까?"))	{
				alert("삭제되었습니다.");
				window.location.href = `/wherehouse/delete/${bId}`;
			}
			else	{
				alert("취소되었습니다.");
			}
		} 
		else if (writerId != sessionId) {

			alert("현재 사용자와 게시글 작성자가 다르므로 삭제할 수 없습니다.");
			event.preventDefault();
			return;
		}
	});

	document.querySelector('.replybutton').addEventListener('click', function () {

		var sessionId = document.querySelector('.sessionId').value;
		var replyvalue = document.querySelector('.replyvalue').value;

		if (sessionId == 'null') {
			alert("로그인 한 사용자가 아닙니다");
		} 
		else if (replyvalue == "") {		
			alert("댓글 작성 내용이 없습니다!!.");
		} 
		else {
			if(confirm("댓글을 추가하시겠습니까?"))	{
				alert("댓글이 추가되었습니다.");
				document.getElementById('replyform').submit();
			}
			else	{
				alert("취소되었습니다.");
			}
		}
	});
}