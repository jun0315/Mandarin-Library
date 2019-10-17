package servlet;

import dao.LibrarianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LibrarianDeleteServlet")
public class LibrarianDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String account = (String) request.getParameter("account");
        LibrarianDao librarianDao = new LibrarianDao();
        librarianDao.deleteLibrarian(account);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}
