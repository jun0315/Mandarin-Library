<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/23
  Time: 17:20
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
        <li><a href="#BookManage" aria-expanded="false" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Book Manage</a>
            <ul id="BookManage" class="collapse list-unstyled ">
                <li><a href="#">Book List</a></li>
                <li><a href="#">Add Book</a></li>
                <li><a href="book_category_add.jsp">Add Book Category and Location</a></li>
                <li><a href="book_category_list.do">Category List</a></li>
            </ul>
        </li>
        <li><a href="#ReaderManage" aria-expanded="false" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Reader Manage</a>
            <ul id="ReaderManage" class="collapse list-unstyled ">
                <li><a href="#">Reader List</a></li>
            </ul>
        </li>

        <li><a href="#BusinessProcess" aria-expanded="false" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Business Process</a>
            <ul id="BusinessProcess" class="collapse list-unstyled ">
                <li><a href="#">Borrow Business</a></li>
                <li><a href="#">Return Business</a></li>
            </ul>
        </li>
        <li><a href="#RecordQuery" aria-expanded="false" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Record Query</a>
            <ul id="RecordQuery" class="collapse list-unstyled ">
                <li><a href="#">Reader History</a></li>
                <li><a href="#">Book Deletion</a></li>
                <li><a href="#">Total Deposit</a></li>
                <li><a href="#">Total Fine</a></li>

            </ul>
        </li>
        <li><a href="#NoticeEdit" aria-expanded="false" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Notice</a>
            <ul id="NoticeEdit" class="collapse list-unstyled ">
                <li><a href="#">Notice List</a></li>
                <li><a href="#">Post Notice</a></li>
            </ul>
        </li>
    </ul>
</nav>
