package servlet;

import dao.ReaderBorrowDao;
import entity.ReaderBorrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LibrarianReturnBusinessServlet")
public class LibrarianReturnBusinessServlet extends HttpServlet {

    private ReaderBorrowDao readerBorrowDao = new ReaderBorrowDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ReaderBorrow> readerBorrowList = readerBorrowDao.getReaderBorrowList();
        request.setAttribute("readerBorrowList", readerBorrowList);
        request.getRequestDispatcher("librarian_return_business.jsp").forward(request, response);
    }
}
