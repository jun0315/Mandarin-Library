package servlet;

import dao.AdminDao;
import dao.AdminSettingsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "AdminChangeSettingsServlet")
public class AdminChangeSettingsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String bookFineValue = (String) request.getParameter("bookFineValue");
        String bookReturnPeriod = (String) request.getParameter("bookReturnPeriod");
        String readerSecurityDeposit = (String) request.getParameter("readerSecurityDeposit");

        AdminSettingsDao adminSettingsDao = new AdminSettingsDao();

        if (adminSettingsDao.changeSystemAdminSettings(bookFineValue, bookReturnPeriod, readerSecurityDeposit)) {
            response.sendRedirect("SystemSettingsServlet?exec_msg=success");
        } else {
            response.sendRedirect("SystemSettingsServlet?exec_msg=failed");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
