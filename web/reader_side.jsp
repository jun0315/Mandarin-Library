<%--
  Created by IntelliJ IDEA.
  User: 刘威
  Date: 2019/9/25
  Time: 16:34
  实现读者界面的侧边栏
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
    <ul class="list-unstyled">
        <li><a href="BorrowHistory.do"> <i class="icon-bill"></i>Borrowing History</a></li>
        <li><a href="reader_search.jsp"> <i class="icon-search"></i>Search Book</a></li>
        <li><a href="tables.html"> <i class="icon-home"></i>Account Setting</a></li>
    </ul>
</nav>
