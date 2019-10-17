package servlet;

import dao.BookCategoryDao;
import dao.BookDao;
import dao.BookDetailDao;
import entity.Book;
import entity.BookCategory;
import entity.BookDetail;
import jdk.nashorn.tools.Shell;
import utils.BuiledCopyID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookAddServlet")
public class BookAddServlet extends HttpServlet {
    BookCategoryDao bookCategoryDao = new BookCategoryDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String BookNumber = (String) request.getParameter("BookNumber");
        String Name = (String) request.getParameter("name");
        String Press = (String) request.getParameter("press");
        double Price = Double.parseDouble(request.getParameter("price"));
        String Category = request.getParameter("category");
        //TODO
        String Floor = "test";
        String Shelf = "test";

        String Author = (String) request.getParameter("author");
        String Description = request.getParameter("description");
        //数据类型可能不对
        String AmountString = (String) request.getParameter("amount");
        int Amount = Integer.parseInt(AmountString);

        BookDao bookDao = new BookDao();
        boolean exit = bookDao.isExitInDB(BookNumber);
        if (exit) {
            response.sendRedirect("book_add.jsp?info=error");
        } else {
            //在book中添加
            bookDao.addBook(BookNumber, Name, Press, Price, Author, Category
                    , Amount, Description);
//            ArrayList<String> copyIDs = BuiledCopyID.BuiledCopyID(BookNumber, Amount);
            //test
            ArrayList<String> copyIDs = new ArrayList<String>();
            copyIDs.add("1111");
            copyIDs.add("2222");
            BookDetailDao bookDetailDao = new BookDetailDao();
            //准备条形码页面
            List<BookDetail> bookdetails = new ArrayList<BookDetail>();
            for (int i = 0; i < copyIDs.size(); i++) {
                //在bookdetail中添加
                bookDetailDao.addBookDeatil(BookNumber,copyIDs.get(i));

                //TODO
                String AreaCode = "test";
                BookDetail bookDetail = new BookDetail();
                bookDetail.setCopyID(copyIDs.get(i));
                bookDetail.setShelf(Shelf);
                bookDetail.setAreaCode(AreaCode);
                String path = copyIDs.get(i) + ".png";
                bookDetail.setPath(path);
                bookdetails.add(bookDetail);
            }
            request.setAttribute("bookDetails",bookdetails);
            request.getRequestDispatcher("added_book_detail.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookCategory> bookCategories = bookCategoryDao.getBookCategories();
        request.setAttribute("bookCategories", bookCategories);
        request.getRequestDispatcher("book_add.jsp").forward(request, response);
    }
}
