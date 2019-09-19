package dao;

import entity.Librarian;
import utils.DBHelper;

import java.sql.*;

public class AddLibrarianDao {
    public boolean canAdd(String account){
        boolean can = true;
        try {
            String sql = "select * from staff where user_type = 'librarian'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String accountInDB = resultSet.getString("staff_account");
                if(accountInDB.equals(account)){
                    can = false;
                    break;
                }
            }
            DBHelper.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return can;
    }

    public void addLibrarian(String name,String account,String password,String phone){
        try {
            String sql = "insert into staff values(?,'librarian',?,?,?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, account);
            ps.setString(3, password);
            ps.setString(4, phone);
            ps.executeUpdate();
            DBHelper.closeConnection(connection,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
