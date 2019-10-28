package dao;

import utils.DBHelper;

import java.sql.*;

public class ChangeDao {

    public void changed(String a) {
        try {
           /* String ma="%"+message+"%";*/
            String sql ="UPDATE book_detail SET status=1 WHERE copy_id=?";


            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,a);
            statement.executeUpdate();
/*
            ResultSet resultSet = statement.executeQuery(sql);

            ResultSetMetaData rsmd = resultSet.getMetaData();
*/


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
