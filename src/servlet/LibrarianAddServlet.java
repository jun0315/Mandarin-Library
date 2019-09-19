package servlet;

import dao.AddLibrarianDao;

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
        AddLibrarianDao addLibrarianDao = new AddLibrarianDao();
        boolean canAdd = addLibrarianDao.canAdd(account);
        if (!canAdd) {
            response.sendRedirect("add_librarian.jsp?info=error");
        } else {
            addLibrarianDao.addLibrarian(name,account,password,phone);
            response.sendRedirect("add_librarian.jsp?info=success");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("add_librarian.jsp?info=success");
    }
}
