<%--
  Created by IntelliJ IDEA.
  User: 刘威
  Date: 2019/9/25
  Time: 16:34
  实现读者界面的侧边栏
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
        <li><a href="ReaderBorrowServlet.do"> <i class="icon-bill"></i>Borrowing History</a></li>
        <li><a href="tables.html"> <i class="icon-search"></i>Search Book</a></li>
        <li><a href="tables.html"> <i class="icon-home"></i>Account Setting</a></li>
    </ul>
</nav>
