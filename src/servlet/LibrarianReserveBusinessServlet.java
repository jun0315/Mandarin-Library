package servlet;

import dao.ReaderReserveDao;
import entity.ReaderReserve;
import utils.BarCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LibrarianReserveBusinessServlet")
public class LibrarianReserveBusinessServlet extends HttpServlet {

    private ReaderReserveDao readerReserveDao = new ReaderReserveDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ReaderReserve> readerReserveList = readerReserveDao.getReaderReserveList();
        for (int i = 0; i < readerReserveList.size(); i++)
        {
            String copyid_path = readerReserveList.get(i).getCopy_id() + ".png";
            readerReserveList.get(i).setCopy_barpath(copyid_path);
            BarCodeUtil.GenerateBarCode(readerReserveList.get(i).getCopy_id(),copyid_path,request);
            String account_path = readerReserveList.get(i).getUser_account() + ".png";
            readerReserveList.get(i).setAccount_barpath(account_path);
            BarCodeUtil.GenerateBarCode(readerReserveList.get(i).getUser_account(),account_path,request);
        }
        session.setAttribute("readerReserveList", readerReserveList);
        request.getRequestDispatcher("librarian_reserve_business.jsp").forward(request, response);
    }
}
