package servlet;

import dao.ReaderReserveDao;
import entity.ReaderReserve;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrdertoServlet")
public class OrdertoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String number = (String) request.getParameter("number");
        String id = (String) request.getParameter("id");
        if(number.equals("0")||number.equals("1")){
            RequestDispatcher dispatcher=request.getRequestDispatcher("failed.jsp");
            dispatcher.forward(request, response);
        }
        else{
            HttpSession session = request.getSession();
            String m=(String) session.getAttribute("account");
            ReaderReserveDao a=new ReaderReserveDao();
            a.addReaderReserve(m, id);
            RequestDispatcher dispatcher=request.getRequestDispatcher("successed.jsp");
            dispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
