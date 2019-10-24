package servlet;

import dao.BookCategoryDao;
import entity.Book;
import entity.BookCategory;
import utils.GetBookInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class BookAddByISBNServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    //TODO ISBN处理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String ISBN = request.getParameter("BookNumber");
        String ISBN = "9780131872486";
        GetBookInfo getBookInfo = new GetBookInfo(ISBN);
        Book book = new Book();
        book.setBookNumber(ISBN);
        book.setAuthor(getBookInfo.getAuthor());
        book.setName(getBookInfo.getTitle());
        book.setPress(getBookInfo.getPublisher());
        book.setDescription(getBookInfo.getDescription());
        request.setAttribute("bookFromISBN", book);
        BookCategoryDao bookCategoryDao = new BookCategoryDao();
        List<BookCategory> bookCategories = bookCategoryDao.getBookCategories();
        request.setAttribute("bookCategories", bookCategories);
        request.getRequestDispatcher("book_add.jsp").forward(request, response);
    }
}
