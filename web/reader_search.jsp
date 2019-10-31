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
        <jsp:include page="reader_side.jsp" flush="true"></jsp:include>
        <div class="content-inner">
            <!-- Page Header-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">Search</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Search</li>
                </ul>
            </div>

            <section class="tables" style="padding: 20px">

                <form class="input-group col-md-12" style="margin: 10px;position: relative" action="ReaderSearchServlet"
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
                        <button type="submit" class="btn btn-info btn-search">search</button>
                    </span>
                </form>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>BookNumber</th>
                                                <th>Name</th>
                                                <th>Press</th>
                                                <th>Author</th>
                                                <th>Floor</th>
                                                <th>Shelf</th>
                                                <th>Detail</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                                request.getAttribute("list");
                                            %>
                                            <c:forEach items="${list}" var="book" varStatus="li">
                                                <tr>
                                                    <th>${li.index+1}</th>
                                                    <td>${book.getBookNumber()}</td>
                                                    <td>${book.getName()}</td>
                                                    <td>${book.getPress()}</td>
                                                    <td>${book.getAuthor()}</td>
                                                    <td>${book.getFloor()}</td>
                                                    <td>${book.getShelf()}</td>
                                                    <td>
                                                        <form style="margin: 10px;position: relative"
                                                              action="DetailSearch"
                                                              name="search" method="post">
                                                            <input type="hidden" name="number"
                                                                   value="${book.getBookNumber()}"/>
                                                                <%--<a href="book_detail.jsp?number=${book.getBookNumber()}" style="color: #ff0c0c"
                                                                   data-toggle="modal" value="${book.getBookNumber()}"
                                                                   id="lastButton">details</a>--%>
                                                            <input type="submit" value="detail">
                                                        </form>
                                                    </td>
                                                        <%--                                                        <% String thisaccount = "${librarians[li.index+1].getAccount()}";%>--%>
                                                    <!-- Modal-->
                                                        <%--   <div id="myModal_${li.index+1}" tabindex="-1" role="dialog"
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
                                                                           <p>Are you sure want to delete this account?</p>
                                                                       </div>
                                                                       <div class="modal-footer">
                                                                           <button type="button" data-dismiss="modal"
                                                                                   class="btn btn-secondary">Close
                                                                           </button>
                                                                           <a href="admin.jsp?account=${librarian.getAccount()}">
                                                                                   &lt;%&ndash;                                                                                <a href="admin.jsp?account=${librarian.getAccount()}">&ndash;%&gt;
                                                                               <button type="button"
                                                                                       class="btn btn-primary">
                                                                                   Delete
                                                                               </button>
                                                                           </a>
                                                                       </div>
                                                                   </div>
                                                               </div>
                                                           </div>--%>
                                                        <%-- <a href="EditLibrarian.do?account=${librarian.getAccount()}"
                                                            style="color: #0000c6">order</a>--%>
                                                        <%-- <td>  <form  style="margin: 10px;position: relative" action="ReaderSearchServlet"
                                                                      name="search" method="post">
                                                                 <input type="hidden" name="number" value="${book.getBookNumber()}" />
                                                                 <input type="submit" value="order"></form>
                                                             </td>--%>
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