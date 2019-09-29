package servlet;

import dao.ReaderDao;
import entity.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReaderEditServlet")
public class ReaderEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String preAccount = (String) request.getParameter("preAccount");
        String account = (String) request.getParameter("account");
        String password = (String) request.getParameter("password");
        String name = (String) request.getParameter("name");
        String email = (String) request.getParameter("email");
        int deposit = Integer.parseInt(request.getParameter("deposit"));
        ReaderDao readerDao = new ReaderDao();
        boolean canEdit = true;
        //保存之前的数据
        Reader reader = new Reader(preAccount, password, name, email, deposit);
        if (!account.equals(preAccount)) {
            //当两者不相等时，判断新改的账号是否与之前数据库其他里有重复的
            canEdit = !readerDao.isExistInDB(account);
        }
        if (!canEdit) {
            request.setAttribute("reader", reader);
            request.getRequestDispatcher("reader_edit.jsp?info=error").forward(request, response);
        } else {
            readerDao.editReader(account, password, name, email, deposit, preAccount);
            reader = readerDao.info(account);
            request.setAttribute("reader", reader);
            request.getRequestDispatcher("reader_edit.jsp?info=success").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String account = (String) request.getParameter("account");
        ReaderDao readerDao = new ReaderDao();
        Reader reader = readerDao.info(account);
        request.setAttribute("reader", reader);
        request.getRequestDispatcher("reader_edit.jsp").forward(request, response);
    }
}
