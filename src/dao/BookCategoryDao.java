package dao;

import entity.BookCategory;
import utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookCategoryDao {

    public static BookCategoryDao getInstance(){
        return new BookCategoryDao();
    }

    public List<BookCategory> getBookCategories() {
        List<BookCategory> bookCategories = new ArrayList<BookCategory>();
        String sql = "select * from book_category";
        try {
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                BookCategory bookCategory = new BookCategory();
                String category = resultSet.getString("category");
                int floor = resultSet.getInt("floor");
                String shelf = resultSet.getString("shelf");
                bookCategory.setCategory(category);
                bookCategory.setFloor(floor);
                bookCategory.setShelf(shelf);
                bookCategories.add(bookCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookCategories;
    }
    public String getAreaCode(String Category){
        String sql = "Select * from book,book_detail where book.book_number=book_detail.book_number " +
                "and book.book_category= \'" + Category + "\'";
        double Amount=0;
        ArrayList<Integer> AllAreaCode=null;
        try{
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                AllAreaCode.add(Integer.parseInt(resultSet.getString("areacode")));
                Amount++;
            }
            Collections.sort(AllAreaCode);
            if(Amount==AllAreaCode.size()){
                return String.valueOf(Amount);
            }else{
                for(int i=0;i<AllAreaCode.size();i++){
                    if(AllAreaCode.get(i)!=i){
                        return String.valueOf(i);
                    }
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return String.valueOf(Integer.valueOf(new Double(Amount).intValue()));
    }
    public int getFloor(String Category){
        String sql = "Select * from book_category where category= \'" + Category + "\'";
        int floor = 0;
        try{
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            floor = resultSet.getInt("floor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return floor;
    }
    public String getShelf(String Category){
        String sql = "Select * from book_category where category= \'" + Category + "\'";
        String Shelf=null;
        try{
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Shelf  = resultSet.getString("shelf");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Shelf;
    }
    public boolean isExistInDB(String category){
        boolean exist = false;
        try {
            String sql = "select * from book_category where category = \'" + category +"\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String accountInDB = resultSet.getString("category");
                if(accountInDB.equals(category)){
                    exist = true;
                    break;
                }
            }
            DBHelper.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    //通过category返回bookCategory实体
    public BookCategory info(String category) {
        BookCategory bookCategory = new BookCategory();
        try {
            String sql = "select * from book_category where category = \'" + category + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String categoryInDB = resultSet.getString("category");
                int floorInDB = resultSet.getInt("floor");
                String shelfInDB = resultSet.getString("shelf");
                bookCategory.setCategory(categoryInDB);
                bookCategory.setFloor(floorInDB);
                bookCategory.setShelf(shelfInDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookCategory;
    }

    public void addBookCategory(String category, int floor, String shelf){
        try {
            String sql = "insert into book_category values(?,?,?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category);
            ps.setInt(2, floor);
            ps.setString(3, shelf);
            ps.executeUpdate();
            DBHelper.closeConnection(connection,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editBookCategory(String category, int floor, String shelf, String preCategory){
        try {
            String sql = "update book_category set category=?, floor=?, shelf=? where category=? ";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category);
            ps.setInt(2, floor);
            ps.setString(3, shelf);
            ps.setString(4, preCategory);
            ps.executeUpdate();
            DBHelper.closeConnection(connection,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBookCategory(String category){
        try {
            String sql = "delete from book_category where category=?";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category);
            ps.executeUpdate();
            DBHelper.closeConnection(connection,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
