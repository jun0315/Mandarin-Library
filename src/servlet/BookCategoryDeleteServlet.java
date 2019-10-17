package servlet;

import dao.BookCategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookCategoryDeleteServlet")
public class BookCategoryDeleteServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String category = (String) request.getParameter("category");
        BookCategoryDao bookCategoryDao = new BookCategoryDao();
        boolean exist = bookCategoryDao.isExistInDB(category);
        if (!exist) {
            response.sendRedirect("book_category_list.jsp?info=delete_error");
        } else {
            bookCategoryDao.deleteBookCategory(category);
            response.sendRedirect("book_category_list.jsp?info=delete_success");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
