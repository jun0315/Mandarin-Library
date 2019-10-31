package dao;

import entity.AdminSettings;
import utils.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminSettingsDao {

    public AdminSettings getSystemAdminSettings() {

        AdminSettings adminSettings = new AdminSettings();

        try {

            String sql = "select * from admin_setting";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                String bookFineValueInDB = resultSet.getString("book_fine_value");
                String bookReturnPeriodInDB = resultSet.getString("book_return_period");
                String readerSecurityDepositInDB = resultSet.getString("reader_security_deposit");

                adminSettings.setBookFineValue(bookFineValueInDB);
                adminSettings.setBookReturnPeriod(bookReturnPeriodInDB);
                adminSettings.setReaderSecurityDeposit(readerSecurityDepositInDB);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adminSettings;
    }

    public boolean changeSystemAdminSettings(String newBookFineValue, String newBookReturnPeriod, String newreaderSecurityDeposit) {

        try {

            String sql = "update admin_setting set book_fine_value = \'" + newBookFineValue +
                    "\', book_return_period = \'" + newBookReturnPeriod +
                    "\', reader_security_deposit = \'" + newreaderSecurityDeposit + "\'";

            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            System.out.println(sql);
            statement.executeUpdate(sql);

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }

}
