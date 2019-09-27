package servlet;

import dao.AdminSettingsDao;
import dao.LibrarianDao;
import entity.AdminSettings;
import entity.Librarian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "SystemSettingsServlet")
public class SystemSettingsServlet extends HttpServlet {

    private AdminSettingsDao adminSettingsDao = new AdminSettingsDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AdminSettings adminSettings = adminSettingsDao.getSystemAdminSettings();
        request.setAttribute("admin_settings", adminSettings);

        if (request.getParameter("exec_msg") == null) {
            request.getRequestDispatcher("admin_system_settings.jsp").forward(request, response);
        } else {

            if (request.getParameter("exec_msg").equals("success")) {
                request.getRequestDispatcher("admin_system_settings.jsp?exec_msg=success").forward(request, response);
            } else if (request.getParameter("exec_msg").equals("failed")) {
                request.getRequestDispatcher("admin_system_settings.jsp?exec_msg=failed").forward(request, response);
            }
        }

    }
}