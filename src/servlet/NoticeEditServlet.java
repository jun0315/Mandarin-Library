package servlet;

import dao.NoticeDao;
import dao.LibrarianDao;
import entity.Notice;
import entity.Librarian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NoticeEditServlet")
public class NoticeEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String preid = (String) request.getParameter("preid");
        String id = (String) request.getParameter("id");
        String topic = (String) request.getParameter("topic");
        String content = (String) request.getParameter("content");

        NoticeDao noticeDao = new NoticeDao();
        Notice notice = new Notice(id, topic, content);

        boolean canEdit = true;
        if (!id.equals(preid)) {
            //当两者不相等时，判断新改的公告是否与之前数据库其他里有重复的
            canEdit = !noticeDao.isExitInDB(notice.getID());
        }
        if (!canEdit) {
            request.setAttribute("notice", notice);
            request.getRequestDispatcher("notice_list.jsp?info=error").forward(request, response);

        } else {

            noticeDao.editNotice(id, topic, content);
            notice = noticeDao.info(topic);
            request.setAttribute("notice", notice);
            request.getRequestDispatcher("notice_list.jsp?info=success").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = (String) request.getParameter("id");
        String topic = (String) request.getParameter("topic");
        String content = (String) request.getParameter("content");

        NoticeDao noticeDao = new NoticeDao();
        noticeDao.editNotice(id, topic, content);
        request.getRequestDispatcher("librarian.jsp").forward(request, response);
    }
}