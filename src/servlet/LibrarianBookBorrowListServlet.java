package servlet;

import dao.ReaderBorrowDao;
import entity.ReaderBorrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 刘威
 * @version 1.0
 * 用于实现Reader的view功能，访问数据库的reader_borrow表
 **/

@WebServlet(name = "ReaderBorrowServlet")
public class LibrarianBookBorrowListServlet extends HttpServlet {
    private ReaderBorrowDao readerBorrowDao = new ReaderBorrowDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ReaderBorrow> readerBorrows = readerBorrowDao.getReaderBorrowList((String) request.getParameter("SearchReaderID"));
        request.setAttribute("readerBorrowList", readerBorrows);
        request.getRequestDispatcher("librarian_book_borrow_list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
