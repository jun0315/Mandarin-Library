package dao;

import entity.Book;
import entity.Librarian;
import sun.text.resources.no.CollationData_no;
import utils.DBHelper;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReaderSearchDao {
    public ReaderSearchDao() {

    }

    public List<Book> Search(String message) {
        try {
            String ma = "%" + message + "%";
            String sql = "select * from book where book_name like \'" + ma + "\'";

            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            //Book book=new Book();
            List<Book> list = new ArrayList<>();
            //int total =resultSet.getRow();
            //String[] a1 = new String[10];
            //String[] a2 = new String[10];
            //String[] a3 = new String[10];
            // String[] a4 = new String[10];
            // String[] a5 = new String[10];
            //String[] a6 = new String[10];
            // int i=0;


            while (resultSet.next()) {
                //a1[i]=resultSet.getString(1);
                // a2[i]=resultSet.getString(2);
                //a3[i]=resultSet.getString(3);
                //a4[i]=resultSet.getString(4);
                // a5[i]=resultSet.getString(5);
                //a6[i]=resultSet.getString(6);
                // i++;
                Book book = new Book();
                book.setBookNumber(resultSet.getString(1));
                book.setName(resultSet.getString(2));
                book.setPress(resultSet.getString(3));
                book.setPrice(resultSet.getDouble(4));
                book.setAuthor(resultSet.getString(5));
                book.setCategory(resultSet.getString(6));
                book.setAmount(resultSet.getInt(7));
                book.setDescription(resultSet.getString(11));
                list.add(book);
            }

            //List<Book> list = new ArrayList<Book>();
            //list.add(a1);
            //list.add(a2);
            //list.add(a3);
            //list.add(a4);
            //list.add(a5);
            // list.add(a6);
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}


