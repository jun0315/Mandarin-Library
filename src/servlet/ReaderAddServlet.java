package servlet;

import dao.ReaderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReaderAddServlet")
public class ReaderAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String account = (String) request.getParameter("account");
        String password = (String) request.getParameter("password");
        String name = (String) request.getParameter("name");
        String email = (String) request.getParameter("email");
        int deposit = Integer.parseInt(request.getParameter("deposit"));

        ReaderDao readerDao = ReaderDao.getInstance();
        boolean exist = readerDao.isExistInDB(account);
        if (exist) {
            response.sendRedirect("reader_add.jsp?info=error");
        } else {
            readerDao.addReader(account, password, name, email, deposit);
            response.sendRedirect("reader_add.jsp?info=success");
        }
    }
}
