package servlet;

import dao.NoticeDao;
import entity.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LibrarianNoticeListServlet")
public class LibrarianNoticeListServlet extends HttpServlet {
    NoticeDao noticeBao = new NoticeDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Notice> notices = noticeBao.getNotice();
        request.setAttribute("notices", notices);
        request.getRequestDispatcher("librarian.jsp").forward(request, response);
    }
}
