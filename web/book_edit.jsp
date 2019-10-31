<%--
  Created by IntelliJ IDEA.
  User: kehan
  Date: 2019/10/17
  Time: 下午10:45
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page import="entity.Book" %>
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
        <jsp:include page="librarian_side.jsp" flush="true"></jsp:include>
        <div class="content-inner">
            <!-- Page Header-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">Librarian Edit</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="admin.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Librarian Edit</li>
                </ul>
            </div>
            <section class="tables">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <p>Edit book information</p>
                            <form class="form-horizontal" action="EditBook.do" method="post">
                                <%Book book = (Book) request.getAttribute("book");%>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Book Number</label>
                                    <div class="col-sm-9">
                                        <input type="hidden" name="perBookNumber" value="<%=book.getBookNumber()%>">
                                        <input id="inputHorizontalSuccess" name="bookNumber"
                                               value="<%=book.getBookNumber()%>"
                                               class="form-control form-control-success" >
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Name</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalWarning" name="name"
                                               value="<%=book.getName()%>"
                                               class="form-control form-control-warning">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Press</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalWarning" name="press"
                                               value="<%=book.getPress()%>"
                                               class="form-control form-control-warning">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Price</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalWarning" name="price"
                                               value="<%=book.getPrice()%>"
                                               class="form-control form-control-warning">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Author</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalWarning" name="author"
                                               value="<%=book.getAuthor()%>"
                                               class="form-control form-control-warning">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Category</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalWarning" name="category"
                                               value="<%=book.getCategory()%>"
                                               class="form-control form-control-warning">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <input type="hidden" name="preCategory" value="<%=book.getCategory()%>">
                                <input type="hidden" name="amount" value="<%=book.getAmount()%>">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Description</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalWarning" name="description"
                                               value="<%=book.getDescription()%>"
                                               class="form-control form-control-warning">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-9 offset-sm-3">
                                        <input type="submit" value="Done" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Page Footer-->
            <jsp:include page="footer.jsp" flush="true"></jsp:include>
        </div>
    </div>
</div>

<script>
    var info = '<%=request.getParameter("info")%>';
    if (info == 'success') {
        alert("successfully edit!");
    } else if (info == 'error') {
        alert("edit failure because of having the same book number!");
    } else if(info=="error_category"){
        alert("edit failure because of non-existent category!");
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