package servlet;

import dao.BookCategoryDao;
import dao.BookDao;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookEditServlet")
public class BookEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String perBookNumber = (String) request.getParameter("perBookNumber");
        String bookNumber = (String) request.getParameter("bookNumber");
        String name = (String) request.getParameter("name");
        String press = (String) request.getParameter("press");
        double price = Double.valueOf(request.getParameter("price"));
        String author = (String) request.getParameter("author");
        String category = (String) request.getParameter("category");
        String preCategory = (String) request.getParameter("preCategory");
        int amount = Integer.valueOf(request.getParameter("amount"));
        String description = (String) request.getParameter("description");

        BookDao bookDao = new BookDao();
        Book book = new Book(bookNumber, name, press, price, author, category, amount, description);
        BookCategoryDao bookCategoryDao = new BookCategoryDao();

        boolean canEdit = true;
        if (!bookNumber.equals(perBookNumber)) {
            //当两者不相等时，判断新改的账号是否与之前数据库其他里有重复的
            canEdit = !bookDao.isExitInDB(book.getBookNumber());
        }
        if (!canEdit) {
            request.setAttribute("book", book);
            request.getRequestDispatcher("book_edit.jsp?info=error").forward(request, response);

        } else if (!category.equals(preCategory)&&!bookCategoryDao.isExistInDB(category)) {
            //当两者不相等时，判断新的category是否存在数据库中，再判断如果新category不在数据库中，发送错误信息
                request.setAttribute("book",book);
                request.getRequestDispatcher("book_edit.jsp?info=error_category").forward(request, response);
        } else {

            bookDao.editBook(bookNumber, name, press, Double.toString(price), author, category, Integer.toString(amount), description);
            book = bookDao.info(bookNumber);
            request.setAttribute("book", book);
            request.getRequestDispatcher("book_edit.jsp?info=success").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String bookNumber = (String) request.getParameter("bookNumber");

        BookDao bookDao = new BookDao();
        Book book = bookDao.info(bookNumber);
        request.setAttribute("book", book);

        request.getRequestDispatcher("book_edit.jsp").forward(request, response);
    }
}