<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String sessionId=(String) session.getAttribute("id"); 
String sessionNickname=(String) session.getAttribute("nickname"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>WhereHouse</title>
	<script language="JavaScript" src="/wherehouse/js/contentview.js?ver=123"></script>
	<link href="/wherehouse/css/contentView.css?ver=125" rel="stylesheet">
	<link rel="stylesheet" href="/wherehouse/css/list.css?ver=123">
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Courgette&family=Kdam+Thmor+Pro&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
</head>

<body>
	<aside id="side-bar">
		<div class="board-info">
			자유 게시판
		</div>
		<!-- 
      <div id="wirteRule">
         <div id="writeRuleHead" value=""><%=sessionNickname%> 님</div> 
      </div>
       -->
		<div id="listPage">
			<a href="/wherehouse/page/list" id="listPageBtn" >목록으로 돌아가기</a>
		</div>
		<div id="logo-img"><img src="../images/home_icon.png" alt=""></div>
	</aside>



	<main id="mainContent">
		<a id="listLogo">Where House</a>
		<form action="../modifypage" id="modifyform" method="post">
			<input type="hidden" name="sessionId" class="sessionId" value="<%=sessionId %>">
			<input type="hidden" name="writerId" class="writerId" value="${content_view.userid}">
			<input type="hidden" name="bId" class="bId" value="${content_view.contentnum}">				
			<input type="hidden" name="title" class="title" value="${content_view.title}" />					
			<input type="hidden" name="boardContent" class="bcontent" value="${content_view.bcontent}" />	
			<input type="hidden" name="region" class="region" value="${content_view.region}" />				
			<input type="hidden" name="boardDate" class="bDate" value="${content_view.bdate}" />			
			<input type="hidden" name="boardHit" class="hit" value="${content_view.hit}" />			

			<table id="topHeader">
				<tr>
					<th id="listTitle">${content_view.title}</th>
					<th id="listGu">${content_view.region}</th>
				</tr>
			</table>
			<table id="botHeader">
				<tr>
					<th id="listNickName">${nickname}</th>
					<th id="listHit">조회수 : ${content_view.hit}</th>
					<th id="listDate">${content_view.bdate}</th>
				</tr>
			
			</table>

			<div id="listContent">
				<div id="listContents">
						${content_view.bcontent} 
				</div>
				<div id="contentBtn">
					<button value="글 페이지로 이동하기" type="button" class="editbutton" class="contBtn"  id="editBtn">수정</button>
					<button value="해당 글 삭제하기" type="button" class="deletebutton"  class="contBtn"  id="delBtn">삭제</button>
				</div>
			</div>
		</form>

		<form action="../replyWrite" id="replyform" method="post">
	
			<input type="hidden" name="sessionId" class="sessionId" value="<%=sessionId %>"> 
			<input type="hidden" name="writerId" class="writerId" value="${content_view.userid}">
			<input type="hidden" name="bId" class="bId" value="${content_view.contentnum}">								
			<input type="hidden" name="title" class="title" value="${content_view.title}" />				
			<input type="hidden" name="boardContent" class="bcontent" value="${content_view.bcontent}" />

			<div id="replyBox">
				<div>
					<textarea id="listReply" rows="7" cols="54" name="replyvalue" class="replyvalue"
						placeholder="댓글을 작성해주세요."></textarea>
				</div>
				<div>
					<button id="replyBtn" button value="댓글 작성하기" type="button" class="replybutton">작성</button>
				</div>
			</div>
		</form>
		
		<div id="replyTitle">댓글 목록</div>
		<div id="replyList">
			<table class="commnetTbl" id="replyComment">
				<c:forEach var="comments" items="${comments}">
				<tr class="showcomment">
					<td class="commentUser" id="commentUser">${comments.nickname}</td>
				</tr>
				<tr class="showcomment" id="commentDiv">
					<td class="commentContent" id="commentContent">${comments.content}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</main>
		
</body>

</html>