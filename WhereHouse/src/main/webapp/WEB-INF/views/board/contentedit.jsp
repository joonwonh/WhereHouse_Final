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
				<title>WhereHouse</title>
				<script language="JavaScript" src="/wherehouse//js/contentedit.js"></script>
				<link href="/wherehouse/css/contentedit.css?ver=123" rel="stylesheet">
				<link rel="stylesheet" href="/wherehouse/css/list.css?ver=125">

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
		<div id="listPage">
			<a href="/wherehouse/page/list" id="listPageBtn" >목록으로 돌아가기</a>
		</div>
		<div id="logo-img"><img src="../images/home_icon.png" alt=""></div>
	</aside>
			
    <main id="mainContent">
        <a id="listLogo">Where House</a>
        <form action="modify" id="modifyform" method="post">

            <input type="hidden" name="bId" value="<%=bId %>" />

            <table id="topHeader">
                <tr>
                    <th >
                        <textarea class="title" name="title" id="listTitle"><%=title %></textarea>
                    </th>

                    <th class="listGu">
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
                    </th>
                </tr>
            </table>

            <table id="botHeader">
                <tr>
                    <th id="listNickName">${nickname}</th>
                    <th id="listHit">조회수 : <%=bHit %>
                    </th>
                    <th id="listDate">
                        <%=bDate %>
                    </th>
                </tr>

            </table>

            <div id="listContent">
                <div id="listContents">
                    <textarea rows="10" cols="54" name="bcontent" class="bcontent" id="writeCont2"><%=bContent %></textarea>
                </div>
                <button value="글 수정 완료하기" type="submit" class="editbutton" id="editBtn">수정 하기</button>
            </div>
        </form>
    </main>
			</body>

			</html>