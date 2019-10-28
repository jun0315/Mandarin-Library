package dao;

import utils.DBHelper;
import entity.ReaderReserve;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReaderReserveDao {

    public List<ReaderReserve> getReaderReserveList() {
        List<ReaderReserve> readerReserveList = new ArrayList<>();
        try {
            //查询数据库reader_reserve
            String sql = "select * from reader_reserve";
            //链接数据库
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //获取表内容
            while (resultSet.next()) {
                String user_account = resultSet.getString("user_account");
                String copy_id = resultSet.getString("copy_id");
                Date reserve_time = resultSet.getDate("reserve_time");
                ReaderReserve readerReserve = new ReaderReserve(user_account, copy_id, reserve_time);
                readerReserveList.add(readerReserve);
            }
            //断开数据库链接
            DBHelper.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readerReserveList;
    }

    public void addReaderReserve(String user_account, String copy_id) {
        try {
            //向reader_reserve表插入数据
            String sql = "insert into reader_reserve values(?,?,?)";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user_account);
            ps.setString(2, copy_id);
            //预约时间设置为系统当前时间
            java.util.Date date = new java.util.Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String datestr = simpleDateFormat.format(date);
            ps.setString(3, datestr);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReaderReserve(String user_account, String copy_id) {
        try {
            String sql = "delete from reader_reserve where user_account=? and copy_id=?";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user_account);
            ps.setString(2, copy_id);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
