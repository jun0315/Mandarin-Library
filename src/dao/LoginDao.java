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
        String sql = "select * from staff";
        try {
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String userNameInDB = resultSet.getString("staff_name");
                String passwordInDB = resultSet.getString("staff_password");
                if (userNameInDB.equals(account)&& passwordInDB.equals(password)) {
                    userType = UserType.ToUserType(resultSet.getString("staff_type"));
                    System.out.println(resultSet.getString("staff_type"));
                    resultSet.close();
                    break;
                }
            }
            DBHelper.closeConnection(connection,statement,resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userType;
    }
}
