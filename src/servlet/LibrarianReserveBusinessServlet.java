package servlet;

import dao.BookDetailDao;
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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "LibrarianReserveBusinessServlet")
public class LibrarianReserveBusinessServlet extends HttpServlet {

    private ReaderReserveDao readerReserveDao = new ReaderReserveDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ReaderReserve> readerReserveList = readerReserveDao.getReaderReserveList();
        BookDetailDao bookDetailDao = new BookDetailDao();
        Date nowDate=new Date();
        //检查预约时间是否超期，超期取消预约
        for(int i = 0; i < readerReserveList.size(); i++){
            ReaderReserve readerReserve=readerReserveList.get(i);
            Timestamp reserve_time=readerReserve.getReserve_time();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long nowTime =System.currentTimeMillis();
            long reserveTime = 0;
            try {
                reserveTime=df.parse(df.format(reserve_time)).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long diff=(nowTime-reserveTime)/1000/60;
//            long diff=nowDate.getTime()-reserve_time.getTime();
//            long diffMin=diff%(1000*24*60*60)%(1000 * 60 * 60)/(1000 * 60);
            if(diff>120) {
                //如果预约超过120分钟，删除这条预约
                readerReserveDao.deleteReaderReserve(readerReserve.getUser_account(), readerReserve.getCopy_id());
                bookDetailDao.changeBookStatus(readerReserve.getCopy_id(),2);
                readerReserveList.remove(i);
                i--;
            }
        }
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
