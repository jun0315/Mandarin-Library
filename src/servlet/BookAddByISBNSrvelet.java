package servlet;

import entity.Book;
import utils.GetBookInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class BookAddByISBNSrvelet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ISBN = request.getParameter("ISBN");
//        GetBookInfo getBookInfo = new GetBookInfo(ISBN);
        Book book = new Book();
//        book.setAuthor(getBookInfo.getAuthor());
//        book.setName(getBookInfo.getTitle());
//        book.setPress(getBookInfo.getPublisher());
        //test
        book.setPress("test");
        request.setAttribute("bookFromISBN", book);
        request.getRequestDispatcher("book_add.jsp").forward(request, response);
    }
}
