package servlet;

import dao.NoticeDao;
import dao.LibrarianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NoticeDeleteServlet")
public class NoticeDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String id = (String) request.getParameter("id");
        NoticeDao noticeDao = new NoticeDao();
        boolean exist = noticeDao.isExitInDB(id);
        if (!exist) {
            response.sendRedirect("notice_list.jsp?info=delete_error");
        } else {
            noticeDao.deleteNotice(id);
            response.sendRedirect("notice_list.jsp?info=delete_success");
        }
    }
}