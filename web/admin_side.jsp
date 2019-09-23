<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/23
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li><a href="librarian_add.jsp">Librarian Add</a></li>
            </ul>
        </li>
        <li><a href="#ReaderRule" aria-expanded="false" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Reader Rule</a>
            <ul id="ReaderRule" class="collapse list-unstyled ">
                <li><a href="#">Rule List</a></li>
                <li><a href="#">Rule Edit</a></li>
                <li><a href="#">Rule Add</a></li>
            </ul>
        </li>
        <li><a href="#AccountManage" aria-expanded="false" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Account Manage</a>
            <ul id="AccountManage" class="collapse list-unstyled ">
                <li><a href="#">Account Information</a></li>
                <li><a href="#">Reset Password</a></li>
            </ul>
        </li>
        <li><a href="tables.html"> <i class="icon-grid"></i>(素材入口） </a></li>
    </ul>
</nav>