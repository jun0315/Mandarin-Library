<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: Liu_PiPiPi
  Date: 2019/10/24
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Search Book</title>
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
</head>
<body>
<div class="page">
    <!-- Main Navbar-->
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <header class="header">
        <nav class="navbar">
            <!-- Search Box-->
            <div class="container-fluid">
                <div class="navbar-holder d-flex align-items-center justify-content-between">
                    <!-- Navbar Header-->
                    <div class="navbar-header">
                        <!-- Navbar Brand --><a href="index.jsp" class="navbar-brand d-none d-sm-inline-block">
                        <div class="brand-text d-none d-lg-inline-block">
                            <span></span><strong></strong><span style="margin-left: 10px;"></span>
                        </div>
                        <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong></strong></div>
                    </a>
                    </div>
                    <!-- Navbar Menu -->
                    <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                        <!-- Logout    -->
                        <li class="nav-item">
                            <a href="homePage.do" class="nav-link logout">
                                <span class="d-none d-sm-inline" style="font-size: larger">Back</span>
                                <i class="fa fa-sign-out"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div>
        <section class="tables" style="padding: 20px">

            <form class="input-group col-md-12" style="margin: 10px;position: relative" action="VisitorSearch.do"
                  name="search" method="post">
                    <span class="input-group-btn">
                        <select name="signal" class="btn btn-info btn-search">
                            <option>Name</option>
                            <option>ID</option>
                            <option>Author</option>
                        </select>
                    </span>
                <input type="text" class="form-control" name="message"
                       placeholder="Please enter the content you are searching for">
                <span class="input-group-btn">
                        <button type="submit" class="btn btn-info btn-search">search</button>
                    </span>
            </form>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>BookNumber</th>
                                            <th>Name</th>
                                            <th>Press</th>
                                            <th>Author</th>
                                            <th>Floor</th>
                                            <th>Shelf</th>
                                            <th>Detail</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            List<Book> list = (List<Book>) request.getAttribute("list");
                                            request.setAttribute("list", list);
                                        %>
                                        <c:forEach items="${list}" var="book" varStatus="li">
                                            <tr>
                                                <th>${li.index+1}</th>
                                                <td>${book.getBookNumber()}</td>
                                                <td>${book.getName()}</td>
                                                <td>${book.getPress()}</td>
                                                <td>${book.getAuthor()}</td>
                                                <td>${book.getFloor()}</td>
                                                <td>${book.getShelf()}</td>
                                                <td>
                                                    <button type="submit" class="btn btn-info btn-search">Detail
                                                    </button>
                                                        <%--                                                    <form style="margin: 10px;position: relative" action="DetailSearch"--%>
                                                        <%--                                                          name="search" method="post">--%>
                                                        <%--                                                        <input type="hidden" name="number"--%>
                                                        <%--                                                               value="${book.getBookNumber()}"/>--%>
                                                        <%--                                                    </form>--%>
                                                </td>
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
        <!-- Page Footer-->
        <jsp:include page="footer.jsp" flush="true"></jsp:include>
    </div>
</div>

<script>
    var info = '<%=request.getParameter("info")%>';
    if (info == 'found') {
        alert("successfully search!");
    } else if (info == 'notFound') {
        alert("search failure!");
    }
</script>

<!-- JavaScript files-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/popper.js/umd/popper.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="vendor/chart.js/Chart.min.js"></script>
<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="js/charts-home.js"></script>
<!-- Main File-->
<script src="js/front.js"></script>

</body>
</html>
