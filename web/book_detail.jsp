<%@ page import="entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: owner
  Date: 2019/10/17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book detail</title>
</head>
<body>
<%
    Book book= (Book) request.getAttribute("book");
%>
<tr>

    <a>发明</a>
    <td>${book.getBookNumber()}</td>
    <td>${book.getName()}</td>
    <td>${book.getPress()}</td>
    <td>${book.getAuthor()}</td>
    <td>



</body>
</html>
