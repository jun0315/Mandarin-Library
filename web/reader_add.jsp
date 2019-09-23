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
    <header class="header">
        <nav class="navbar">
            <!-- Search Box-->
            <div class="search-box">
                <button class="dismiss"><i class="icon-close"></i></button>
                <form id="searchForm" action="#" role="search">
                    <input type="search" placeholder="What are you looking for..." class="form-control">
                </form>
            </div>
            <div class="container-fluid">
                <div class="navbar-holder d-flex align-items-center justify-content-between">
                    <!-- Navbar Header-->
                    <div class="navbar-header">
                        <!-- Navbar Brand --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                        <div class="brand-text d-none d-lg-inline-block">
                            <span>Mandarin - </span><strong>Library</strong><span>   Automation</span>
                        </div>
                        <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div>
                    </a>
                        <!-- Toggle Button--><a id="toggle-btn" href="#"
                                                class="menu-btn active"><span></span><span></span><span></span></a>
                    </div>
                    <!-- Navbar Menu -->
                    <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                        <!-- Logout    -->
                        <li class="nav-item"><a href="logout" class="nav-link logout"> <span
                                class="d-none d-sm-inline">Logout</span><i class="fa fa-sign-out"></i></a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="page-content d-flex align-items-stretch">
        <!-- Side Navbar -->
        <nav class="side-navbar">
            <!-- Sidebar Header-->
            <div class="sidebar-header d-flex align-items-center">
                <div class="avatar"><img src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
                <div class="title">
                    <h1 class="h4">
                        <%
                            String account = (String) session.getAttribute("name");
                            out.println(account);
                        %>
                    </h1>
                </div>
            </div>
            <%--    侧边栏的目录      --%>
            <ul class="list-unstyled">
                <li><a href="#BookManage" aria-expanded="false" data-toggle="collapse"> <i
                        class="icon-interface-windows"></i>Book Manage</a>
                    <ul id="BookManage" class="collapse list-unstyled ">
                        <li><a href="#">Book List</a></li>
                        <li><a href="#">Search Book</a></li>
                        <li><a href="#">Edit Book Category</a></li>
                        <li><a href="#">Edit Book Location</a></li>
                    </ul>
                </li>
                <li><a href="#ReaderManage" aria-expanded="true" data-toggle="collapse"> <i
                        class="icon-interface-windows"></i>Reader Manage</a>
                    <ul id="ReaderManage" class="collapse list-unstyled show">
                        <li><a href="reader_add.jsp">Reader List</a></li>
                    </ul>
                </li>

                <li><a href="#BusinessProcess" aria-expanded="false" data-toggle="collapse"> <i
                        class="icon-interface-windows"></i>Business Process</a>
                    <ul id="BusinessProcess" class="collapse list-unstyled ">
                        <li><a href="#">Borrow Business</a></li>
                        <li><a href="#">Return Business</a></li>
                    </ul>
                </li>
                <li><a href="#RecordQuery" aria-expanded="false" data-toggle="collapse"> <i
                        class="icon-interface-windows"></i>Record Query</a>
                    <ul id="RecordQuery" class="collapse list-unstyled ">
                        <li><a href="librarian_add.jsp">Reader History</a></li>
                        <li><a href="#">Book Deletion</a></li>
                        <li><a href="#">Total Deposit</a></li>
                        <li><a href="#">Total Fine</a></li>

                    </ul>
                </li>
                <li><a href="#NoticeEdit" aria-expanded="false" data-toggle="collapse"> <i
                        class="icon-interface-windows"></i>Notice</a>
                    <ul id="NoticeEdit" class="collapse list-unstyled ">
                        <li><a href="#">Notice List</a></li>
                        <li><a href="#">Post Notice</a></li>
                    </ul>
                </li>
            </ul>
            <%--    end   --%>
        </nav>


        <div class="content-inner">
            <!-- Page Header-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">Reader Add</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="admin.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Reader Add</li>
                </ul>
            </div>
            <section class="tables">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <p>Sign up for a new reader.</p>
                            <form class="form-horizontal" action="librarian_add.do" method="post">
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
                                        <input id="inputHorizontalWarning" name="password" value="00010001"
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
                                    <div class="col-sm-9 offset-sm-3">
                                        <input type="submit" value="Sign in" class="btn btn-primary">
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
            <footer class="main-footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6">
                            <p>Copyright &copy; 2019.Mandarin Library Automation all rights reserved.</p>
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
    if (info == 'success') {
        alert("successfully add!");
    }else if(info == 'error'){
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
