package servlet;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.BookDao;
import dao.OrderDao;
import entity.Book;
import entity.Detail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BookDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String number = (String) request.getParameter("bookNumber");
        OrderDao orderDao = new OrderDao();
        List<Detail> list=orderDao.Search(number);
        request.setAttribute("wa", list);
        RequestDispatcher dispatcher=request.getRequestDispatcher("book_detail_librarian.jsp");
        dispatcher.forward(request, response);
    }
}
