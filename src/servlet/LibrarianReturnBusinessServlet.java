package servlet;

import dao.ReaderBorrowDao;
import entity.ReaderBorrow;
import utils.BarCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LibrarianReturnBusinessServlet")
public class LibrarianReturnBusinessServlet extends HttpServlet {

    private ReaderBorrowDao readerBorrowDao = new ReaderBorrowDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ReaderBorrow> readerBorrowList = readerBorrowDao.getReaderBorrowList();
        for (int i = 0; i < readerBorrowList.size(); i++) {
            String copyid_path = readerBorrowList.get(i).getCopy_id() + ".png";
            readerBorrowList.get(i).setCopy_barpath(copyid_path);
            BarCodeUtil.GenerateBarCode(readerBorrowList.get(i).getCopy_id(), copyid_path, request);
            String account_path = readerBorrowList.get(i).getUser_account() + ".png";
            readerBorrowList.get(i).setAccount_barpath(account_path);
            BarCodeUtil.GenerateBarCode(readerBorrowList.get(i).getUser_account(), account_path, request);
        }
        request.setAttribute("readerBorrowList", readerBorrowList);
        request.getRequestDispatcher("librarian_return_business.jsp").forward(request, response);
    }
}
