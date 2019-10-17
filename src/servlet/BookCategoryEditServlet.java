package servlet;

import dao.BookCategoryDao;
import dao.LibrarianDao;
import entity.BookCategory;
import entity.Librarian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;

@WebServlet(name = "BookCategoryEditServlet")
public class BookCategoryEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String preCategory = request.getParameter("preCategory");
        String category = (String)request.getParameter("category");
        int floor = Integer.parseInt(request.getParameter("floor"));
        String shelf = (String)request.getParameter("shelf");

        BookCategoryDao bookCategoryDao = new BookCategoryDao();
        boolean canEdit = true;
        //保存之前的数据
        BookCategory bookCategory = new BookCategory(preCategory,floor,shelf);
        if(!category.equals(preCategory)){
            //当两者不相等时，判断新改的账号是否与之前数据库其他里有重复的
            canEdit = !bookCategoryDao.isExistInDB(category);
        }
        if (!canEdit) {
            request.setAttribute("bookCategory",bookCategory);
            request.getRequestDispatcher("book_category_edit.jsp?info=error").forward(request, response);
        } else {
            bookCategoryDao.editBookCategory(category, floor, shelf, preCategory);
            bookCategory = bookCategoryDao.info(category);
            request.setAttribute("bookCategory",bookCategory);
            request.getRequestDispatcher("book_category_edit.jsp?info=success").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String category = (String) request.getParameter("category");
        BookCategoryDao bookCategoryDao = new BookCategoryDao();
        BookCategory bookCategory = bookCategoryDao.info(category);
        request.setAttribute("bookCategory", bookCategory);
        request.getRequestDispatcher("book_category_edit.jsp").forward(request, response);
    }
}
