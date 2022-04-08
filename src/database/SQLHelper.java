package database;

import admin.UserAccount;
import admin.UserAccount;
import businesslogic.CustomerAccount;

import java.lang.reflect.Type;
import java.sql.*;

public class SQLHelper {
    // usually 82.0.184.217:3306
    private String dbAddress = "localhost:3306";
    private String dbPassword = "Lancaster6";
    private String dbURL = "jdbc:mysql://"+dbAddress+"/GARITS_DB?allowPublicKeyRetrieval=true&useSSL=false";

    private String[] fieldList;

    public SQLHelper() {

    }

    // Insert a customer account into the database
    public Boolean insertCustomer(CustomerAccount customerAccount) {
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

            String[] customerFieldList = {customerAccount.getCustomerName(), customerAccount.getAddressLine1(), customerAccount.getAddressLine2(),
                    customerAccount.getAddressLine3(), customerAccount.getPostCode(), customerAccount.getContact(),
                    customerAccount.getContactTitle(), customerAccount.getTelephone(),customerAccount.getMobile()};

            // loops through all the fields in Job and changed any empty strings to null
            for (int i = 0; i != customerFieldList.length; i++) {
                if (customerFieldList[i].equals("")) {
                    // i begins from 0 but the parameter indices in the prepared statement begin from 1
                    statement.setNString(i+1,null);
                } else {
                    statement.setNString(i+1,customerFieldList[i]);
                }
            }

            statement.setBoolean(10, customerAccount.getPayLate());
            statement.setBoolean(11,customerAccount.getBusiness());

            try {
                statement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e){
                return false;
            }

            // close connection
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Insert vehicle record into the database

    // Insert Job into database

    // Insert User into database
    public Boolean insertUser(UserAccount user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);

            // the query is created
            String sql = "INSERT INTO users " +
                    "(AccountHolder,AccountType,Username,Password,HourlyRate) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            // creating mySQL query - should return ResultSet object
            PreparedStatement statement = conn.prepareStatement(sql);

            String[] userFieldList = {user.getAccountHolder(),user.getAccountType(),user.getUsername(),
                    user.getPassword()};

            // loops through all the fields in Job and changed any empty strings to null
            for (int i = 0; i != userFieldList.length; i++) {
                if (userFieldList[i].equals("")) {
                    statement.setNString(i+1,null);
                } else {
                    statement.setNString(i+1,userFieldList[i]);
                }
            }
            statement.setFloat(6,user.getHourlyRate());

            try {
                statement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e){
                return false;
            }

            // close connection
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve a customer account from the database (for changes)

    // Retrieve vehicle record from database

    // Retrieve a Job from database
}
