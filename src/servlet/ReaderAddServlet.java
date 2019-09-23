package servlet;

import dao.ReaderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReaderAddServlet")
public class ReaderAddServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String account = (String) request.getParameter("account");
        String password = (String) request.getParameter("password");
        String name = (String) request.getParameter("name");
        String email = (String) request.getParameter("email");
        int deposit = Integer.parseInt( request.getParameter("deposit"));
        ReaderDao readerDao = new ReaderDao();
        boolean exit = readerDao.isExistInDB(account);
        if (exit) {
            response.sendRedirect("reader_add.jsp?info=error");
        } else {
            readerDao.addReader(name,account,password,email,deposit);
            response.sendRedirect("reader_add.jsp?info=success");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("librarian_add.jsp?info=success");
    }
}
