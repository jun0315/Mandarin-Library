<%--
  Created by IntelliJ IDEA.
  User: Liu_PiPiPi
  Date: 2019/9/26
  Time: 10:24
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
<div>
    <form class="form-horizontal" action="reader_add.do" method="post">
        <div class="form-group row">
            <label class="col-sm-3 form-control-label">Account</label>
            <div class="col-sm-9">
                <input id="inputHorizontalSuccess" name="account"
                       class="form-control form-control-success">
                <%--<small class="form-text">Example help text that remains unchanged.</small>--%>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 form-control-label">Password</label>
            <div class="col-sm-9">
                <input id="inputHorizontalWarning" name="password" value=""
                       class="form-control form-control-warning">
                <%--<small class="form-text">Example help text that remains unchanged.</small>--%>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 form-control-label">Name</label>
            <div class="col-sm-9">
                <input id="inputHorizontalWarning" name="name"
                       class="form-control form-control-warning">
                <%--<small class="form-text">Example help text that remains unchanged.</small>--%>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 form-control-label">Email</label>
            <div class="col-sm-9">
                <input id="inputHorizontalWarning" name="email"
                       class="form-control form-control-warning">
                <%--<small class="form-text">Example help text that remains unchanged.</small>--%>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 form-control-label">Deposit</label>
            <div class="col-sm-9">
                <input id="inputHorizontalWarning" name="deposit"
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
</body>
</html>
