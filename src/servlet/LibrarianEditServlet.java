package servlet;

import dao.LibrarianDao;
import entity.Librarian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LibrarianEditServlet")
public class LibrarianEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String preAccount = (String) request.getParameter("preAccount");
        String account = (String) request.getParameter("account");
        String password = (String) request.getParameter("password");
        String name = (String) request.getParameter("name");
        String phone = (String) request.getParameter("phone");
        LibrarianDao librarianDao = new LibrarianDao();
        Librarian librarian = new Librarian(name, password, phone, account);
        boolean canEdit = true;
        if (!account.equals(preAccount)) {
            //当两者不相等时，判断新改的账号是否与之前数据库其他里有重复的
            canEdit = !librarianDao.isExitInDB(account);
        }
        if (!canEdit) {
            request.setAttribute("librarian", librarian);
            request.getRequestDispatcher("librarian_edit.jsp?info=error").forward(request, response);

        } else {
            librarianDao.editLibrarian(name, account, preAccount, password, phone);
            librarian = librarianDao.info(account);
            request.setAttribute("librarian", librarian);
            request.getRequestDispatcher("librarian_edit.jsp?info=success").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String account = (String) request.getParameter("account");
        LibrarianDao librarianDao = new LibrarianDao();
        Librarian librarian = librarianDao.info(account);
        request.setAttribute("librarian", librarian);
        request.getRequestDispatcher("librarian_edit.jsp").forward(request, response);
    }
}
