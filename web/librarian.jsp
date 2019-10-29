<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Librarian</title>
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
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">Home</h2>
                </div>
            </header>
            <!-- Page Header-->
            <section class="dashboard-counts no-padding-bottom">
                <div class="container-fluid">
                    <div class="row bg-white has-shadow">
                        <div class="col-xl-3 col-sm-6">
                            <img src="img/logo.png" height="90%" width="90%">
                        </div>
                        <!-- Item -->
                        <div class="col-xl-2 col-sm-6">
                            <div class="item d-flex align-items-center">
                                <div class="icon bg-violet"><i class="icon-user"></i></div>
                                <div class="title"><span>New<br>Readers</span>
                                    <div class="progress">
                                        <div role="progressbar" style="width: 25%; height: 4px;" aria-valuenow="25"
                                             aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-violet"></div>
                                    </div>
                                </div>
                                <div class="number"><strong>25</strong></div>
                            </div>
                        </div>
                        <!-- Item -->
                        <div class="col-xl-2 col-sm-6">
                            <div class="item d-flex align-items-center">
                                <div class="icon bg-red"><i class="icon-padnote"></i></div>
                                <div class="title"><span>Borrow<br>Businesses</span>
                                    <div class="progress">
                                        <div role="progressbar" style="width: 13%; height: 4px;" aria-valuenow="13"
                                             aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-red"></div>
                                    </div>
                                </div>
                                <div class="number"><strong>13</strong></div>
                            </div>
                        </div>
                        <!-- Item -->
                        <div class="col-xl-2 col-sm-6">
                            <div class="item d-flex align-items-center">
                                <div class="icon bg-green"><i class="icon-bill"></i></div>
                                <div class="title"><span>Borrowed<br>Books</span>
                                    <div class="progress">
                                        <div role="progressbar" style="width: 41%; height: 4px;" aria-valuenow="410"
                                             aria-valuemin="0" aria-valuemax="1000" class="progress-bar bg-green"></div>
                                    </div>
                                </div>
                                <div class="number"><strong>410</strong></div>
                            </div>
                        </div>
                        <!-- Item -->
                        <div class="col-xl-3 col-sm-5">
                            <div class="item d-flex align-items-center">
                                <div class="icon bg-orange"><i class="icon-check"></i></div>
                                <div class="title"><span>Reserved<br>Books</span>
                                    <div class="progress">
                                        <div role="progressbar" style="width: 21%; height: 4px;" aria-valuenow="210"
                                             aria-valuemin="0" aria-valuemax="1000" class="progress-bar bg-orange"></div>
                                    </div>
                                </div>
                                <div class="number"><strong>210</strong></div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- search -->
            <form class="input-group col-md-12" style="margin-top: 40px; position: relative" action="ReaderSearchServlet"
                  name="search" method="post">
                <span class="input-group-btn">
                    <select  name="signal" class="btn btn-info btn-search">
                        <option>Name</option>
                        <option>ID</option>
                        <option>Author</option>
                    </select>
                </span>
                <input type="text" class="form-control" name="message"
                       placeholder="Please enter the content you are searching for">
                <span class="input-group-btn">
                    <button type="submit" class="btn btn-info btn-search">Search</button>
                </span>
            </form>

            <!-- notice -->
            <div style="margin-top: 40px;">
                <h1>这里是Notice。</h1>
            </div>
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