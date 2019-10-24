package servlet;

import dao.LibrarianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LibrarianAddServlet")
public class LibrarianAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String account = (String) request.getParameter("account");
        String password = (String) request.getParameter("password");
        String name = (String) request.getParameter("name");
        String phone = (String) request.getParameter("phone");
        LibrarianDao librarianDao = new LibrarianDao();
        boolean exit = librarianDao.isExitInDB(account);
        if (exit) {
            response.sendRedirect("librarian_add.jsp?info=error");
        } else {
            librarianDao.addLibrarian(name, account, password, phone);
            response.sendRedirect("librarian_add.jsp?info=success");
        }
    }

    //this is git test
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("librarian_add.jsp?info=success");
    }
}
