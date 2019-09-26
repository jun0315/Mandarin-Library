package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Reader;
import dao.ReaderDao;

/**
 * Servlet implementation class ReaderListServlet
 */
public class ReaderListServlet extends HttpServlet {

    private ReaderDao readerDao = ReaderDao.getInstance();

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        int start = 0;
        int count = 5;

        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {
        }

        int next = start + count;
        int pre = start - count;

        int total = readerDao.getTotal();

        int last;
        if (0 == total % count)
            last = total - count;
        else
            last = total - total % count;

        pre = pre < 0 ? 0 : pre;
        next = next > last ? last : next;

        request.setAttribute("next", next);
        request.setAttribute("pre", pre);
        request.setAttribute("last", last);

        List<Reader> readers = readerDao.getReaders(start, count);
        request.setAttribute("readers", readers);

        request.getRequestDispatcher("ListReaders.jsp").forward(request, response);
    }
}