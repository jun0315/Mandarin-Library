package servlet;

import dao.LoginDao;
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
        String account = request.getParameter("username");
        String password = request.getParameter("password");
        dealAccount(request,response,account,password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        dealAccount(request,response,account,password);
    }

    private void dealAccount(HttpServletRequest request, HttpServletResponse response,
                             String account,String password) throws IOException {
        HttpSession session = request.getSession();
        LoginDao loginDao = new LoginDao();
        UserType userType = loginDao.login(account, password);
        System.out.println("");
        if (userType != UserType.None) {
            session.setAttribute("username", account);
            session.setAttribute("password", password);
        }
        switch (userType) {
            case Admin:
                response.sendRedirect("Admin.jsp");
                break;
            case Librarian:
                response.sendRedirect("Librarian.jsp");
                break;
            case Reader:
                response.sendRedirect("Reader.jsp");
                break;
            case None:
                response.sendRedirect("index.jsp?error=yes");
                break;
        }
    }
}
