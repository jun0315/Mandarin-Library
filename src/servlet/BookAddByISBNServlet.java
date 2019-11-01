package servlet;

import dao.BookCategoryDao;
import entity.Book;
import entity.BookCategory;
import utils.GetBookInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class BookAddByISBNServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    //TODO ISBN处理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ISBN = request.getParameter("BookNumber");
//        GetBookInfo getBookInfo = new GetBookInfo(ISBN);
        Book book = new Book();
        book.setBookNumber("9787540210694");
        book.setAuthor("Les Misérables");
        book.setName("悲惨世界");
        book.setPress("北京燕山出版社");
        book.setDescription("这是法国十九世纪浪漫派领袖雨果继《巴黎圣母院》之后创作的又一部气势恢宏的鸿篇巨著");
        request.setAttribute("bookFromISBN", book);
        BookCategoryDao bookCategoryDao = new BookCategoryDao();
        List<BookCategory> bookCategories = bookCategoryDao.getBookCategories();
        request.setAttribute("bookCategories", bookCategories);
        request.getRequestDispatcher("book_add.jsp").forward(request, response);
    }
}
