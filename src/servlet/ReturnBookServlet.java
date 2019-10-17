package servlet;

import dao.ReaderBorrowDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        //获取要通过的预约参数user_account,copy_id
        String user_account = (String) request.getParameter("user_account");
        String copy_id = (String) request.getParameter("book_copy_id");
        //还书
        ReaderBorrowDao readerBorrowDao = new ReaderBorrowDao();
        readerBorrowDao.ReturnBook(copy_id, user_account);
        //操作成功后返回到原页面，等同于刷新原页面
        response.sendRedirect("ReturnBusiness.do?info=return_success");
    }
}
