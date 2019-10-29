<%--
  Created by IntelliJ IDEA.
  User: kehan
  Date: 2019/9/25
  Time: 下午4:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
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
                    <h2 class="no-margin-bottom">Change Password</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="admin.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Change password</li>
                </ul>
            </div>
            <!-- Forms Section-->
            <section class="forms">
                <div class="container-fluid">
                    <div class="row">
                        <!-- Basic Form-->
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-close">
                                    <div class="dropdown">
                                        <button type="button" id="closeCard1" data-toggle="dropdown"
                                                aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i
                                                class="fa fa-ellipsis-v"></i></button>
                                        <div aria-labelledby="closeCard1"
                                             class="dropdown-menu dropdown-menu-right has-shadow"><a href="#"
                                                                                                     class="dropdown-item remove">
                                            <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit">
                                            <i class="fa fa-gear"></i>Edit</a></div>
                                    </div>
                                </div>
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">Change your password</h3>
                                </div>
                                <div class="card-body">
                                    <p>Please input the old password and new password blow.</p>
                                    <form class="form-basic" action="AdminChangePassword.do" method="post">
                                        <div class="form-group">
                                            <%--                                            <label class="form-control-label">Please input the old password</label>--%>
                                            <input type="password" placeholder="Old password"
                                                   name="oldPassword"
                                                   class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <%--                                            <label class="form-control-label">Please input the new password</label>--%>
                                            <input type="password" placeholder="New password"
                                                   name="newPassword"
                                                   class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <%--                                            <label class="form-control-label">Please confirm the new password</label>--%>
                                            <input type="password" placeholder="Confirm new Password"
                                                   name="confirmedNewPassword"
                                                   class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <input type="submit" value="Submit" class="btn btn-primary">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <jsp:include page="footer.jsp" flush="true"></jsp:include>
        </div>
    </div>
</div>

<script>
    var exec_msg = '<%=request.getParameter("exec_msg")%>';
    if (exec_msg === 'success') {
        alert("Successfully change the password!");
    } else if (exec_msg === 'newPasswordDiff') {
        alert("The two new passwords is different!");
    } else if (exec_msg === 'oldPasswordWrong') {
        alert("The old password is wrong!");
    } else if (exec_msg === 'dbProcessFailed') {
        alert("Process failed!");
    }
</script>

<!-- JavaScript files-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/popper.js/umd/popper.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="vendor/chart.js/Chart.min.js"></script>
<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
<!-- Main File-->
<script src="js/front.js"></script>

</body>
</html>
