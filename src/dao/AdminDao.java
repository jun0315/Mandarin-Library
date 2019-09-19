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
                String passwordInDB = resultSet.getString("staff_password");
                String nameInDB = resultSet.getString("staff_name");
                String phoneInDB = resultSet.getString("staff_phone");
                admin.setName(nameInDB);
                admin.setPhone(phoneInDB);
                admin.setAccount(account);
                admin.setAccount(passwordInDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
