window.onload = function() {
	
	document.querySelector('.editbutton').addEventListener('click', function(){
		if(confirm("수정하시겠습니까?"))	{
			alert("수정되었습니다.");
			this.submit();
		}
		else	{
			alert("취소되었습니다.");
		}
	});

	document.querySelector('.listbutton').addEventListener('click', function(){

		alert("전체 글 목록으로 이동합니다.");
		window.location.href = '/wherehouse/page/list';
	});
}