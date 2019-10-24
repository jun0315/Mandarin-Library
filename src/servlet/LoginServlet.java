package servlet;

import dao.*;
import entity.Admin;
import entity.AdminSettings;
import entity.Librarian;
import entity.Reader;
import utils.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用于保存会话
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        dealAccount(request, response, account, password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        String password = (String) session.getAttribute("password");
        dealAccount(request, response, account, password);
    }

    private void dealAccount(HttpServletRequest request, HttpServletResponse response,
                             String account, String password) throws IOException {
        HttpSession session = request.getSession();
        LoginDao loginDao = new LoginDao();
        UserType userType = loginDao.login(account, password);
        //设置session相关信息
        if (userType == UserType.Admin) {

            AdminDao adminDao = new AdminDao();
            Admin admin = adminDao.info(account);
            session.setAttribute("name", admin.getName());
            session.setAttribute("type", admin.getType());
            session.setAttribute("account", admin.getAccount());
            session.setAttribute("phone", admin.getPhone());

        } else if (userType == UserType.Librarian) {

            LibrarianDao librarianDao = new LibrarianDao();
            Librarian librarian = librarianDao.info(account);
            session.setAttribute("name", librarian.getName());
            session.setAttribute("type", librarian.getType());

        } else if (userType == UserType.Reader) {
            ReaderDao readerDao = ReaderDao.getInstance();
            Reader reader = readerDao.info(account);
            session.setAttribute("name", reader.getName());
            session.setAttribute("email", reader.getEmail());
            session.setAttribute("securityDeposit", reader.getDeposit());
            session.setAttribute("type", reader.getType());
            session.setAttribute("registerTime",reader.getRegister_time());
        }
        if (userType != UserType.None) {

            session.setAttribute("account", account);
            session.setAttribute("password", password);

        }

        switch (userType) {
            case Admin:
                response.sendRedirect("admin.jsp");
                break;
            case Librarian:
                response.sendRedirect("librarian.jsp");
                break;
            case Reader:
                response.sendRedirect("reader.jsp");
                break;
            case None:
                response.sendRedirect("index.jsp?error=yes");
                break;
        }
    }
}
