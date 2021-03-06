<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/23
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="dao.LibrarianDao" %>

<%
    String path = request.getServletPath();
    //out.print( request.getServletPath() );
    pageContext.setAttribute("path", path);

    int tag = 0;
    String[] BookManage = {
            "/book_add.jsp",
            "/book_add_index.jsp",
            "/book_edit.jsp",
            "/librarian_book_list.jsp",
            "/book_category_add.jsp",
            "/book_category_edit.jsp",
            "/book_category_list.jsp",
    };
    boolean isContains1 = Arrays.asList(BookManage).contains(path);
    if (isContains1) {
        tag = 1;
    }

    String[] BusinessProcess = {
            "/librarian_borrow_business.jsp",
            "/librarian_reserve_business.jsp",
            "/librarian_return_business.jsp",
    };
    boolean isContains2 = Arrays.asList(BusinessProcess).contains(path);
    if (isContains2) {
        tag = 2;
    }

    String[] RecordQuery = {
            "/librarian_book_borrow_list.jsp",
            "/book_delete_list.jsp",
            "/librarian_income_history_business.jsp",
    };
    boolean isContains3 = Arrays.asList(RecordQuery).contains(path);
    if (isContains3) {
        tag = 3;
    }

    String[] Notice = {
            "/notice_list.jsp",
            "/notice_post.jsp",
    };
    boolean isContains4 = Arrays.asList(Notice).contains(path);
    if (isContains4) {
        tag = 4;
    }

    //out.print( tag );
    pageContext.setAttribute("tag", tag);
%>

<nav class="side-navbar">
    <!-- Sidebar Header-->
    <div class="sidebar-header d-flex align-items-center">
        <div class="avatar"><img src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
        <div class="title">
            <h1 class="h4">
                <%
                    String account = (String) session.getAttribute("account");
                    LibrarianDao librarianDao = new LibrarianDao();
                    String name = (String) librarianDao.info(account).getName();
                    out.println(name);
                %>
            </h1>
            <p>
                <%
                    String user_type = (String) librarianDao.info(account).getType();
                    out.println(user_type);
                %>
            </p>
        </div>
    </div>
    <%--            <!-- Sidebar Navidation Menus--><span class="heading">Main</span>--%>

    <%--    侧边栏的目录      --%>
    <ul class="list-unstyled">
        <li><a href="#BookManage" aria-expanded="${ tag eq 1 ? "true" : "false" }" data-toggle="collapse"> <i
                class="icon-interface-windows"></i><strong>Book Manage</strong></a>
            <ul id="BookManage" class="${ tag eq 1 ? "collapse list-unstyled show" : "collapse list-unstyled "}">
                <li><a href="BookList.do"><strong>Book List</strong></a></li>
                <li><a href="BookCategoryList.do"><strong>Category List</strong></a></li>
            </ul>
        </li>

        <li><a href="ReaderList.do"> <i
                class="icon-interface-windows"></i><strong>Reader Manage</strong></a></li>

        <li><a href="#BusinessProcess" aria-expanded="${ tag eq 2 ? "true" : "false" }" data-toggle="collapse"> <i
                class="icon-interface-windows"></i><strong>Business Process</strong></a>
            <ul id="BusinessProcess" class="${ tag eq 2 ? "collapse list-unstyled show" : "collapse list-unstyled "}">
                <li><a href="librarian_borrow_business.jsp"><strong>Borrow Business</strong></a></li>
                <li><a href="ReserveBusiness.do"><strong>Reserve Business</strong></a></li>
                <li><a href="ReturnBusiness.do"><strong>Return Business</strong></a></li>
            </ul>
        </li>
        <li><a href="#RecordQuery" aria-expanded="${ tag eq 3 ? "true" : "false" }" data-toggle="collapse"> <i
                class="icon-interface-windows"></i><strong>Record Query</strong></a>
            <ul id="RecordQuery" class="${ tag eq 3 ? "collapse list-unstyled show" : "collapse list-unstyled "}">
                <li><a href="librarian_book_borrow_list.jsp"><strong>Reader History</strong></a></li>
                <li><a href="BookDeletedList.do"><strong>Book Deletion</strong></a></li>
                <li><a href="IncomeHistory.do"><strong>Income History</strong></a></li>
            </ul>
        </li>
        <li><a href="#NoticeEdit" aria-expanded="${ tag eq 4 ? "true" : "false" }" data-toggle="collapse"> <i
                class="icon-interface-windows"></i>Notice</a>
            <ul id="NoticeEdit" class="${ tag eq 4 ? "collapse list-unstyled show" : "collapse list-unstyled "}">
                <li><a href="NoticeList.do">Notice List</a></li>
                <li><a href="NoticePost.do">Post Notice</a></li>
            </ul>
        </li>

    </ul>
</nav>