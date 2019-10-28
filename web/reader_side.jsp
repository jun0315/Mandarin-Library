<%@ page import="dao.ReaderDao" %><%--
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
                    String account = (String) session.getAttribute("account");
                    ReaderDao readerDao = new ReaderDao();
                    String name = (String) readerDao.info(account).getName();
                    out.println(name);
                %>
            </h1>
            <p>
                <%
                    String user_type = (String) readerDao.info(account).getType();
                    out.println(user_type);
                %>
            </p>
        </div>
    </div>
    <%--            <!-- Sidebar Navidation Menus--><span class="heading">Main</span>--%>
    <ul class="list-unstyled">
        <li><a href="reader.jsp"> <i class="icon-bill"></i>Home</a></li>
        <li><a href="BorrowHistory.do"> <i class="icon-bill"></i>Borrowing History</a></li>
        <li><a href="reader_search.jsp"> <i class="icon-search"></i>Search Book</a></li>
        <li><a href="reader_account_setting.jsp"> <i class="icon-home"></i>Account Setting</a></li>
    </ul>
</nav>
