<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Librarian" %>
<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Book Detail</title>
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
                    <h2 class="no-margin-bottom">Book Detail</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Book Detail</li>
                </ul>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Bnumber</th>
                                            <th>id</th>
                                            <th>floor</th>
                                            <th>shelf</th>
                                            <th>areacode</th>
                                            <th>Operation</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            request.getAttribute("wa");
                                        %>
                                        <c:forEach items="${wa}" var="detail" varStatus="li">
                                            <tr>
                                                <td>${detail.getName()}</td>
                                                <td>${detail.getBookNumber()}</td>
                                                <td>${detail.getCopyid()}</td>
                                                <td>${detail.getFloor()}</td>
                                                <td>${detail.getShelf()}</td>
                                                <td>${detail.getAreacode()}</td>
                                                <td>
                                                    <a href="#myModal_${li.index+1}" data-toggle="modal"
                                                       value="${librarian.getAccount()}"
                                                       id="lastButton">
                                                        <button type="button" class="btn btn-btn-primary"
                                                                style="color: white; background-color: rgb(224,79,61)">
                                                            Delete
                                                        </button>
                                                    </a>
                                                    <!-- Modal-->
                                                    <div id="myModal_${li.index+1}" tabindex="-1" role="dialog"
                                                         aria-labelledby="exampleModalLabel" aria-hidden="true"
                                                         class="modal fade text-left">
                                                        <div role="document" class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h4 id="exampleModalLabel" class="modal-title">
                                                                        Delete</h4>
                                                                    <button type="button" data-dismiss="modal"
                                                                            aria-label="Close" class="close"><span
                                                                            aria-hidden="true">×</span></button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <p>Are you sure want to delete this book?</p>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" data-dismiss="modal"
                                                                            class="btn btn-secondary">Close
                                                                    </button>
                                                                    <a href="DeleteBook.do?bookCopyID=${detail.getCopyid()}">
                                                                            <%--                                                                                <a href="admin.jsp?account=${librarian.getAccount()}">--%>
                                                                        <button type="button"
                                                                                class="btn btn-primary">
                                                                            Delete
                                                                        </button>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a href="EditBook.do?bookNumber=${detail.getBookNumber()}">
                                                        <button type="button" class="btn btn-secondary"
                                                                style="color: white; background-color: rgb(46,203,112)">
                                                            Edit
                                                        </button>
                                                    </a>
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

            <!-- Page Footer-->
            <footer class="main-footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6">
                            <p>Copyright &copy; 2019.Company name All rights reserved.More Templates test</p>
                        </div>
                        <div class="col-sm-6 text-right">
                            <p></p>
                            <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
</div>


<script>
    var info = '<%=request.getParameter("info")%>';
    if (info == 'found') {
        alert("successfully serach!");
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