package servlet;

import dao.LibrarianDao;
import dao.ReaderSearchDao;
import entity.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.List;


@WebServlet(name = "ReaderSearchServlet")
public class ReaderSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String message = (String) request.getParameter("message");
       ReaderSearchDao ReaderSearchDao = new ReaderSearchDao();
        List<Book> list=ReaderSearchDao.Search(message);
        request.setAttribute("list", list);

        //String[] b0 = list.get(0);
       // String[] b1 = list.get(1);
        //String[] b2 = list.get(2);
        //String[] b3 = list.get(3);
        //String[] b4 = list.get(4);
        //String[] b5 = list.get(5);
      //for (int i = 0; i < list.size(); i++) {

         //out.println(list.get(i).getBookNumber());//+list.get(i).getBook_name()+list.get(i).getBook_press());
        // out.println(list.get(i).getBook_price()+list.get(i).getBook_author()+list.get(i).getBook_category());
    // }


      RequestDispatcher dispatcher=request.getRequestDispatcher("reader_search.jsp");
   dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
