package dao;

import entity.Book;
import entity.BookCategory;
import utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    //返回一个书本的列表，包含所有书籍的信息
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>();
        String sql = "Select * from book";
        try {
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                String BookNumber = resultSet.getString("book_number");
                String Name = resultSet.getString("book_name");
                String Press = resultSet.getString("book_press");
                double Price = resultSet.getDouble("book_price");
                String Author = resultSet.getString("book_author");
                String Category = resultSet.getString("book_category");
                int Amount = resultSet.getInt("book_amount");
                String Description = resultSet.getString("book_description");
                book.setBookNumber(BookNumber);
                book.setName(Name);
                book.setPress(Press);
                book.setPrice(Price);
                book.setAuthor(Author);
                book.setCategory(Category);
                book.setAmount(Amount);

                book.setDescription(Description);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    //通过Book-number返回Book实体
    public Book info(String BookNumber) {
        Book book = new Book();
        try {
            String sql = "Select * from book where book_number= \'" + BookNumber + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            BookCategoryDao bookCategoryDao = new BookCategoryDao();
            while (resultSet.next()) {
                String Name = resultSet.getString("book_name");
                String Press = resultSet.getString("book_press");
                double Price = resultSet.getDouble("book_price");
                String Author = resultSet.getString("book_author");
                String Category = resultSet.getString("book_category");
                int Amount = resultSet.getInt("book_amount");
                String Description = resultSet.getString("book_description");
                book.setBookNumber(BookNumber);
                book.setName(Name);
                book.setPress(Press);
                book.setPrice(Price);
                book.setAuthor(Author);
                book.setCategory(Category);
                book.setFloor(bookCategoryDao.getFloor(Category));
                book.setShelf(bookCategoryDao.getShelf(Category));
                book.setAmount(Amount);
                book.setDescription(Description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    //数据库中是否存在这本书
    public boolean isExitInDB(String BookNumber) {
        boolean Exit = false;
        try {
            String sql = "select * from book ";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String BookNumberINDB = resultSet.getString("book_number");
                if (BookNumberINDB.equals(BookNumber)) {
                    Exit = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Exit;
    }

    //添加书籍到数据库中
    public void addBook(String bookNumber, String name, String press,
                        double price, String author, String category,
                        int amount, String description) {
        try {
            String sql = "insert into book values(?,?,?,?,?,?,?,?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, bookNumber);
            ps.setString(2, name);
            ps.setString(3, press);
            ps.setDouble(4, price);
            ps.setString(5, author);
            ps.setString(6, category);
            ps.setInt(7, amount);
            ps.setString(8, description);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editBook(String bookNumber, String name, String press, String price, String author, String category, String amount, String description) {
        try {
            String sql = "update book set book_name=?,book_press=?,book_price=?,book_author=?,book_category=?,book_amount=?,book_description=? where book_number=? ";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, press);
            ps.setString(3, price);
            ps.setString(4, author);
            ps.setString(5, category);
            ps.setString(6, amount);
            ps.setString(7, description);
            ps.setString(8, bookNumber);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除具体的副本
    public void deleteBook(String copy_id) {
        try {
            //获取number
            String book_number = "";
            String sql = "Select * from book_detail where copy_id= \'" + copy_id + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                book_number = resultSet.getString("book_number");
                break;
            }

            sql = "delete from book_detail where copy_id =?";
            connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, copy_id);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);

            //获取数量
            String amount;
            int amount_int = 0;
            sql = "Select * from book where book_number= \'" + book_number + "\'";
            connection = DBHelper.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                amount = resultSet.getString("book_amount");
                amount_int = Integer.parseInt(amount) - 1;
                break;
            }

            //在book表中数量减一
            sql = "update book set book_amount=? where book_number=\'" + book_number + "\'";
            connection = DBHelper.getInstance().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, String.valueOf(amount_int));
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);

            //在删书表中加入数据


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据book_number查询book_name
    public String getBookNameByBookNumber(String book_number) {
        String book_name = "";
        try {
            String sql = "select book_name from book where book_number=\'" + book_number + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
                book_name = resultSet.getString("book_name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book_name;
    }
}
