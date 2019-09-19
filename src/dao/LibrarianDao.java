package dao;

import entity.Librarian;
import sun.text.resources.no.CollationData_no;
import utils.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDao {
    public List<Librarian> getLibrarians() {
        List<Librarian> librarians = new ArrayList<Librarian>();
        String sql = "select * from staff where user_type ='librarian'";
        try {
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Librarian librarian = new Librarian();
                String account = resultSet.getString("staff_account");
                String name = resultSet.getString("staff_name");
                String phone = resultSet.getString("staff_phone");
                librarian.setName(name);
                librarian.setPhone(phone);
                librarian.setAccount(account);
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
            String sql = "select * from staff where staff_account = " + account;
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
                librarian.setAccount(passwordInDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return librarian;
    }
}
