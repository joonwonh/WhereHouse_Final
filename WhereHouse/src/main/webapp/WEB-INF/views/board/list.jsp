<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <% String nickname=(String) session.getAttribute("nickname");
      	 int pnSize = Integer.parseInt(String.valueOf(request.getAttribute("pnSize")));      // pnSize : 요청 처리 후에 전체 페이지 네이션 크기를 주어야지만  브라우저가 페이지 내 버튼을 몇개 생성할지 알 수 있게 하기 위한 목적.
      	System.out.println("pnSize : " + pnSize);
      %>
         <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
         <html lang="ko">

         <head>
            <meta http-equiv="Content-Type" charset="text/html;charset=UTF-8">
            <link rel="preconnect" href="https://fonts.googleapis.com">
   			<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
			<link href="https://fonts.googleapis.com/css2?family=Courgette&family=Kdam+Thmor+Pro&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
               integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
               crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
               integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
               crossorigin="anonymous"></script>

            <script language="JavaScript" src="../js/boardlist.js"></script>

            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <script src="https://kit.fontawesome.com/09b067fdc5.js" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="/wherehouse/css/list.css?ver=125">
            <link rel="stylesheet" href="/wherehouse/css/listshow.css?ver=125">
            <script src="js/list.js?ver=123"></script> 

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
      <div id="writePage">
         <button type="button" onclick="writepage()" id="writePageBtn">글 작성하러 가기!</button>
      </div>
      <div id="logo-img"><img src="../images/home_icon.png" alt=""></div>
   </aside>
            
            <p id="listLogo">Where House</p>
            <div class="showlist">
               <table id="boardtable" class="table">
                  <thead>
                     <tr class="">
                        <th scope="col" id="listNo">No.</th>
                        <th scope="col" id="listHead">제목</th>
                        <th scope="col" id="listNickName">글쓴이</th>
                        <th scope="col" id="listGu">지역구</th>
                        <th scope="col" id="listHit">조회수</th>
                        <th scope="col" id="listDate">날짜</th>
                     </tr>
                  </thead>
                  
                  <tbody id="listMain">
                     <c:forEach var="boardList" items="${boardList}" varStatus="status">
                        <tr>
                           <td>${boardList.contentnum}</td>
                           <td><a href="../writeboard/${boardList.contentnum}" id="clickTitle">${boardList.title}</a></td>
                           <td>${members[status.index]}</td>
                           <td>${boardList.region}</td>
                           <td>${boardList.hit}</td>
                           <td>${boardList.bdate}</td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
              
               <input type="hidden" class="nickname" value="<%=nickname %>">
                <!-- 
               <table class="writebtntbl">
                  <tr>
                     <td class="writebtn" colspan="5"><button type="button" onclick="writepage()">글 작성</button></td>
                  </tr>
               </table>
                -->
               <div class="paginationbtn">
                  <c:forEach var="i" begin="1" end="<%=pnSize %>">
                   <button class="${i}" id="pageButton">${i}</button>
                  </c:forEach>
               </div>
            </div>   
         </body>
      </html>