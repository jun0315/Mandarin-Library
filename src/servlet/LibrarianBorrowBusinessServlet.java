package servlet;

import dao.*;
import entity.Reader;
import entity.ReaderReserve;
import utils.BarCodeUtil;

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
        String user_account = (String) request.getParameter("user_account");
        String copy_id = (String) request.getParameter("copy_id");
        ReaderDao readerDao = new ReaderDao();
        Reader reader = readerDao.info(user_account);
        //如果读者的押金不足
        if (reader.getDeposit() <= 0)
            response.sendRedirect("librarian_borrow_business.jsp?info=deposit_not_enough");
            //如果读者借书已经达到3本
        else if (reader.getBorrowing_count() >= 3)
            response.sendRedirect("librarian_borrow_business.jsp?info=reach_the_upper_limit");
        else {
            //获取书名
            BookDetailDao bookDetailDao = new BookDetailDao();
            String book_number = bookDetailDao.getBookNumberByCopyID(copy_id);
            BookDao bookDao = new BookDao();
            String book_name = bookDao.getBookNameByBookNumber(book_number);
            //增加借阅记录并修改副本状态
            ReaderBorrowDao readerBorrowDao = new ReaderBorrowDao();
            readerBorrowDao.addReaderBorrow(user_account, copy_id, book_name);
            bookDetailDao.changeBookStatus(copy_id, 0);
            //reader的borrow_count加1
            reader.setBorrowing_count(reader.getBorrowing_count()+1);
            response.sendRedirect("librarian_borrow_business.jsp?info=borrow_success");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
