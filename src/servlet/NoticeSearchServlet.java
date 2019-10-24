package servlet;

import dao.NoticeDao;
import entity.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NoticeSearchServlet")
public class NoticeSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String topic = (String) request.getParameter("searchNotice");
        NoticeDao noticeDao = new NoticeDao();
        Notice notice = noticeDao.info(topic);
        if (notice != null) {
            //为了和list页面统一，放入列表中
            List<Notice> notices = new ArrayList<Notice>();
            notices.add(notice);
            request.setAttribute("notices", notices);
            request.getRequestDispatcher("notice_list.jsp?info=found").forward(request, response);
        } else {
            response.sendRedirect("notice_list.jsp?info=notFound");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
