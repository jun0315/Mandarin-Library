<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.BookCategory" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Book Category List</title>
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

    <%--    <script type="text/javascript">--%>
    <%--        function deleteClick() {--%>
    <%--            var con;--%>
    <%--            con = confirm("Are you sure you want to delete?\n");--%>
    <%--            if(con==true) {--%>
    <%--                window.location.href("index.jsp");--%>
    <%--            }--%>
    <%--        }--%>
    <%--    </script>--%>
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
                    <h2 class="no-margin-bottom">Book Category List</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="admin.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Book Category List</li>
                </ul>
            </div>
            <section class="tables" style="padding: 20px">

                <form class="input-group col-md-12" style="margin: 10px;position: relative" action="SearchLibrarian.do"
                      name="search" method="post">
                    <input type="text" class="form-control" name="searchAccount"
                           placeholder="Please enter the account of the administrator who needs to query">
                    <span class="input-group-btn">
                            <button type="submit" class="btn btn-info btn-search">search</button>
                        </span>
                </form>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <div style="width: 1000px;height: 60px">
                                        <a href="book_category_add.jsp">
                                            <img src="img/addBook.png" style="float: left; length:40px; width:40px;">
                                            <p style="line-height:40px; vertical-align: middle; float: right; margin-left: 10px">
                                                <strong>Add Book Category and Location</strong></p>
                                        </a>
                                    </div>
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Category</th>
                                                <th>Floor</th>
                                                <th>Shelf</th>
                                                <th>Operation</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%List<BookCategory> bookCategories = (List<BookCategory>) request.getAttribute("bookCategories");%>
                                            <c:forEach items="${bookCategories}" var="bookCategory" varStatus="li">
                                                <tr>
                                                    <th>${li.index+1}</th>
                                                    <td>${bookCategory.getCategory()}</td>
                                                    <td>${bookCategory.getFloor()}</td>
                                                    <td>${bookCategory.getShelf()}</td>
                                                    <td>
                                                        <a href="#myModal_${li.index+1}" data-toggle="modal" value="${bookCategory.getCategory()}"
                                                           id="lastButton">
                                                            <button type="button" class="btn btn-btn-primary"
                                                                    style="color: white; background-color: rgb(224,79,61);">
                                                                Delete
                                                            </button>
                                                        </a>
                                                            <%--   <% String thisaccount = "${librarians[li.index+1].getAccount()}";%>--%>
                                                        <!-- Modal-->
                                                        <div id="myModal_${li.index+1}" tabindex="-1" role="dialog"
                                                             aria-labelledby="exampleModalLabel" aria-hidden="true"
                                                             class="modal fade text-left">
                                                            <div role="document" class="modal-dialog">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h4 id="exampleModalLabel" class="modal-title">Delete</h4>
                                                                        <button type="button" data-dismiss="modal"
                                                                                aria-label="Close" class="close"><span
                                                                                aria-hidden="true">×</span></button>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        <p>Are you sure want to delete this category?</p>
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" data-dismiss="modal" class="btn btn-secondary">Close</button>
                                                                        <a href="BookCategoryDelete.do?category=${bookCategory.getCategory()}">
                                                                            <button type="button" class="btn btn-primary">Delete</button>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <a href="BookCategoryEdit.do?category=${bookCategory.getCategory()}">
                                                            <button type="button" class="btn btn-secondary" style="color: white; background-color: rgb(46,203,112)">
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
            </section>
            <!-- Page Footer-->
            <jsp:include page="footer.jsp" flush="true"></jsp:include>
        </div>
    </div>
</div>


<script>
    var info = '<%=request.getParameter("info")%>';
    if (info == 'found') {
        alert("successfully search!");
    } else if (info == 'notFound') {
        alert("search failure!");
    } else if (info == 'delete_error') {
        alert("There is no category to delete!");
        window.location.href = "BookCategoryList.do";
    } else if (info == 'delete_success') {
        alert("Successfully delete!");
        window.location.href = "BookCategoryList.do";
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