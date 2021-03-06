package servlet;

import dao.ReaderSearchDao;
import entity.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LibSearchServlet")
public class LibSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String message = (String) request.getParameter("message");
        String signal=(String) request.getParameter("signal");
        ReaderSearchDao ReaderSearchDao = new ReaderSearchDao();
        List<Book> list=ReaderSearchDao.Search(message,signal);
        request.setAttribute("list", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("librarian_book_list.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
