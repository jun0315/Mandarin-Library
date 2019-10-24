<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page import="entity.Librarian" %>
<%@ page import="java.util.List" %>
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
        <jsp:include page="admin_side.jsp" flush="true"></jsp:include>
        <div class="content-inner">
            <!-- Page Header-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">Librarian Add</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="admin.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Librarian Add</li>
                </ul>
            </div>
            <section class="tables">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <p>Sign up for a new librarian.</p>
                            <form class="form-horizontal" action="librarian_add.do" method="post">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Account</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalSuccess" name="account"
                                               class="form-control form-control-success">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Password</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalWarning" name="password" value="00010001"
                                               class="form-control form-control-warning">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Name</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalWarning" name="name"
                                               class="form-control form-control-warning">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Phone</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalWarning" name="phone"
                                               class="form-control form-control-warning">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-9 offset-sm-3">
                                        <input type="submit" value="Signin" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <%--                <div class="container-fluid">--%>
                <%--                    <div class="row">--%>
                <%--                        <div class="col-lg-12">--%>
                <%--                            <div class="card">--%>
                <%--                                <div class="card-body">--%>
                <%--                                    <div class="table-responsive">--%>
                <%--                                        <table class="table">--%>
                <%--                                            <thead>--%>
                <%--                                            <tr>--%>
                <%--                                                <th>#</th>--%>
                <%--                                                <th>Account</th>--%>
                <%--                                                <th>Name</th>--%>
                <%--                                                <th>Phone</th>--%>
                <%--                                            </tr>--%>
                <%--                                            </thead>--%>
                <%--                                            <tbody>--%>
                <%--                                            <%List<Librarian> librarians = (List<Librarian>) request.getAttribute("librarians");%>--%>
                <%--                                            <%int i = 0;%>--%>
                <%--                                            <c:forEach items="${librarians}" var="librarian" varStatus="li">--%>
                <%--                                                <% i++;%>--%>
                <%--                                                <tr>--%>
                <%--                                                    <th>${i}</th>--%>
                <%--                                                    <td>${librarian.getAccount()}</td>--%>
                <%--                                                    <td>${librarian.getName()}</td>--%>
                <%--                                                    <td>${librarian.getPhone()}</td>--%>
                <%--                                                </tr>--%>
                <%--                                            </c:forEach>--%>
                <%--                                            </tbody>--%>
                <%--                                        </table>--%>
                <%--                                    </div>--%>
                <%--                                </div>--%>
                <%--                            </div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
            </section>
            <!-- Page Footer-->
            <jsp:include page="footer.jsp" flush="true"></jsp:include>
        </div>
    </div>
</div>
<script>
    var info = '<%=request.getParameter("info")%>';
    if (info == 'success') {
        alert("successfully add!");
    } else if (info == 'erroe') {
        alert("add failure because of have the same account!");
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