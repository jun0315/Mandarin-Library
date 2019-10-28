package dao;

import entity.Book;
import utils.DBHelper;

import java.sql.*;

public class DetailDao {
    public DetailDao() {
    }

    public Book Search(String number) {
        try {
            String ma = number;
            String sql = null;

            sql = "select * from book where book_number = \'" + ma + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            BookCategoryDao bookCategoryDao = new BookCategoryDao();

            Book book = new Book();
            while (resultSet.next()) {
                book.setBookNumber(resultSet.getString(1));
                book.setName(resultSet.getString(2));
                book.setPress(resultSet.getString(3));
                book.setPrice(resultSet.getDouble(4));
                book.setAuthor(resultSet.getString(5));
                book.setCategory(resultSet.getString(6));
                book.setFloor(bookCategoryDao.getFloor(resultSet.getString(6)));
                book.setShelf(bookCategoryDao.getShelf(resultSet.getString(6)));
                book.setAmount(resultSet.getInt(7));
                book.setDescription(resultSet.getString(8));
            }

            return book;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}