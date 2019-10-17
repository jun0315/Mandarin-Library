package dao;

import utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDetailDao {
    //添加书籍到数据库中
    public void addBookDeatil(String bookNumber, String copy_id) {
        try {
            String sql = "insert into book_detail values(?,?,0);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, bookNumber);
            ps.setString(2, copy_id);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
