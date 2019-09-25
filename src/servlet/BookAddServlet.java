package servlet;

import dao.BookCategoryDao;
import entity.BookCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookAddServlet")
public class BookAddServlet extends HttpServlet {
    BookCategoryDao bookCategoryDao = new BookCategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookCategory> bookCategories = bookCategoryDao.getCategories();
        request.setAttribute("bookCategories",bookCategories);
        request.getRequestDispatcher("book_add.jsp").forward(request,response);
    }
}
