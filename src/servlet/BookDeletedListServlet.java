package servlet;

import dao.BookDao;
import dao.BookDeleteDao;
import entity.Book;
import entity.BookDelete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookDeletedListServlet")
public class BookDeletedListServlet extends HttpServlet {
    BookDeleteDao bookDeleteDao=new BookDeleteDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookDelete> bookDeletes=BookDeleteDao.getBookDeletes();
        request.setAttribute("bookDeletes",bookDeletes);
        request.getRequestDispatcher("book_delete_list.jsp").forward(request, response);
    }
}
