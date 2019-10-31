package servlet;

import dao.AdminSettingsDao;
import dao.ReaderBorrowDao;
import dao.ReaderDao;
import entity.ReaderBorrow;
import utils.FindReaderPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AlertToEmailServlet")
public class AlertToEmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calendar calendar = Calendar.getInstance();
        ReaderDao readerDao = new ReaderDao();
        AdminSettingsDao adminSettingsDao = new AdminSettingsDao();
        //获取借阅时长
        int book_return_period = Integer.valueOf(adminSettingsDao.getSystemAdminSettings().getBookReturnPeriod());
        //获取ReaderBorrow表数据
        ReaderBorrowDao readerBorrowDao = new ReaderBorrowDao();
        List<ReaderBorrow> readerBorrowList = readerBorrowDao.getReaderBorrowList();
        for (ReaderBorrow readerBorrow : readerBorrowList) {
            //计算到期时间
            calendar.setTime(readerBorrow.getBorrow_time());
            long time1 = calendar.getTimeInMillis();
            calendar.setTime(new Date());
            long time2 = calendar.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);

            if (readerBorrow.getIsReturned() == 0 && (book_return_period - between_days) <= 3) {
                //获取读者Email
                String email = readerDao.getEmailByAccount(readerBorrow.getUser_account());
//                String email = "1072505283@qq.com";
                FindReaderPassword.AlertReturnBook(email,request);
            }
        }
        request.getRequestDispatcher("librarian_return_business.jsp?info=alert_success").forward(request, response);
    }
}
