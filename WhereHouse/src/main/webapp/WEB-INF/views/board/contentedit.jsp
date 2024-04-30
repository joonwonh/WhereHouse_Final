<!-- 선택된 글을 수정하는 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<% String bId=request.getParameter("bId"); String title=request.getParameter("title"); String
			bDate=request.getParameter("boardDate"); String bHit=request.getParameter("boardHit"); String
			bContent=request.getParameter("boardContent"); String nickname=(String) session.getAttribute("nickname"); %>

			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>

			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<title>게시글 수정 페이지</title>
				<script language="JavaScript" src="/wherehouse//js/contentedit.js"></script>
				<link href="/wherehouse/css/contentedit.css" rel="stylesheet">
			</head>

			<body>
				<h1 class="maintitle">게시글 수정 페이지</h1>
				<form action="modify" id="modifyform" method="post">
				
					<input type="hidden" name="bId" value="<%=bId %>" />  				<!-- 게시글 ID -->
					
					
					<div class="headerTitle">
							<textarea class="title" name="title" ><%=title %></textarea>		<!--  게시글 제목 -->
					</div>
					
					<table class="headerTbl">
						<tr>
							<th class="attributeBox">작성자</th><th class="valueBox">${nickname}</th>
						</tr>
						<tr>
							<th class="attributeBox">게시글 지역</th>
								<th class="valueBox">
									<select name="regions" class="regions">						<!-- 게시글 선택 지역 -->
										<option value="default">지역구를 선택해주세요</option>
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
								</th>
						</tr>
						<tr>	<!-- 게시글 날짜 -->
							<th class="attributeBox">작성 날짜</th><th class="valueBox"><%=bDate %></th>
						</tr>
						<tr>	<!-- 조회수 -->
							<th class="attributeBox">조회수</th><th class="valueBox"><%=bHit %></th>
						</tr>
					</table>							

					<!-- 게시글 본문 들어가는 부분-->
					<div class="boardContent">
						<textarea rows="10" cols="54" name="bcontent" class="bcontent"><%=bContent %></textarea>		<!-- 게시글 본문 -->
					</div>
					<button value="글 수정 완료하기" type="submit" class="editbutton" style="width:100px; heigth:50px;">
						수정 완료</button>

					<button value="전체 글 목록 보기" type="button" class="listbutton" style="width:100px; heigth:50px;">
						전체 글 보기</button> <!-- list.do 요청 -->
				</form>
			</body>

			</html>