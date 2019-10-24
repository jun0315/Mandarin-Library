package dao;

import entity.Reader;
//import sun.text.resources.no.CollationData_no; //没用到
import utils.DBHelper;

import java.sql.*;
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
                reader.setAccount(account);
                reader.setPassword(password);
                reader.setName(name);
                reader.setEmail(email);
                reader.setDeposit(deposit);
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
                reader.setAccount(account);
                reader.setPassword(passwordInDB);
                reader.setName(nameInDB);
                reader.setEmail(emailInDB);
                reader.setDeposit(depositInDB);
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
            String sql = "insert into reader values(?,?,?,?,?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, email);
            ps.setInt(5, deposit);
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
}