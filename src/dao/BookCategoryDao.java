package dao;

import entity.BookCategory;
import utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookCategoryDao {

    public List<BookCategory> getCategories() {
        List<BookCategory> bookCategories = new ArrayList<BookCategory>();
        String sql = "select * from book_category";
        try {
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                BookCategory bookCategory = new BookCategory();
                String category = resultSet.getString("category");
                bookCategory.setCategory(category);
                bookCategories.add(bookCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookCategories;
    }

    public boolean isExitInDB(String category){
        boolean Exit = false;
        try {
            String sql = "select * from book_category where category = \'" + category +"\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String accountInDB = resultSet.getString("category");
                if(accountInDB.equals(category)){
                    Exit = true;
                    break;
                }
            }
            DBHelper.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Exit;
    }

    //通过account返回librarian实体
    public BookCategory info(String category) {
        BookCategory bookCategory = new BookCategory();
        try {
            String sql = "select * from book_category where category = \'" + category + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String categoryInDB = resultSet.getString("category");
                bookCategory.setCategory(categoryInDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookCategory;
    }

    public void addCategory(String category){
        try {
            String sql = "insert into book_category values(?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category);
            ps.executeUpdate();
            DBHelper.closeConnection(connection,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editLibrarian(String category,String preCategory){
        try {
            String sql = "update book_category set category=? where category=? ";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category);
            ps.setString(2,preCategory);
            ps.executeUpdate();
            DBHelper.closeConnection(connection,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
