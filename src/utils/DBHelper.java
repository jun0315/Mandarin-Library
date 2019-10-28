package utils;

import java.sql.*;

//
public class DBHelper {
    public String url = "jdbc:mysql://localhost:3306/lib_system?useUnicode=true&characterEncoding=UTF-8";
    private String username = "root";
    public String password = "12345";
    private static DBHelper dbHelperInstance = null;

    //将MySQL驱动注册到DriverManager中去
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DBHelper getInstance() {
        //给类加锁，避免多线程问题

        if (dbHelperInstance == null) {
            synchronized (DBHelper.class) {
                if (dbHelperInstance == null) {
                    dbHelperInstance = new DBHelper();
                }
            }
        }

        return dbHelperInstance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void closeConnection(Connection connection, Statement statement,
                                       ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static ResultSet executeQuery(String sql){
//        try {
//            Connection connection = DBHelper.getInstance().getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            return  resultSet;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
