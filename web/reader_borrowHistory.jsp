<%--
  Created by IntelliJ IDEA.
  User: 刘威
  Date: 2019/9/25
  Time: 16：32
  用于实现读者的View功能，可查看个人借阅情况和罚金信息
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.ReaderBorrow" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Book" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
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
    <jsp:include page="header_template.jsp" flush="true"></jsp:include>
    <div class="page-content d-flex align-items-stretch">
        <!-- Side Navbar -->
        <jsp:include page="reader_side.jsp" flush="true"></jsp:include>
        <div class="content-inner">
            <!-- Page Header-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">View Borrowing History</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                    <li class="breadcrumb-item active">View</li>
                </ul>
            </div>

            <%--显示借阅记录 --%>
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
                                                <th>#</th>
                                                <th>Book Name</th>
                                                <th>Book Copy ID</th>
                                                <th>Borrow Time</th>
                                                <th>Status</th>
                                                <th>Fine</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                                List<ReaderBorrow> readerBorrowList = (List<ReaderBorrow>) request.getAttribute("readerBorrowList");
                                            %>
                                            <c:forEach items="${readerBorrowList}" var="readerBorrow" varStatus="li">
                                                <tr>
                                                    <th>${li.index+1}</th>
                                                    <td>${readerBorrow.getBook_name()}</td>
                                                    <td>${readerBorrow.getCopy_id()}</td>
                                                    <td>${readerBorrow.getBorrow_time().toString()}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${readerBorrow.getIsReturned() ==1}">
                                                                Returned
                                                            </c:when>
                                                            <c:otherwise>
                                                                Not Returned
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td>${readerBorrow.getFine().toString()}$</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    Total Fine:
                                    <%
                                        double totalFine= (double) request.getAttribute("totalFine");
                                        out.print(totalFine);
                                    %>$
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
</div>
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