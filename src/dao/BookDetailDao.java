package dao;

import utils.DBHelper;

import java.sql.*;

public class BookDetailDao {
    //添加书籍到数据库中
    public void addBookDeatil(String bookNumber, String copy_id, String areacode) {
        try {
            String sql = "insert into book_detail values(?,?,2,?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, bookNumber);
            ps.setString(2, copy_id);
            ps.setString(3, areacode);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改book_detail状态
    public void changeBookStatus(String copy_id, int status) {
        try {
            String sql = "update book_detail set status=? where copy_id=?";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setString(2, copy_id);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据copy_id查book_number
    public String getBookNumberByCopyID(String copy_id) {
        String book_number = "";
        try {
            String sql = "select book_number from book_detail where copy_id=\'" + copy_id + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
                book_number = resultSet.getString("book_number");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book_number;
    }
}
