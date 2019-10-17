<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/23
  Time: 17:29
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
    <ul class="list-unstyled">
        <li><a href="#LibrarianManage" aria-expanded="false" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Librarian Manage</a>
            <ul id="LibrarianManage" class="collapse list-unstyled ">
                <li><a href="LibrarianListPage">Librarian List</a></li>
                <li><a href="librarian_add.jsp">Add Librarian</a></li>
                <li><a href="findBackLibrarianPassword.do">Find Back Librarian Password</a></li>
            </ul>
        </li>
        <li><a href="#SystemSettings" aria-expanded="false" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>System Settings</a>
            <ul id="SystemSettings" class="collapse list-unstyled ">
                <li><a href="${pageContext.request.contextPath}/SystemSettingsServlet">System Settings</a></li>
            </ul>
        </li>
        <li><a href="#AccountSettings" aria-expanded="false" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Account Settings</a>
            <ul id="AccountSettings" class="collapse list-unstyled ">
                <li><a href="admin_info.jsp">About Account</a></li>
                <li><a href="${pageContext.request.contextPath}/admin_change_password.jsp">Change Password</a></li>
            </ul>
        </li>
<%--        <li><a href="tables.html"> <i class="icon-grid"></i>(素材入口） </a></li>--%>
    </ul>
</nav>