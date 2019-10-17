<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/23
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays" %>

<%
    String path = request.getServletPath();
    //out.print( request.getServletPath() );
    pageContext.setAttribute("path",path);

    int tag = 0;
    String[] BookManage = {
            "/book_add.jsp",
            "/librarian_book_list.jsp",
            "/book_add.jsp",
            "/book_category_add.jsp",
            "/book_category_edit.jsp",
            "/book_category_list.jsp",
    };
    boolean isContains1 = Arrays.asList(BookManage).contains(path);
    if(isContains1) {
        tag = 1;
    }

    String[] BusinessProcess = {
            "/.jsp",
    };
    boolean isContains2 = Arrays.asList(BusinessProcess).contains(path);
    if(isContains2){
        tag = 2;
    }

    String[] RecordQuery = {
            "/reader_borrowHistory.jsp",

    };
    boolean isContains3 = Arrays.asList(RecordQuery).contains(path);
    if(isContains3){
        tag = 3;
    }

    String[] Notice = {
            "/.jsp",
    };
    boolean isContains4 = Arrays.asList(Notice).contains(path);
    if(isContains4){
        tag = 4;
    }

    //out.print( tag );
    pageContext.setAttribute("tag",tag);
%>

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
    <%--            <!-- Sidebar Navidation Menus--><span class="heading">Main</span>--%>

    <%--    侧边栏的目录      --%>
    <ul class="list-unstyled">
        <li><a href="#BookManage" aria-expanded="${ tag eq 1 ? "true" : "false" }" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Book Manage</a>
            <ul id="BookManage" class="${ tag eq 1 ? "collapse list-unstyled show" : "collapse list-unstyled "}">
                <li><a href="BookList.do">Book List</a></li>
                <li><a href="BookAdd.do">Add Book</a></li>
                <li><a href="BookCategoryList.do" >Category List</a></li>
            </ul>
        </li>

        <li><a href="ReaderList.do"> <i
                class="icon-interface-windows"></i>Reader Manage</a></li>

        <li><a href="#BusinessProcess" aria-expanded="false" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Business Process</a>
            <ul id="BusinessProcess" class="collapse list-unstyled ">
                <li><a href="BorrowBusiness.do">Borrow Business</a></li>
                <li><a href="ReturnBusiness.do">Return Business</a></li>
            </ul>
        </li>
        <li><a href="#RecordQuery" aria-expanded="${ tag eq 3 ? "true" : "false" }" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Record Query</a>
            <ul id="RecordQuery" class="${ tag eq 3 ? "collapse list-unstyled show" : "collapse list-unstyled "}">
                <li><a href="#">Reader History</a></li>
                <li><a href="#">Book Deletion</a></li>
                <li><a href="#">Total Deposit</a></li>
                <li><a href="#">Total Fine</a></li>

            </ul>
        </li>
        <li><a href="#NoticeEdit" aria-expanded="${ tag eq 4 ? "true" : "false" }" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Notice</a>
            <ul id="NoticeEdit" class="${ tag eq 4 ? "collapse list-unstyled show" : "collapse list-unstyled "}">
                <li><a href="#">Notice List</a></li>
                <li><a href="#">Post Notice</a></li>
            </ul>
        </li>
    </ul>
</nav>