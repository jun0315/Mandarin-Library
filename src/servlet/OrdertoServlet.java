package servlet;

import dao.ChangeDao;
import dao.OrderDao;
import dao.ReaderReserveDao;
import entity.Detail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "OrdertoServlet")
public class OrdertoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String number =(String)request.getParameter("number");
        String id = (String) request.getParameter("id");
        String sa=(String)request.getParameter("sa");
        OrderDao OrderDao = new OrderDao();

        /*    out.print(id);*/
        if(number.equals("0")||number.equals("1")){
            request.setAttribute("loginError", "your order is failed because the book has been borrowed or ordered");
            List<Detail> list=OrderDao.Search(sa);
            request.setAttribute("wa", list);
            RequestDispatcher dispatcher=request.getRequestDispatcher("book_order.jsp");
            dispatcher.forward(request, response);
        }
        else if(number.equals("2")){
            HttpSession session = request.getSession();
            String m=(String) session.getAttribute("account");
            int s=(int) session.getAttribute("borrowing_count");
            ReaderReserveDao a=new ReaderReserveDao();
            ChangeDao b=new ChangeDao();
            if(s<3){
            b.changed(id);
            a.addReaderReserve(m, id);
            request.setAttribute("loginError", "your order is successed");}
            else{ request.setAttribute("loginError", "your order is failed because you have borrowed three books");}
            List<Detail> list=OrderDao.Search(sa);
            request.setAttribute("wa", list);
            RequestDispatcher dispatcher=request.getRequestDispatcher("book_order.jsp");
            dispatcher.forward(request, response);}

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
