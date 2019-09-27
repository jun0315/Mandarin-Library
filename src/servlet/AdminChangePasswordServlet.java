package servlet;

import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminChangePasswordServlet")
public class AdminChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession httpSession = request.getSession(true);
        String account = (String) httpSession.getAttribute("name");
        String oldPassword = (String) request.getParameter("oldPassword");
        String newPassword = (String) request.getParameter("newPassword");
        String confirmedNewPassword = (String) request.getParameter("confirmedNewPassword");

        AdminDao adminDao = new AdminDao();

        if (!newPassword.equals(confirmedNewPassword)) {
            response.sendRedirect("admin_change_password.jsp?exec_msg=newPasswordDiff");
        } else {
            String passwordInDB = adminDao.getPassword(account);
            if (!passwordInDB.equals(oldPassword)) {
                response.sendRedirect("admin_change_password.jsp?exec_msg=oldPasswordWrong");
            } else {
                if (adminDao.changePassword(account, confirmedNewPassword)) {
                    response.sendRedirect("admin_change_password.jsp?exec_msg=success");
                } else {
                    response.sendRedirect("admin_change_password.jsp?exec_msg=dbProcessFailed");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

