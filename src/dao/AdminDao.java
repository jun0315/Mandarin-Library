package dao;

import entity.Admin;
import entity.Librarian;
import utils.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {
    //通过account返回admin实体

    public Admin info(String account) {

        Admin admin = new Admin();
        try {
            String sql = "select * from staff where staff_account = \'" + account + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                String nameInDB = resultSet.getString("staff_name");
                String passwordInDB = resultSet.getString("staff_password");
                String phoneInDB = resultSet.getString("staff_phone");


                admin.setName(nameInDB);
                admin.setAccount(account);
                admin.setPassword(passwordInDB);
                admin.setPhone(phoneInDB);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public boolean changePassword(String account, String newPassword) {

        try {

            String sql = "update staff set staff_password = \'" + newPassword + "\' where staff_account = \'" + account + "\'";

            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            System.out.println(sql);
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public String getPassword(String account) {

        String targetPassword = new String("null");
        try {

            String sql = "select staff_password from staff where staff_account = \'" + account + "\';";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            targetPassword = resultSet.getString("staff_password");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return targetPassword;
    }
}
