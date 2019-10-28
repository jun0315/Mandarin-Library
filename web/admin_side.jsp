<%@ page import="dao.AdminDao" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/23
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="dao.LibrarianDao" %>

<%
    String path = request.getServletPath();
    //out.print( request.getServletPath() );
    pageContext.setAttribute("path",path);

    int tag = 0;
    String[] LibrarianManage = {
            "/librarian_list.jsp",
            "/librarian_add.jsp",
            "/findBackLibrarianPassword.do",
    };
    boolean isContains1 = Arrays.asList(LibrarianManage).contains(path);
    if(isContains1) {
        tag = 1;
    }

    String[] AccountSettings = {
            "admin_info/.jsp",
            "admin_change_password.jsp",
    };
    boolean isContains2 = Arrays.asList(AccountSettings).contains(path);
    if(isContains2){
        tag = 2;
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
                    String account = (String) session.getAttribute("account");
                    AdminDao adminDao = new AdminDao();
                    String name = (String) adminDao.info(account).getName();
                    out.println(name);
                %>
            </h1>
            <p>
                <%
                    String user_type = (String) adminDao.info(account).getType();
                    out.println(user_type);
                %>
            </p>
        </div>
    </div>
    <%--            <!-- Sidebar Navidation Menus--><span class="heading">Main</span>--%>
    <ul class="list-unstyled">
        <li><a href="#LibrarianManage" aria-expanded="${ tag eq 1 ? "true" : "false" }" data-toggle="collapse"> <i
                class="icon-interface-windows"></i><strong>Librarian Manage</strong></a>
            <ul id="LibrarianManage" class="${ tag eq 1 ? "collapse list-unstyled show" : "collapse list-unstyled "}">
                <li><a href="LibrarianListPage"><strong>Librarian List</strong></a></li>
                <li><a href="librarian_add.jsp"><strong>Add Librarian</strong></a></li>
                <li><a href="findBackLibrarianPassword.do"><strong>Find Back Librarian Password</strong></a></li>
            </ul>
        </li>

        <li><a href="${pageContext.request.contextPath}/SystemSettingsServlet"> <i
                class="icon-interface-windows"></i><strong>System Settings</strong></a>
        </li>

        <li><a href="#AccountSettings" aria-expanded="${ tag eq 2 ? "true" : "false" }" data-toggle="collapse"> <i
                class="icon-interface-windows"></i><strong>Account Settings</strong></a>
            <ul id="AccountSettings" class="${ tag eq 2 ? "collapse list-unstyled show" : "collapse list-unstyled "}">
                <li><a href="admin_info.jsp"><strong>About Account</strong></a></li>
                <li><a href="${pageContext.request.contextPath}/admin_change_password.jsp"><strong>Change Password</strong></a></li>
            </ul>
        </li>
        <%--        <li><a href="tables.html"> <i class="icon-grid"></i>(素材入口） </a></li>--%>
    </ul>
</nav>