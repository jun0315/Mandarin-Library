package servlet;

import dao.ReaderDao;
import utils.FindReaderPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReaderDao readerDao = new ReaderDao();
        String account = request.getParameter("account");
        String newPWD = request.getParameter("password");
        if (newPWD != null) {
            //此时是正在修改密码
            readerDao.editPasswordByEmail(account,newPWD);
            response.sendRedirect("index.jsp?forget=done");
        } else {
            //此时是打算修改密码
            String Email = readerDao.getEmailByAccount(account);
            FindReaderPassword.findPassword(Email, account,request);
            response.sendRedirect("forget.jsp?forget=yes");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
