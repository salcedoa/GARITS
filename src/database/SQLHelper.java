package database;

import admin.UserAccount;
import businesslogic.*;

import java.sql.*;
import java.util.ArrayList;

public class SQLHelper {
    // usually 82.0.184.217:3306
    private final String dbAddress = "localhost:3306";
    private final String dbPassword = "Lancaster6";
    private final String dbURL = "jdbc:mysql://"+dbAddress+"/GARITS_DB?allowPublicKeyRetrieval=true&useSSL=false";

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
    public boolean insertJob(Job job) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, "root", dbPassword);

            // the query is created
            String sql = "INSERT INTO jobs " +
                    "(CustomerName, NumberPlate, Make," +
                    "Model,CustomerTelephone,DescriptionRequiredWork) " +
                    "VALUES (?, ?, ?, ?, ?, ?) ";

            PreparedStatement statement = conn.prepareStatement(sql);
            String[] jobFieldList = {job.getCustomerName(), job.getNumberPlate(), job.getMake(),
                                        job.getModel(), job.getTelephone(),job.getNotes()};

            for (int i = 0; i != jobFieldList.length; i++) {
                if (jobFieldList[i].equals("")) {
                    // i begins from 0 but the parameter indices in the prepared statement begin from 1
                    statement.setNString(i+1,null);
                    System.out.println("detected null value: "+jobFieldList[i]);
                } else {
                    statement.setNString(i+1,jobFieldList[i]);
                    System.out.println("detected value: "+jobFieldList[i]);
                }
            }

            try {
                statement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e){
                return false;
            }

            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Insert User into database
    public Boolean insertUser(UserAccount user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);

            // the query is created
            String sql = "INSERT INTO users " +
                    "(AccountHolder,AccountType,Username,Password,HourlyRate) " +
                    "VALUES (?, ?, ?, ?, ?)";

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

            // ensures that empty float is set to null instead of 0.00
            if (user.getHourlyRate() == 0.00) {
                statement.setNull(5, Types.FLOAT);
            } else {
                statement.setFloat(5, user.getHourlyRate());
            }

            try {
                statement.executeUpdate();
            } catch (SQLException e){
                return false;
            }

            // get the user ID
            Statement statement2 = conn.createStatement();
            // chooses last record
            sql = "SELECT * FROM users ORDER BY AccountID DESC LIMIT 1;";
            ResultSet rs = statement2.executeQuery(sql);
            user.setAccountID(rs.getInt("CustomerID"));

            // close connection
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve a customer accounts from the database (for display)
    public ArrayList<CustomerAccount> retrieveCustomerAccounts() {
        ArrayList<CustomerAccount> accountsList = new ArrayList<CustomerAccount>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM customerAccounts";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                CustomerAccount account = new CustomerAccount();
                account.setCustomerID(resultSet.getInt("CustomerID"));
                account.setCustomerName(resultSet.getNString("CustomerName"));
                account.setAddressLine1(resultSet.getNString("AddressLine1"));
                account.setAddressLine2(resultSet.getNString("AddressLine2"));
                account.setAddressLine3(resultSet.getNString("AddressLine3"));
                account.setPostCode(resultSet.getNString("Postcode"));
                account.setContact(resultSet.getNString("Contact"));
                account.setContactTitle(resultSet.getNString("ContactTitle"));
                account.setTelephone(resultSet.getNString("Telephone"));
                account.setContact(resultSet.getNString("Mobile"));
                account.setPayLate(resultSet.getBoolean("PayLate"));
                account.setBusiness(resultSet.getBoolean("isBusiness"));
                accountsList.add(account);
            }

            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return accountsList;
    };

    // Retrieve vehicle record from database

    // Retrieve a Job from database

    // Back up database data to a directory
    public Boolean backUpDB(String path) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);
            Statement statement = conn.createStatement();
            String sql = "BACKUP DATABASE 'GARITS_DB' TO DISK = '"+ path +"'";
            statement.executeQuery(sql);
            conn.close();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Restore database from .bak file
    public Boolean restoreDB(String filePath) {
        return false;
    }

}

/*    public boolean backUpDB(String directory) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);


            conn.close();
            return true
        } catch(Exception e) {
            e.printStackTrace();
            return false
        }
    }*/
