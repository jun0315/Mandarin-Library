<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Librarian" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.BookCategory" %>
<%@ page import="dao.BookCategoryDao" %>
<%@ page import="entity.Book" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var ISBN_flag = true;

    function changeISBN() {
        var bookNo = document.getElementById("bookNo");
        var ClickISBNorMSBN = document.getElementById("ClickISBNorMSBN");
        var ImportISBN = document.getElementById("importISBN");
        if (ISBN_flag) {
            ISBN_flag = false;
            bookNo.innerHTML = "MSBN";
            ClickISBNorMSBN.innerHTML = "Have ISBN";
            ImportISBN.style.display = 'none';
        } else if (!ISBN_flag) {
            ISBN_flag = true;
            bookNo.innerHTML = "ISBN";
            ClickISBNorMSBN.innerHTML = "Have No ISBN";
            ImportISBN.style.display = "";
        }
    }
</script>
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
                    <h2 class="no-margin-bottom">Add Book</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="librarian.jsp">Home</a></li>
                    <li class="breadcrumb-item active">Add the new book</li>
                </ul>
            </div>
            <%! String nameFromAPI = "";%>
            <%! String authorFromAPI = "";%>
            <%! String pressFromAPI = "";%>
            <%! String describeFromAPI = "";%>
            <%! String bookNumberFromAPI = "";%>
            <%
                Book book = (Book) request.getAttribute("bookFromISBN");
                request.setAttribute("bookFromISBN", null);
                if (book != null) {
                    bookNumberFromAPI = book.getBookNumber();
                    nameFromAPI = book.getName();
                    authorFromAPI = book.getAuthor();
                    pressFromAPI = book.getPress();
                    describeFromAPI = book.getDescription();
                }
            %>
            <section
                    class="tables">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <p>Add the new book</p>
                            <form class="form-horizontal" action="BookAdd.do" method="post">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label" id="bookNo">ISBN</label>
                                    <div class="col-sm-9">
                                        <input id="BookNumber"
                                               class="form-control form-control-success" value="<%=bookNumberFromAPI%>">
                                        <a href="#" id=ClickISBNorMSBN onclick="changeISBN()">Have No ISBN</a>
                                        <%--                                            <input type="submit" value="Submit" class="btn btn-primary" id="importISBN">Import ISBN</input>--%>
                                        <a href="AddBookByISBN.do" id="importISBN">Import ISBN</a>

                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Name</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalSuccess" name="name"
                                               class="form-control form-control-success" value="<%=nameFromAPI%>">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Press</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalSuccess" name="press"
                                               class="form-control form-control-success" value="<%=pressFromAPI%>">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label" }>Author</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalSuccess" name="author"
                                               class="form-control form-control-success" value="<%=authorFromAPI%>">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Description</label>
                                    <div class="col-sm-9">
                                        <input name="description"
                                               class="form-control form-control-success" value="<%=describeFromAPI%>">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Price</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalSuccess" name="price"
                                               class="form-control form-control-success">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Category</label>
                                    <div class="col-sm-9">
                                        <select name="category" class="form-control form-control-success">
                                            <%List<BookCategory> bookCategories = (List<BookCategory>) request.getAttribute("bookCategories");%>
                                            <c:forEach items="${bookCategories}" var="bookCategory" varStatus="li">
                                                <option id="category"
                                                        value="${bookCategory.getCategory()}">${bookCategory.getCategory()}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Amount</label>
                                    <div class="col-sm-9">
                                        <input id="inputHorizontalSuccess" name="amount"
                                               class="form-control form-control-success">
                                        <%--                                        <small class="form-text">Example help text that remains unchanged.</small>--%>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-9 offset-sm-3">
                                        <input type="submit" value="Submit" class="btn btn-primary">
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
        alert("successfully add!");
    } else if (info == 'error') {
        alert("add failure because of have the same account!");
    }
</script>
<!-- JavaScript files-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/popper.js/umd/popper.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="vendor/chart.js/Chart.min.js1"></script>
<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="js/charts-home.js"></script>
<!-- Main File-->
<script src="js/front.js"></script>
</body>
</html>