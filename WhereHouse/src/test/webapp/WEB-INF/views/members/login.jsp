<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if (session.getAttribute("validMem") != null){ %>
		<jsp:forward page="loginSuccess.jsp"></jsp:forward>
<% } %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/home_icon.png">
    <link rel="stylesheet" href="../css/login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
    <title>WhereHouse</title>
</head>

<body>
    <div class="container">
        <header>
            <div id="logo">
                <div class="mt-5 mb-5 pt-3"></div>
                <a id="logo_text" href="/wherehouse">Where House</a>
            </div>
        </header>

        <section class="text-center">
            <div class="mt-3 mb-5 pt-3"></div>
            <div id="login-form-border" class="pt-3 pb-3">
                <div id="inputBox" class="me-3 ms-3 row">
                    <form action="../loginOk" method="get">		<!--  -->
                        <div class=" mt-4 mb-4" id="login-id"><input type="text" name="id" class="form-control" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아이디"></div>
                        <div class="mb-5" id="login-pw"><input type="password" name="pw" class="form-control" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;비밀번호"></div>
                        <div class="button-login-box">
                            <input type="submit" value="로그인" class="btn btn-primary btn-xs mb-3" style="width:100%"></input>
                         		  또는
                            <input type="button" value="회원가입" class="btn btn-primary btn-xs mt-3 mb-4" style="width:100%" onclick="javascript:window.location='./join'"></input> <!-- ./page/join -->
                        </div>
                    </form>
                </div>
            </div>
        </section>

        <footer>
            <div class="mt-5 mb-5 pt-3"></div>
            <div class="container">
                <footer class="py-5 border-top border-secondary border-opacity-50 mt-5">
                    <div class="row">
                        <div id="" class="footer_text col-md-4 mb-3 text-left">
                            <h4 class="mb-4 ms-4">Contact</h4>
                            <ul class="nav-flex-column">
                                <div class="nav-item mb-2">
                                    <a class="nav-link p-0 text-muted">
                                        <i class="bi bi-geo-alt-fill">
                                            서울시 서대문구 연희로
                                        </i>
                                    </a>
                                </div>
                                <div class="nav-item mb-2">
                                    <a class="nav-link p-0 text-muted">
                                        <i class="bi bi-telephone-fill">
                                            010-2794-0796
                                        </i>
                                    </a>
                                </div>
                                <div class="nav-item mb-2">
                                    <a class="nav-link p-0 text-muted">
                                        <i class="bi bi-envelope-fill">
                                            joonwon24@gmail.com
                                        </i>
                                    </a>
                                </div>
                                <div class="nav-item mb-2">
                                    <a class="nav-link p-0 text-muted" href="https://github.com/joonwonh/WhereHouse"
                                        target="_blank">
                                        <i class="bi bi-github">
                                            github.com/joonwonh/WhereHouse
                                        </i>
                                    </a>
                                </div>
                            </ul>
                        </div>

                        <div id="" class="footer_text col-md-4 mb-3 text-left">
                            <h4 class="mb-4 ms-4">Our Project Plan</h4>
                            <ul class="nav-flex-column">
                                <div class="nav-item mb-2">
                                    <a class="nav-link p-0 text-muted"
                                        href="https://github.com/joonwonh/WhereHouse/tree/main/1.%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EA%B8%B0%ED%9A%8D%EC%84%9C"
                                        target='_blank'>
                                        Project Plan pres.
                                    </a>
                                </div>
                                <div class="nav-item mb-2">
                                    <a class="nav-link p-0 text-muted"
                                        href="https://github.com/joonwonh/WhereHouse/tree/main/2.%EA%B0%9C%EB%B0%9C%EA%B3%84%ED%9A%8D%EC%84%9C"
                                        target='_blank'>
                                        Develop Plan
                                    </a>
                                </div>
                                <div class="nav-item mb-2">
                                    <a class="nav-link p-0 text-muted"
                                        href="https://github.com/joonwonh/WhereHouse/tree/main/3.%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%20%EC%A0%95%EC%9D%98%EC%84%9C"
                                        target='_blank'>
                                        Function Specification
                                    </a>
                                </div>
                                <div class="nav-item mb-2">
                                    <a class="nav-link p-0 text-muted"
                                        href="https://github.com/joonwonh/WhereHouse/tree/main/4.%ED%99%94%EB%A9%B4%EC%84%A4%EA%B3%84%EC%84%9C"
                                        target='_blank'>
                                        Wire Frame
                                    </a>
                                </div>
                            </ul>
                        </div>
                        <div class="col-md-4 mb-3 text-center">
                            <img src="../images/home_icon.png" alt="" class="w-50 h-75 mt-3">
                        </div>
                    </div>
                </footer>
            </div>
    </div>
</body>

</html>