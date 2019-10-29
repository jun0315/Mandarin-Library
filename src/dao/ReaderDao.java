package dao;

import entity.Reader;
//import sun.text.resources.no.CollationData_no; //没用到
import utils.DBHelper;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReaderDao {
    public static ReaderDao getInstance() {
        return new ReaderDao();
    }

    public int getTotal() {
        int total = 0;
        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            String sql = "select count(*) from reader";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                total = rs.getInt(1);
            }
            DBHelper.closeConnection(c, s, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public List<Reader> getReaders() {
        List<Reader> readers = new ArrayList<Reader>();
        String sql = "select * from reader";
        try {
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Reader reader = new Reader();
                String account = resultSet.getString("user_account");
                String password = resultSet.getString("user_password");
                String name = resultSet.getString("user_name");
                String email = resultSet.getString("user_email");
                int deposit = resultSet.getInt("security_deposit");
                Date register_time = resultSet.getDate("register_time");
                reader.setAccount(account);
                reader.setPassword(password);
                reader.setName(name);
                reader.setEmail(email);
                reader.setDeposit(deposit);
                reader.setRegister_time(register_time);
                readers.add(reader);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readers;
    }

    //通过user_account返回reader实体
    public Reader info(String account) {
        Reader reader = new Reader();
        try {
            String sql = "select * from reader where user_account = \'" + account + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String passwordInDB = resultSet.getString("user_password");
                String nameInDB = resultSet.getString("user_name");
                String emailInDB = resultSet.getString("user_email");
                int depositInDB = resultSet.getInt("security_deposit");
                Date register_time = resultSet.getDate("register_time");
                int borrowing_count = resultSet.getInt("borrowing_count");
                reader.setAccount(account);
                reader.setPassword(passwordInDB);
                reader.setName(nameInDB);
                reader.setEmail(emailInDB);
                reader.setDeposit(depositInDB);
                reader.setRegister_time(register_time);
                reader.setBorrowing_count(borrowing_count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reader;
    }

    public boolean isExistInDB(String account) {
        boolean Exist = false;
        try {
            String sql = "select * from reader where user_account = \'" + account + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String accountInDB = resultSet.getString("user_account");
                if (accountInDB.equals(account)) {
                    Exist = true;
                    break;
                }
            }
            DBHelper.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Exist;
    }

    public void addReader(String account, String password, String name, String email, int deposit) {
        try {
            String sql = "insert into reader values(?,?,?,?,?,?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, email);
            ps.setInt(5, deposit);
            //预约时间设置为系统当前时间
            java.util.Date date = new java.util.Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String register_time = simpleDateFormat.format(date);
            ps.setString(6, register_time);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editReader(String account, String password, String name, String email, int deposit, String preAccount) {
        try {
            //TODO BUG 修改reader后 再reader-borrow中当作外键 没办法修改
            String sql = "update reader set user_account=?,user_password=?,user_name=?,user_email=?,security_deposit=? where user_account=? ";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, email);
            ps.setInt(5, deposit);
            ps.setString(6, preAccount);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReader(String account) {
        try {
            String sql = "delete from reader where user_account=?";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getEmailByAccount(String account) {
        String user_email = "";
        try {
            String sql = "select * from reader where user_account = \'" + account + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user_email = resultSet.getString("user_email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user_email;
    }

    public void editPasswordByEmail(String account, String password) {
        try {
            //TODO BUG 修改reader后 再reader-borrow中当作外键 没办法修改
            String sql = "update reader set user_password=? where user_account=? ";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, account);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}