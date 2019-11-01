<%--
  Created by IntelliJ IDEA.
  User: 刘威
  Date: 2019/10/28
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Reader" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.ReaderReserve" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Reserve Business</title>
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

    <script src="js/dialogue.js"></script>

    <!--  侧边栏效果 -->
    <script src="js/jquery-1.10.1.min.js"></script>
    <script src="js/jquery.cookie.js"></script>
</head>

<body>
<div class="page">
    <!-- Main Navbar-->
    <jsp:include page="header_template.jsp" flush="true"></jsp:include>
    <div class="page-content d-flex align-items-stretch">
        <!-- Side Navbar -->
        <jsp:include page="librarian_side.jsp" flush="true"></jsp:include>
        <div class="content-inner">
            <!-- Page Header-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">Reserve Business</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="librarian.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Reserve Business</li>
                </ul>
            </div>
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
                                                <th>Reader ID</th>
                                                <th>Reader Bar</th>
                                                <th>Copy ID</th>
                                                <th>Copy Bar</th>
                                                <th>Reserve Time</th>
                                                <th>Operation</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%List<ReaderReserve> readerReserveList = (List<ReaderReserve>) request.getAttribute("readerReserveList");%>
                                            <c:forEach items="${readerReserveList}" var="readerReserve" varStatus="li">
                                                <tr>
                                                    <th>${li.index+1}</th>
                                                    <td>${readerReserve.getUser_account()}</td>
                                                    <td>${readerReserve.getCopy_id()}</td>
                                                    <td>
                                                        <img src="cache/barcode/${readerReserve.getAccount_barpath()}">
                                                    </td>
                                                    <td>
                                                        <img src="cache/barcode/${readerReserve.getCopy_barpath()}">
                                                    </td>
                                                    <td>${readerReserve.getReserve_time()}</td>
                                                    <td>
                                                        <a href="BorrowReserveApprove.do?user_account=${readerReserve.getUser_account()}&book_copy_id=${readerReserve.getCopy_id()}">
                                                            <button type="button" class="btn btn-primary">Approve
                                                            </button>
                                                        </a>
                                                    </td>
                                                        <%--                                                    TODO--%>
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
            <footer class="main-footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6">
                            <p>Copyright &copy; 2019.Mandarin Library Automation all rights reserved.</p>
                        </div>
                        <div class="col-sm-6 text-right">
                            <p></p>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
</div>


<script>
    var info = '<%=request.getParameter("info")%>';
    if (info == "approve_success") {
        alert("Successfully Approve!");
    }
    if (info == "delete_success") {
        alert("Delete Successfully")
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


