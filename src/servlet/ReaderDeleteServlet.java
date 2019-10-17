package servlet;

import dao.ReaderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReaderDeleteServlet")
public class ReaderDeleteServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String account = (String) request.getParameter("account");
        ReaderDao readerDao = new ReaderDao();
        boolean exist = readerDao.isExistInDB(account);
        if (!exist) {
            response.sendRedirect("reader_list.jsp?info=delete_error");
        } else {
            readerDao.deleteReader(account);
            response.sendRedirect("reader_list.jsp?info=delete_success");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
