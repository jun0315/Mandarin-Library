<%--
  Created by IntelliJ IDEA.
  User: Liu_PiPiPi
  Date: 2019/10/24
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Notice" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home Page</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->

    <link data-n-head="true" rel="stylesheet" href="css/effect_homepage.css">
    <style>
        .search {
            display: -webkit-box; display: -webkit-flex; display: -ms-flexbox; display: flex;
            -webkit-box-pack: center; -webkit-justify-content: center; -ms-flex-pack: center;
            justify-content: center; -webkit-box-align: center; -webkit-align-items: center;
            -ms-flex-align: center; align-items: center; -webkit-flex-wrap: wrap; -ms-flex-wrap: wrap;
            flex-wrap: wrap; position: absolute; top: 50%; z-index: 9;
            left: 50%; -webkit-transform: translate(-50%, -50%); -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%); margin-top: -15px;
            -webkit-transition: color 0.5s; -o-transition: color 0.5s; transition: color 0.5s; }
        .search h2 {
            text-align: center;
            color: #fff;
            font-weight: bold;
            font-size: 100px;
            font-family: "webfontx" !important; }
    </style>
</head>
<body>
<div class="page">
    <!-- Main Navbar-->
    <header class="header">
        <nav class="navbar">
            <!-- Search Box-->
            <div class="container-fluid">
                <div class="navbar-holder d-flex align-items-center justify-content-between">
                    <!-- Navbar Header-->
                    <div class="navbar-header">
                        <!-- Navbar Brand -->
                        <a href="homePage.jsp" class="navbar-brand d-none d-sm-inline-block">
                            <div class="brand-text d-none d-lg-inline-block">
                                <span>Mandarin-</span><strong>Library</strong><span style="margin-left: 10px;">Automation</span>
                            </div>
                            <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div>
                        </a>
                        <!-- Toggle Button-->
                        <a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
                    </div>
                    <!-- Navbar Menu -->
                    <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                        <!-- Logout    -->
                        <li class="nav-item">
                            <a href="login" class="nav-link logout">
                                <span class="d-none d-sm-inline" style="font-size: 20px;">Login</span>
                                <i class="fa fa-sign-out"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="effect1">
        <div style="position: absolute; top: 11%; left: 40%">
            <img src="img/logo.png" style="width: 100%; height: 100%">
        </div>
        <div class="search">
            <h2>Mandarin-Library Automation</h2>
            <form class="input-group col-md-12" style="margin-top: 50px; position: relative" action="VisitorSearch.do"
                  name="search" method="post">
                <span class="input-group-btn">
                    <select name="signal" class="btn btn-info btn-search" style="height: 38px;">
                        <option>Name</option>
                        <option>ID</option>
                        <option>Author</option>
                    </select>
                </span>
                <input type="text" class="form-control" name="message"
                       placeholder="Please enter the content you are searching for">
                <span class="input-group-btn">
                    <button type="submit" class="btn btn-info btn-search">Search</button>
                </span>
            </form>
        </div>
    </div>

    <div class="">
        <section class="tables" style="padding: 20px">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Topic</th>
                                            <th>Content</th>
                                            <th>PostTime</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%List<Notice> notices = (List<Notice>) request.getAttribute("notices");%>
                                        <c:forEach items="${notices}" var="notice" varStatus="li">
                                            <tr>
                                                <td>${notice.getID()}</td>
                                                <td>${notice.getTopic()}</td>
                                                <td>${notice.getContent()}</td>
                                                <td>${notice.getPosttime()}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="footer.jsp" flush="true"></jsp:include>
</div>
</body>
</html>