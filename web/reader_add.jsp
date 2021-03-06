<%--
  Created by IntelliJ IDEA.
  User: Liu_PiPiPi
  Date: 2019/9/23
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Add Reader</title>
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
        <jsp:include page="librarian_side.jsp"></jsp:include>
        <div class="content-inner">
            <!-- Page Header 黑色粗体title-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">Reader Add</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Reader Add</li>
                </ul>
            </div>

            <%--    最中间版块   --%>
            <section class="tables">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <p>Sign up for a new reader.</p>
                            <form class="form-horizontal" action="ReaderAdd.do" method="post">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Account</label>
                                    <div class="col-sm-9">
                                        <input
                                                id="inputHorizontalSuccess" name="account"
                                               required minlength="11" maxlength="11"
                                               required oninvalid="setCustomValidity('Please enter 11 digits');" oninput="setCustomValidity('');"
                                               class="form-control form-control-success">
                                        <%--<small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Password</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalWarning" name="password" value="12345678"
                                               class="form-control form-control-warning">
                                        <%--<small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Name</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalWarning" name="name"
                                               required
                                               class="form-control form-control-warning">
                                        <%--<small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Email</label>
                                    <div class="col-sm-9">
                                        <input type="email"
                                                id="inputHorizontalWarning" name="email"
                                               required oninvalid="setCustomValidity('Please include @ in your email address');" oninput="setCustomValidity('');"
                                               class="form-control form-control-success">

                                        <%--<small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Deposit</label>
                                    <div class="col-sm-9">
                                        <input  type="number"
                                                value="300"
                                                id="inputHorizontalWarning" name="deposit"
                                                required
                                               class="form-control form-control-warning">
                                        <%--<small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-9 offset-sm-3">
                                        <input type="submit" value="Add" class="btn btn-primary">
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
        alert("Successfully add!");
        window.location.href = "ReaderList.do";
    } else if (info == 'error') {
        alert("Add failure because of have the same account!");
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