package servlet;

import dao.BookCategoryDao;
import entity.BookCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookCategoryListServlet")
public class BookCategoryListServlet extends HttpServlet {
    BookCategoryDao bookCategoryDao = new BookCategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookCategory> bookCategories = bookCategoryDao.getBookCategories();
        request.setAttribute("bookCategories",bookCategories);
        request.getRequestDispatcher("book_category_list.jsp").forward(request,response);
    }
}
