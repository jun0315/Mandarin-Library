package servlet;

import dao.NoticeDao;
import entity.Notice;
import jdk.nashorn.tools.Shell;
import utils.BarCodeUtil;
import utils.BuiltCopyID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NoticePostServlet")
public class NoticePostServlet extends HttpServlet {
    NoticeDao noticeDao = new NoticeDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = (String) request.getParameter("id");
        String topic = (String) request.getParameter("topic");
        String content = (String) request.getParameter("content");

        NoticeDao noticeDao = new NoticeDao();
        boolean exit = noticeDao.isExitInDB(id);
        if (exit) {
            response.sendRedirect("notice_post.jsp?info=error");
        } else {
            //在notice中添加
            noticeDao.addNotice(id, topic, content);
            response.sendRedirect("notice_post.jsp?info=success");
    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Notice> notices = noticeDao.getNotice();
        request.setAttribute("notices", notices);
        request.getRequestDispatcher("notice_post.jsp").forward(request, response);
    }
}
