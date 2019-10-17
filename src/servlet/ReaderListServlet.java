package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Reader;
import dao.ReaderDao;

/**
 * Servlet implementation class ReaderListServlet
 */
@WebServlet(name = "ReaderListServlet")
public class ReaderListServlet extends HttpServlet {
    private ReaderDao readerDao = new ReaderDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reader> readers = readerDao.getReaders();
        request.setAttribute("readers", readers);
        request.getRequestDispatcher("reader_list.jsp").forward(request, response);
    }
}