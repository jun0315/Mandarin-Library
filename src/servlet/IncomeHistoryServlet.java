package servlet;

import dao.ReaderBorrowDao;
import dao.ReaderDao;
import entity.Reader;
import entity.ReaderBorrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet(name = "IncomeHistoryServlet")
public class IncomeHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReaderBorrowDao readerBorrowDao = new ReaderBorrowDao();
        ReaderDao readerDao = ReaderDao.getInstance();
        List<ReaderBorrow> readerBorrowList = readerBorrowDao.getReaderBorrowList();
        List<Reader> readerList = readerDao.getReaders();
        double todayFine = 0.0;
        double weekFine = 0.0;
        double monthFine = 0.0;
        double totalFine = 0.0;
        int todayDeposit = 0;
        int weekDeposit = 0;
        int monthDeposit = 0;
        int totalDeposit = 0;
        //计算今日、本周、本月和总共的罚金收入
        for (ReaderBorrow readerBorrow : readerBorrowList) {
            long time = readerBorrow.getBorrow_time().getTime();
            double fine = readerBorrow.getFine();
            if (isToday(time)) todayFine += fine;
            if (isThisWeek(time)) weekFine += fine;
            if (isThisWeek(time)) monthFine += fine;
            totalFine += fine;
        }
        //计算今日、本周、本月和总共的保证金收入
        for(Reader reader:readerList){
            long time = reader.getRegister_time().getTime();
            double deposit = reader.getDeposit();
            if(isToday(time)) todayDeposit+=deposit;
            if(isThisWeek(time)) weekDeposit+=deposit;
            if(isThisMonth(time)) monthDeposit+=deposit;
            totalDeposit+=deposit;
        }
        //设置请求属性
        request.setAttribute("todayFine", todayFine);
        request.setAttribute("weekFine", weekFine);
        request.setAttribute("monthFine", monthFine);
        request.setAttribute("totalFine", totalFine);
        request.setAttribute("todayDeposit",todayDeposit);
        request.setAttribute("weekDeposit",weekDeposit);
        request.setAttribute("monthDeposit",monthDeposit);
        request.setAttribute("totalDeposit",totalDeposit);
        //分配请求到librarian_income_history_business.jsp
        request.getRequestDispatcher("librarian_income_history_business.jsp").forward(request, response);
    }

    //判断选择的日期是否是本周
    public static boolean isThisWeek(long time) {
        Calendar calendar = Calendar.getInstance();
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(new Date(time));
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        if (paramWeek == currentWeek)
            return true;
        return false;
    }

    //判断选择的日期是否是今天
    public static boolean isToday(long time) {
        return isThisTime(time, "yyyy-MM-dd");
    }

    //判断选择的日期是否是本月
    public static boolean isThisMonth(long time) {
        return isThisTime(time, "yyyy-MM");
    }

    private static boolean isThisTime(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String param = sdf.format(date);
        //参数时间
        String now = sdf.format(new Date());
        //当前时间
        if (param.equals(now))
            return true;
        return false;
    }
}