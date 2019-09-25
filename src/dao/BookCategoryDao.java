package dao;

import entity.BookCategory;
import entity.Librarian;
import utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookCategoryDao {

    public List<BookCategory> getCategories() {
        List<BookCategory> bookCategories = new ArrayList<BookCategory>();
        String sql = "select * from book_category_location";
        try {
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                BookCategory bookCategory = new BookCategory();
                String category = resultSet.getString("category");
                String location = resultSet.getString("location");
                bookCategory.setCategory(category);
                bookCategory.setLocation(location);
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
            String sql = "select * from book_category_location where category = \'" + category +"\'";
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
            String sql = "select * from book_category_location where category = \'" + category + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String categoryInDB = resultSet.getString("category");
                String locationInDB = resultSet.getString("location");
                bookCategory.setCategory(categoryInDB);
                bookCategory.setLocation(locationInDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookCategory;
    }

    public void addCategory(String category, String location){
        try {
            String sql = "insert into book_category_location values(?,?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category);
            ps.setString(2, location);
            ps.executeUpdate();
            DBHelper.closeConnection(connection,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editLibrarian(String category,String preCategory, String location){
        try {
            String sql = "update book_category_location set category=?,location=? where category=? ";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category);
            ps.setString(2, location);
            ps.setString(3,preCategory);
            ps.executeUpdate();
            DBHelper.closeConnection(connection,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
