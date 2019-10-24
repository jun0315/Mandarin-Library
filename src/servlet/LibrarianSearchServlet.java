package servlet;

import dao.LibrarianDao;
import entity.Librarian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LibrarianSearchServlet")
public class LibrarianSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String account = (String) request.getParameter("searchAccount");
        LibrarianDao librarianDao = new LibrarianDao();
        Librarian librarian = librarianDao.info(account);
        if (librarian != null) {
            //为了和list页面统一，放入列表中
            List<Librarian> librarians = new ArrayList<Librarian>();
            librarians.add(librarian);
            request.setAttribute("librarians", librarians);
            request.getRequestDispatcher("librarian_list.jsp?info=found").forward(request, response);
        } else {
            response.sendRedirect("librarian_list.jsp?info=notFound");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
