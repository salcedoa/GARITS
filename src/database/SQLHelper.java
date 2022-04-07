package database;

import businesslogic.CustomerAccount;

import java.sql.*;

public class SQLHelper {
    // usually 82.0.184.217:3306
    private String dbAddress = "localhost:3306";
    private String dbPassword = "Lancaster6";
    private String dbURL = "jdbc:mysql://"+dbAddress+"/GARITS_DB?allowPublicKeyRetrieval=true&useSSL=false";

    private ResultSet resultSet;

    public SQLHelper() {

    }

    // Insert a customer account into the database
    public void insertCustomer(CustomerAccount customerAccount) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);

            // the query is created
            String sql = "INSERT INTO customerRecords " +
                    "(CustomerName,AddressLine1,AddressLine2,AddressLine3," +
                    "Postcode,Contact,ContactTitle,Telephone,Mobile,PayLate,isBusiness) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

            // creating mySQL query - should return ResultSet object
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setNString(1,customerAccount.getCustomerName());
            statement.setNString(2,customerAccount.getAddressLine1());
            statement.setNString(3,customerAccount.getAddressLine2());
            statement.setNString(4,customerAccount.getAddressLine3());
            statement.setNString(5, customerAccount.getPostCode());
            statement.setNString(6, customerAccount.getContact());
            statement.setNString(7, customerAccount.getContactTitle());
            statement.setNString(8, customerAccount.getTelephone());
            statement.setNString(9, customerAccount.getMobile());
            statement.setBoolean(10, customerAccount.getPayLate());
            statement.setBoolean(11,customerAccount.getBusiness());
            statement.executeUpdate();

            // close connection
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Insert vehicle record into the database

    // Insert Job into database

    // Retrieve a customer account from the database (for changes)

    // Retrieve vehicle record from database

    // Retrieve a Job from database
}
