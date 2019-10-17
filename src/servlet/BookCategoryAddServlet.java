package servlet;

import dao.BookCategoryDao;
import dao.LibrarianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookCategoryAddServlet")
public class BookCategoryAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String category = (String) request.getParameter("category");
        BookCategoryDao bookCategoryDao = new BookCategoryDao();
        boolean exit = bookCategoryDao.isExitInDB(category);
        if (exit) {
            response.sendRedirect("book_category_add.jsp?info=error");
        } else {
            bookCategoryDao.addCategory(category);
            response.sendRedirect("book_category_add.jsp?info=success");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
