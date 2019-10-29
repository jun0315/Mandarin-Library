package dao;


import entity.ReaderBorrow;
import utils.DBHelper;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

/**
 * @author 刘威
 * @version 1.0
 * 访问数据库的reader_borrow表的方法类
 **/

public class ReaderBorrowDao {

    private double getFine(Date pastDate, java.util.Date currentDate, int book_return_period, int book_fine_value) {
        double fine;
        //计算当前时间和借书时间相差的天数
        Calendar calendar = Calendar.getInstance();
        calendar.setTime((java.util.Date) pastDate);
        long temp_pastDate = calendar.getTimeInMillis();
        calendar.setTime(currentDate);
        long temp_currentDate = calendar.getTimeInMillis();
        long between_days = (temp_currentDate - temp_pastDate) / (1000 * 3600 * 24);
        if (between_days > book_return_period) {
            fine = (double) (between_days - 30) * book_fine_value;
        } else fine = 0.0;
        return fine;
    }


    //查找数据库中某用户的借书情况
    public List<ReaderBorrow> getReaderBorrowList(String user_account) {
        List<ReaderBorrow> readerBorrowList = new ArrayList<>();
        try {
            //默认借阅时长为30天，罚金为每日1＄
            int book_return_period = 30;
            int book_fine_value = 1;
            //查询reader_borrow表按照时间降序排列
            String sql = "select * from reader_borrow where user_account=\'" + user_account + "\' order by borrow_time DESC";
            //查询admin_setting表
            String sql1 = "select * from admin_setting";
            //链接数据库
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            //获取管理员设置的借阅时间长度和每日罚金
            while (resultSet.next()) {
                book_return_period = resultSet.getInt("book_return_period");
                book_fine_value = resultSet.getInt("book_fine_value");
            }
            //获取借阅信息
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String copy_id = resultSet.getString("copy_id");
                Date borrow_time = resultSet.getDate("borrow_time");
                int isReturned = resultSet.getInt("isReturned");
                double fine = resultSet.getDouble("fine");
                String book_name = resultSet.getString("book_name");
                //如果罚金没有被管理员设置为已交罚金，则计算罚金
                if (fine == 0 && isReturned == 0) {
                    fine = getFine(borrow_time, new java.util.Date(), book_return_period, book_fine_value);
                }
                ReaderBorrow readerBorrow = new ReaderBorrow(copy_id, user_account, borrow_time, isReturned, fine, book_name);
                readerBorrowList.add(readerBorrow);
            }
            DBHelper.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readerBorrowList;
    }

    //增加借阅记录
    public void addReaderBorrow(String user_account, String copy_id, String book_name) {
        try {
            String sql = "insert into reader_borrow values(?,?,?,?,?,?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, copy_id);
            ps.setString(2, user_account);
            //借书时间设置为系统当前时间
            java.util.Date date = new java.util.Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String datestr = simpleDateFormat.format(date);
            ps.setString(3, datestr);
            ps.setInt(4, 0);
            ps.setDouble(5, 0.0);
            ps.setString(6, book_name);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //获取所有的借阅信息
    public List<ReaderBorrow> getReaderBorrowList() {
        List<ReaderBorrow> readerBorrowList = new ArrayList<>();
        try {
            //默认借阅时长为30天，罚金为每日1＄
            int book_return_period = 30;
            int book_fine_value = 1;
            //查询reader_borrow表按照时间降序排列
            String sql = "select * from reader_borrow order by borrow_time DESC";
            //查询admin_setting表
            String sql1 = "select * from admin_setting";
            //链接数据库
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            //获取管理员设置的借阅时间长度和每日罚金
            while (resultSet.next()) {
                book_return_period = resultSet.getInt("book_return_period");
                book_fine_value = resultSet.getInt("book_fine_value");
            }
            //获取借阅信息
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String copy_id = resultSet.getString("copy_id");
                String user_account = resultSet.getString("user_account");
                Date borrow_time = resultSet.getDate("borrow_time");
                int isReturned = resultSet.getInt("isReturned");
                double fine = resultSet.getDouble("fine");
                String book_name = resultSet.getString("book_name");
                //如果罚金没有被管理员设置为已交罚金，则计算罚金;否则设置罚金为0
                if (fine == 0 && isReturned == 0) {
                    fine = getFine(borrow_time, new java.util.Date(), book_return_period, book_fine_value);
                }
                ReaderBorrow readerBorrow = new ReaderBorrow(copy_id, user_account, borrow_time, isReturned, fine, book_name);
                readerBorrowList.add(readerBorrow);
            }
            DBHelper.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readerBorrowList;
    }

    public void ReturnBook(String copy_id, String user_account) {
        try {
            int book_return_period = 30;
            int book_fine_value = 1;
            Date pastDate = null;
            int isReturned = 0;
            //查询admin_setting表
            String sql1 = "select * from admin_setting";
            //链接数据库
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            //获取管理员设置的借阅时间长度和每日罚金
            while (resultSet.next()) {
                book_return_period = resultSet.getInt("book_return_period");
                book_fine_value = resultSet.getInt("book_fine_value");
            }
            //获取当前书籍借阅时间
            String sql2 = "select * from reader_borrow where copy_id=\'" + copy_id + "\' and user_account=\'" + user_account + "\'";
            resultSet = statement.executeQuery(sql2);
            while (resultSet.next()) {
                pastDate = resultSet.getDate("borrow_time");
                isReturned = resultSet.getInt("isReturned");
            }
            //计算当前罚金
            double fine = getFine(pastDate, new java.util.Date(), book_return_period, book_fine_value);
            //修改reader_borrow数据库,设置借阅记录为已归还，并记录罚金
            String sql3 = "update reader_borrow set isReturned=1,fine=? where copy_id=? and user_account=?";
            PreparedStatement ps = connection.prepareStatement(sql3);
            ps.setDouble(1, fine);
            ps.setString(2, copy_id);
            ps.setString(3, user_account);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
