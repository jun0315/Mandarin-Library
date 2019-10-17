package dao;

import entity.Librarian;
import sun.text.resources.no.CollationData_no;
import utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDao {
    public List<Librarian> getLibrarians() {
        List<Librarian> librarians = new ArrayList<Librarian>();
        String sql = "select * from staff where staff.user_type ='librarian'";
        try {
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Librarian librarian = new Librarian();
                String account = resultSet.getString("staff_account");
                String name = resultSet.getString("staff_name");
                String phone = resultSet.getString("staff_phone");
                String password = resultSet.getString("staff_password");

                librarian.setName(name);
                librarian.setPhone(phone);
                librarian.setAccount(account);
                librarian.setPassword(password);

                librarians.add(librarian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return librarians;
    }

    //通过account返回librarian实体
    public Librarian info(String account) {
        Librarian librarian = new Librarian();
        try {
            String sql = "select * from staff where staff_account = \'" + account + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String passwordInDB = resultSet.getString("staff_password");
                String nameInDB = resultSet.getString("staff_name");
                String phoneInDB = resultSet.getString("staff_phone");
                librarian.setName(nameInDB);
                librarian.setPhone(phoneInDB);
                librarian.setAccount(account);
                librarian.setPassword(passwordInDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return librarian;
    }

    public boolean isExitInDB(String account) {
        boolean Exit = false;
        try {
            String sql = "select * from staff where user_type = 'librarian'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String accountInDB = resultSet.getString("staff_account");
                if (accountInDB.equals(account)) {
                    Exit = true;
                    break;
                }
            }
            DBHelper.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Exit;
    }

    public void addLibrarian(String name, String account, String password, String phone) {
        try {
            String sql = "insert into staff values(?,'librarian',?,?,?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, account);
            ps.setString(3, password);
            ps.setString(4, phone);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editLibrarian(String name, String account, String preAccount, String password, String phone) {
        try {
            String sql = "update staff set staff_name=?,staff_account=?,staff_password=?,staff_phone=? where staff_account=? ";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, account);
            ps.setString(3, password);
            ps.setString(4, phone);
            ps.setString(5, preAccount);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLibrarian(String account) {

        String sql = "delete from staff where staff_account = \'" + account + "\'";
        try {
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
}
