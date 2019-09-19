package dao;

import utils.DBHelper;
import utils.UserType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
    //通过账号密码获取账户类型
    //TODO 读者查询 分开到reader表中查找
    public UserType login(String account, String password) {
        UserType userType = UserType.None;
        String sqlFromStaff = "select * from staff";
        String sqlFromReader = "select * from reader";
        boolean canfind = false;
        try {
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlFromStaff);
            while (resultSet.next()) {
                String accountInDB = resultSet.getString("staff_account");
                String passwordInDB = resultSet.getString("staff_password");
                if (accountInDB.equals(account) && passwordInDB.equals(password)) {
                    userType = UserType.ToUserType(resultSet.getString("user_type"));
                    System.out.println(resultSet.getString("user_type"));
                    break;
                }
            }
            //在staff里没找到，再去reader表中寻找
            if (!canfind) {
                resultSet = statement.executeQuery(sqlFromReader);
                while (resultSet.next()) {
                    String accountInDB = resultSet.getString("user_account");
                    String passwordInDB = resultSet.getString("user_password");
                    if (accountInDB.equals(account) && passwordInDB.equals(password)) {
                        userType = UserType.Reader;
                        System.out.println(resultSet.getString("user_type"));
                        break;
                    }
                }
            }
            DBHelper.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userType;
    }
}
