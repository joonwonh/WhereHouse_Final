<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>

		<meta http-equiv="Content-Type" charset="text/html;charset=UTF-8">
		<script language="JavaScript" src="./js/writedo.js"></script>
		<title>WhereHouse</title>
		<link rel="stylesheet" href="css/list.css?ver=123">
		<link rel="stylesheet" href="./css/write.css?ver=123">
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link
		href="https://fonts.googleapis.com/css2?family=Courgette&family=Kdam+Thmor+Pro&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap"
		rel="stylesheet">
	</head>

	<body>
	   <aside id="side-bar">
	      <div class="board-info">
	         자유 게시판
	      </div>
	      <div id="wirteRule">
	         <div id="writeRuleHead">작성 규칙!</div> 
	         <hr class="gu_name_hr">
	      </div>
	      <a href="/wherehouse/page/list">목록으로 돌아가기</a>
	      <div id="writePage">
	         <button type="button" onclick="writepage()" id="writePageBtn">글 작성하러 가기!</button>
	      </div>
	      <div id="logo-img"><img src="../images/home_icon.png" alt=""></div>
   </aside>
	
	<div id="writeMain">

		<form action="./writeboard" name="writefrm" method="post">
			<input type="hidden" name="id" value="${sessionScope.id}">
			<a id="listLogo">Where House</a>

			<table class="writeSection1">
				<tr>
					<td id="writeTitle1">제목</td>
					<td><textarea name="title" class="title" rows="1" cols="50" id="writeTitle2"></textarea></td>
					<td>
						<select style="cursor: pointer;" name="regions" class="regions">
							<option value="선택 지역 없음">지역구를 선택해주세요</option>
							<option value="강남구">강남구</option>
							<option value="강동구">강동구</option>
							<option value="강북구">강북구</option>
							<option value="강서구">강서구</option>
							<option value="관악구">관악구</option>
							<option value="광진구">광진구</option>
							<option value="구로구">구로구</option>
							<option value="금천구">금천구</option>
							<option value="노원구">노원구</option>
							<option value="도봉구">도봉구</option>
							<option value="동대문구">동대문구</option>
							<option value="동작구">동작구</option>
							<option value="마포구">마포구</option>
							<option value="서대문구">서대문구</option>
							<option value="서초구">서초구</option>
							<option value="성동구">성동구</option>
							<option value="성북구">성북구</option>
							<option value="송파구">송파구</option>
							<option value="양천구">양천구</option>
							<option value="영등포구">영등포구</option>
							<option value="용산구">용산구</option>
							<option value="은평구">은평구</option>
							<option value="종로구">종로구</option>
							<option value="중구">중구</option>
							<option value="중랑구">중랑구</option>
						</select>
					</td>
				</tr>
			</table>

			<table class="writeSection2">
				<tr>
					<td id="writeCont1">내용</td>
					<td><textarea name="bcontent" class="bcontent" rows="15" cols="50" id="writecont2"></textarea></td>
					<td><input type="button" onclick="writedo()" value="작성하기" id="writeBtn"></td>
				</tr>
			</table>
		</form>
	</div>
	</body>

	</html>