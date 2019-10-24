package servlet;

import dao.LibrarianDao;
import entity.Librarian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LibrarianListServlet")
public class LibrarianListServlet extends HttpServlet {
    private LibrarianDao librarianDao = new LibrarianDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Librarian> librarians = librarianDao.getLibrarians();
        request.setAttribute("librarians", librarians);
        request.getRequestDispatcher("librarian_list.jsp").forward(request, response);
    }
}
