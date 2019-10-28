package servlet;
import dao.DetailDao;
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

@WebServlet(name = "DetailSearchServlet")
public class DetailSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String number = (String) request.getParameter("number");
        DetailDao detailDao = new DetailDao();
        Book book=detailDao.Search(number);
        request.setAttribute("book", book);
        /*out.println(book.getBookNumber());*/



        RequestDispatcher dispatcher=request.getRequestDispatcher("book_detail.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
