package dao;

import entity.Book;
import entity.Librarian;
import sun.text.resources.no.CollationData_no;
import utils.DBHelper;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ReaderSearchDao {
    public ReaderSearchDao() {

    }

    public List<Book> Search(String message, String signal) {
        try {
            String ma = "%" + message + "%";
            String sql = null;
            if (signal.equals("Name")) {
                sql = "select * from book where book_name like \'" + ma + "\'";
            } else if (signal.equals("ID")) {
                sql = "select * from book where book_number like \'" + ma + "\'";
            } else if (signal.equals("Author")){
                sql = "select * from book where book_author like \'" + ma + "\'";
            }

            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            List<Book> list = new ArrayList<>();

            BookCategoryDao bookCategoryDao = new BookCategoryDao();

            while (resultSet.next()) {
                Book book = new Book();
                book.setBookNumber(resultSet.getString(1));
                book.setName(resultSet.getString(2));
                book.setPress(resultSet.getString(3));
                book.setPrice(resultSet.getDouble(4));
                book.setAuthor(resultSet.getString(5));
                String category = resultSet.getString(6);
                book.setCategory(category);
                book.setAmount(resultSet.getInt(7));
                book.setDescription(resultSet.getString(8));
                book.setFloor(bookCategoryDao.getFloor(category));
                book.setShelf(bookCategoryDao.getShelf(category));
                list.add(book);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}


