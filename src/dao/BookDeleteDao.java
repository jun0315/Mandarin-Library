package dao;

import entity.Book;
import entity.BookDelete;
import utils.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDeleteDao {


    public static List<BookDelete> getBookDeletes() {
        List<BookDelete> BookDeletes = new ArrayList<BookDelete>();
        String sql = "Select * from book_deleted";
        try{
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                BookDelete bookDelete=new BookDelete();
                String copy_id=resultSet.getString("copy_id");
                Date delete_time=resultSet.getDate("delete_time");
                String staff_id=resultSet.getString("staff_id");
                bookDelete.setCopy_id(copy_id);
                bookDelete.setDelete_time(delete_time);
                bookDelete.setStaff_id(staff_id);

                BookDeletes.add(bookDelete);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  BookDeletes;
    }
}
