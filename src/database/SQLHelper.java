package database;

import admin.UserAccount;
import businesslogic.*;

import java.sql.*;
import java.util.ArrayList;

public class SQLHelper {
    // usually localhost:3306
    private final String dbAddress = "82.0.184.217:3306 ";
    private final String dbPassword = "Lancaster6";
    private final String dbURL = "jdbc:mysql://"+dbAddress+"/GARITS_DB?allowPublicKeyRetrieval=true&useSSL=false";

    public SQLHelper() {

    }

    /** INSERTION STATEMENTS **/

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

            // get customer ID
            Statement statement2 = conn.createStatement();
            // chooses last record
            sql = "SELECT * FROM customerRecords ORDER BY CustomerID DESC LIMIT 1;";
            ResultSet rs = statement2.executeQuery(sql);
            rs.next();
            customerAccount.setCustomerID(rs.getInt("CustomerID"));

            // close connection
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Insert vehicle record into the database
    public boolean insertVehicle(Vehicle vehicle) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);
            String sql = "INSERT INTO vehicles" +
                    "(PlateNumber, Colour,LastMoT, Make, Model, CustomerID) " +
                    "VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            String [] vehicleFieldList = {vehicle.getNumberPlate(), vehicle.getColour(), vehicle.getLastMoT(), vehicle.getMake(),
                                            vehicle.getModel()};

            for (int i = 0; i != vehicleFieldList.length; i++) {
                if (vehicleFieldList[i].equals("")) {
                    // i begins from 0 but the parameter indices in the prepared statement begin from 1
                    statement.setNString(i+1,null);
                } else {
                    statement.setNString(i+1,vehicleFieldList[i]);
                }
            }
            statement.setInt(6,vehicle.getCustomerID());

            try {
                statement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e){
                return false;
            }

            conn.close();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Insert Job into database
    public boolean insertJob(Job job) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, "root", dbPassword);

            // the query is created
            String sql = "INSERT INTO jobs " +
                    "(CustomerName, NumberPlate, Make," +
                    "Model,CustomerTelephone,DescriptionRequiredWork,Status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?) ";

            PreparedStatement statement = conn.prepareStatement(sql);
            String[] jobFieldList = {job.getCustomerName(), job.getNumberPlate(), job.getMake(),
                                        job.getModel(), job.getTelephone(),job.getNotes(),job.getStatus()};

            for (int i = 0; i != jobFieldList.length; i++) {
                if (jobFieldList[i].equals("")) {
                    // i begins from 0 but the parameter indices in the prepared statement begin from 1
                    statement.setNString(i+1,null);
                } else {
                    statement.setNString(i+1,jobFieldList[i]);
                }
            }

            try {
                statement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e){
                return false;
            }

            // get the user ID
            Statement statement2 = conn.createStatement();
            // chooses last record
            sql = "SELECT * FROM jobs ORDER BY JobID DESC LIMIT 1;";
            ResultSet rs = statement2.executeQuery(sql);
            rs.next();
            job.setJobID(rs.getInt("JobID"));

            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Insert Part into database
    public Boolean insertPart(Stock part) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);
            String sql = "INSERT INTO stock " +
                    "(PartName,PartType,Vehicle,SoldIn,Manufacturer,ManufacturerPrice,StockLevel,LowLevelThreshold,CustomerCost,Ordered)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            String[] partsFields = {part.getPartName(),part.getPartType(), part.getVehicle(),part.getSoldIn(), part.getManufacturer()};

            // insert the values of part object into the prepared statement
            for (int i = 0; i != partsFields.length; i++) {
                if (partsFields[i].equals("")) {
                    // i begins from 0 but the parameter indices in the prepared statement begin from 1
                    statement.setNString(i+1,null);
                    System.out.println("detected null value: "+partsFields[i]);
                } else {
                    statement.setNString(i+1,partsFields[i]);
                    System.out.println("detected value: "+partsFields[i]);
                }
            }
            statement.setFloat(6,part.getManufacturerPrice());
            statement.setInt(7, part.getStockLevel());
            statement.setInt(8,part.getLowLevelThreshold());
            statement.setFloat(9,part.getCustomerCost());
            statement.setInt(10,part.getOrdered());

            // execute the statement
            try {
                statement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e){
                return false;
            }

            // get the user ID
            Statement statement2 = conn.createStatement();
            // chooses last record
            sql = "SELECT * FROM stock ORDER BY PartID DESC LIMIT 1;";
            ResultSet rs = statement2.executeQuery(sql);
            rs.next();
            part.setPartID(rs.getInt("PartID"));

            conn.close();
            return true;
        } catch(Exception e) {
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
            rs.next();
            user.setAccountID(rs.getInt("AccountID"));

            // close connection
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Insert discount
    public Boolean insertDiscount(Discounts discount) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);

            // the query is created
            String sql = "INSERT INTO discounts " +
                    "(discountType,discountPercentage,flexibleLowRange," +
                    "flexibleHighRange,variableBusinessType,CustomerID) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            // creating mySQL query - should return ResultSet object
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setNString(1,discount.getDiscountType());
            statement.setInt(2,discount.getDiscountPercentage());
            statement.setInt(3,discount.getFlexibleLowRange());
            statement.setInt(4,discount.getFlexibleHighRange());
            statement.setNString(5,discount.getVariableBusinessType());
            statement.setInt(6,discount.getCustomerID());

            try {
                statement.executeUpdate();
            } catch (SQLException e){
                return false;
            }

            // get the user ID
            Statement statement2 = conn.createStatement();
            // chooses last record
            sql = "SELECT * FROM discounts ORDER BY discountID DESC LIMIT 1;";
            ResultSet rs = statement2.executeQuery(sql);
            rs.next();
            discount.setDiscountID(rs.getInt("AccountID"));

            // close connection
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /** RETRIEVAL STATEMENTS **/

    // Retrieve a customer accounts from the database (for display)
    public ArrayList<CustomerAccount> retrieveCustomerAccounts() {
        ArrayList<CustomerAccount> accountsList = new ArrayList<CustomerAccount>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM customerRecords";
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
                account.setMobile(resultSet.getNString("Mobile"));
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
    public ArrayList<Job> retrieveJobs() {
        ArrayList<Job> jobsList = new ArrayList<Job>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM jobs";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Job job = new Job();
                job.setJobID(resultSet.getInt("JobID"));
                job.setCustomerName(resultSet.getNString("CustomerName"));
                job.setNumberPlate(resultSet.getNString("NumberPlate"));
                job.setMake(resultSet.getNString("Make"));
                job.setModel(resultSet.getNString("Model"));
                job.setTelephone(resultSet.getNString("CustomerTelephone"));
                job.setNotes(resultSet.getNString("DescriptionRequiredWork"));
                job.setStatus(resultSet.getNString("Status"));
                jobsList.add(job);
            }
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return jobsList;
    };

    /** BACK UP STATEMENT */

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

    /** DELETION STATEMENTS **/

    // delete any item besides vehicles from the database
    public void deleteItem(int id, String table, String columnName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);
            Statement statement = conn.createStatement();
            String sql = "DELETE FROM "+table+" WHERE "+columnName+" = " + String.valueOf(id);
            statement.execute(sql);
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // delete vehicle from the database
    public void deleteVehicle(String numberPlate) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);
            Statement statement = conn.createStatement();
            String sql = "DELETE FROM vehicles WHERE NumberPlate = '"+numberPlate+"'";
            statement.execute(sql);
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}

/*    public boolean backUpDB(String directory) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,"root",dbPassword);


            conn.close();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/
