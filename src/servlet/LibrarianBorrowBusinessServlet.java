package servlet;

import dao.ReaderReserveDao;
import entity.ReaderReserve;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LibrarianBorrowBusinessServlet")
public class LibrarianBorrowBusinessServlet extends HttpServlet {

    private ReaderReserveDao readerReserveDao = new ReaderReserveDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ReaderReserve> readerReserveList = readerReserveDao.getReaderReserveList();
        session.setAttribute("readerReserveList", readerReserveList);
        request.getRequestDispatcher("librarian_borrow_business.jsp").forward(request, response);
    }
}
