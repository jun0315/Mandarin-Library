<%--
  Created by IntelliJ IDEA.
  User: 97718
  Date: 2019/9/30
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.ReaderBorrow" %>
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
                    <h2 class="no-margin-bottom">Account Setting</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="admin.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Account Setting</li>
                </ul>
            </div>
            <!-- Forms Section-->
            <section class="tables">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-close">
                                    <div class="dropdown">
                                        <button type="button" id="closeCard3" data-toggle="dropdown"
                                                aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i
                                                class="fa fa-ellipsis-v"></i></button>
                                        <div aria-labelledby="closeCard3"
                                             class="dropdown-menu dropdown-menu-right has-shadow"><a href="#"
                                                                                                     class="dropdown-item remove">
                                            <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit">
                                            <i class="fa fa-gear"></i>Edit</a></div>
                                    </div>
                                </div>
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">Account Information</h3>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-hover">
                                            <tr>
                                                <th>Account Number</th>
                                                <td>
                                                    <%
                                                        String account = (String) session.getAttribute("account");
                                                        out.println(account);
                                                    %>
                                                </td>
                                                <td>
                                                    <a href="#myModal_${li.index+1}" style="color: #0096e6"
                                                    <%--TODO--%>
                                                       data-toggle="modal" value="${book.getBookNumber()}"
                                                       id="lastButton">Reset</a>
                                                    <%--                                                        <% String thisaccount = "${librarians[li.index+1].getAccount()}";%>--%>
                                                    <!-- Modal-->
                                                    <div id="myModal_${li.index+1}" tabindex="-1" role="dialog"
                                                         aria-labelledby="exampleModalLabel" aria-hidden="true"
                                                         class="modal fade text-left">
                                                        <div role="document" class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h4 id="exampleModalLabel" class="modal-title">
                                                                        Reset</h4>
                                                                    <button type="button" data-dismiss="modal"
                                                                            aria-label="Close" class="close"><span
                                                                            aria-hidden="true">×</span></button>
                                                                </div>
                                                                <%-- TODO--%>
                                                                <div class="form-group">
                                                                    <label class="form-control-label">Please type your
                                                                        new account number.</label>
                                                                    <input type="text"
                                                                           name="newAccountNumber"
                                                                           class="form-control">
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" data-dismiss="modal"
                                                                            class="btn btn-secondary">Cancel
                                                                    </button>
                                                                    <a href="admin.jsp?account=${librarian.getAccount()}">
                                                                        <%--                                                                                <a href="admin.jsp?account=${librarian.getAccount()}">--%>
                                                                        <button type="button"
                                                                                class="btn btn-primary">
                                                                            Submit
                                                                        </button>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>User Name</th>
                                                <td>
                                                    <%
                                                        String name = (String) session.getAttribute("name");
                                                        out.println(name);
                                                    %>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>Email</th>
                                                <td>
                                                    <%
                                                        String email = (String) session.getAttribute("email");
                                                        out.println(email);
                                                    %>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>Security Deposit</th>
                                                <td>
                                                    <%
                                                        int securityDeposit = (int) session.getAttribute("securityDeposit");
                                                        out.println(securityDeposit);
                                                    %>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
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

