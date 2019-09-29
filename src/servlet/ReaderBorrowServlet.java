package servlet;

import dao.ReaderBorrowDao;
import entity.ReaderBorrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
/**
*@author 刘威
 * @version 1.0
 *用于实现Reader的view功能，访问数据库的reader_borrow表
**/

@WebServlet(name = "ReaderBorrowServlet")
public class ReaderBorrowServlet extends HttpServlet {
    private ReaderBorrowDao readerBorrowDao = new ReaderBorrowDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ReaderBorrow> readerBorrowList = readerBorrowDao.getReaderBorrowList((String) session.getAttribute("account"));
        request.setAttribute("readerBorrowList", readerBorrowList);
        request.getRequestDispatcher("reader_view.jsp").forward(request, response);
    }
}
