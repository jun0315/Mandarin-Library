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
    }

    //TODO ISBN处理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String ISBN = request.getParameter("BookNumber");
        String ISBN = "9787115216878";
        GetBookInfo getBookInfo = new GetBookInfo(ISBN);
        Book book = new Book();
        book.setBookNumber(ISBN);
        book.setAuthor(getBookInfo.getAuthor());
        book.setName(getBookInfo.getTitle());
//        book.setPress(getBookInfo.getPublisher());
        book.setPress("人民邮电出版社");
//        book.setDescription(getBookInfo.getDescription());
        book.setDescription("本书提出一种观念：代码质量与其整洁度成正比。干净的代码，既在质量上较为可靠，也为后期维护、升级奠定了良好基础。作为编程领域的佼佼者，本书作者给出了一系列行之有效的整洁代码操作实践。这些实践在本书中体现为一条条规则(或称“启示”)，并辅以来自现实项目的正、反两面的范例。只要遵循这些规则，就能编写出干净的代码，从而有效提升代码质量。");
        request.setAttribute("bookFromISBN", book);
        BookCategoryDao bookCategoryDao = new BookCategoryDao();
        List<BookCategory> bookCategories = bookCategoryDao.getBookCategories();
        request.setAttribute("bookCategories", bookCategories);
        request.getRequestDispatcher("book_add.jsp").forward(request, response);
    }
}
