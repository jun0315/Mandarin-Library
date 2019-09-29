package dao;


import entity.ReaderBorrow;
import utils.DBHelper;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author 刘威
 * @version 1.0
 * 访问数据库的reader_borrow表的方法类
 **/

public class ReaderBorrowDao {
    private double getFine(Date pastDate, java.util.Date currentDate) {
        double fine;
        //计算当前时间和借书时间相差的天数
        Calendar calendar = Calendar.getInstance();
        calendar.setTime((java.util.Date)pastDate);
        long temp_pastDate = calendar.getTimeInMillis();
        calendar.setTime(currentDate);
        long temp_currentDate = calendar.getTimeInMillis();
        long between_days = (temp_currentDate - temp_pastDate) / (1000 * 3600 * 24);
        if (between_days > 30) {
            fine = (double) (between_days - 30);
        } else fine = 0.0;
        return fine;
    }


    //查找数据库中某用户的借书情况
    public List<ReaderBorrow> getReaderBorrowList(String user_account) {
        List<ReaderBorrow> readerBorrowList = new ArrayList<>();
        try {
            //查询reader_borrow表
            String sql = "select * from reader_borrow";
            //链接数据库
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String copy_id = resultSet.getString("copy_id");
                String temp_user_account = resultSet.getString("user_account");
                Date borrow_time = resultSet.getDate("borrow_time");
                int isReturned = resultSet.getInt("isReturned");
                double fine = getFine(borrow_time, new java.util.Date());
                if (temp_user_account.equals(user_account)) {
                    ReaderBorrow readerBorrow = new ReaderBorrow(copy_id, temp_user_account, borrow_time, isReturned, fine);
                    readerBorrowList.add(readerBorrow);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readerBorrowList;
    }
}
