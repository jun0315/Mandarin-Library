package dao;

import entity.Book;
import utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    //返回一个书本的列表，包含所有书籍的信息
    public List<Book> getBooks(){
    List<Book> books=new ArrayList<Book>();
    String sql="Select * from book";
    try{
        Connection connection = DBHelper.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Book book=new Book();
            int BookNumber=resultSet.getInt("BookNumber");
            String Name=resultSet.getString("Name");
            String Press=resultSet.getString("Press");
            String Price=resultSet.getString("Price");
            String Author=resultSet.getString("Author");
            String Category=resultSet.getString("Category");
            int Amount=resultSet.getInt("Amount");
            String Floor=resultSet.getString("Floor");
            String Shelf=resultSet.getString("Shelf");
            String AreaCode=resultSet.getString("AreaCode");
            String Description=resultSet.getString("Description");

           // book.setBookNumber(BookNumber);
            //book.setName(Name);
           // book.setPress(Press);
           // book.setPrice(Price);
            //book.setAuthor(Author);
            //book.setCategory(Category);
            //book.setAmount(Amount);
            //book.setFloor(Floor);
            //book.setShelf(Shelf);
            //book.setAreaCode(AreaCode);
            //book.setDescription(Description);
            //books.add(book);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return  books;
    }
//    //通过BookID返回Book实体
//    public Book info(String BookID){
//        Book book=new Book();
//             try{
//            String sql="Select * from book where BookID= \'" + BookID + "\'";
//            Connection connection = DBHelper.getInstance().getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            while(resultSet.next()){
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
    //数据库中是否存在这本书
    public boolean isExitInDB(int BookNumber){
        boolean Exit=false;
        try{
            String sql = "select * from book ";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String BookNumberINDB=resultSet.getString("book_number");
                if(BookNumberINDB.equals(BookNumber)){
                    Exit=true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Exit;
    }

//添加书籍到数据库中
//Connection connection = DBHelper.getInstance().getConnection();有点问题
public void addBook(int bookNumber, String name, String press,
                    String price, String author, String category,
                    int amount, String floor, String shelf,
                    String areaCode, String description) {
        try{
            String sql="insert into book values(?,?,?,?,?,?,?,?,?,?,?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,bookNumber);
            ps.setString(2,name);
            ps.setString(3,press);
            ps.setString(4,price);
            ps.setString(5,author);
            ps.setString(6,category);
            ps.setInt(7,amount);
            ps.setString(8,floor);
            ps.setString(9,shelf);
            ps.setString(10,areaCode);
            ps.setString(11,description);
            ps.executeUpdate();
            DBHelper.closeConnection(connection,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//    BookNumber = bookNumber;
//    Name = name;
//    Press = press;
//    Price = price;
//    Author = author;
//    Category = category;
//    Amount = amount;
//    Floor = floor;
//    Shelf = shelf;
//    AreaCode = areaCode;
//    Description = description;
    }


}
