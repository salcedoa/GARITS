package GUI;

import businesslogic.CustomerAccount;
import database.SQLHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CustomerAccountsTable extends JTable {
    private SQLHelper sqlHelper = new SQLHelper();
    private ArrayList<CustomerAccount> customerList;
    private String columnNames[] = {"ID","Name","Contact","Contact Title", "Business"};
    private DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);

    CustomerAccountsTable() {
        setModel(tableModel);
        customerList = sqlHelper.retrieveCustomerAccounts();
        for (CustomerAccount i : customerList) {
            Object[] row = {i.getCustomerID(),i.getCustomerName(),i.getContact(),i.getContactTitle(),i.getBusiness()};
            tableModel.addRow(row);
        }

        // disabling the ability to select multiple tables
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // setting the colour of the headers to black
        getTableHeader().setOpaque(false);
        getTableHeader().setBackground(Color.BLACK);
        getTableHeader().setForeground(Color.WHITE);

        // setting the column widths
        getColumn("ID").setPreferredWidth(50);
        getColumn("Name").setPreferredWidth(200);
        getColumn("Contact").setPreferredWidth(140);
        getColumn("Contact Title").setPreferredWidth(140);
        getColumn("Business").setPreferredWidth(80);
    };

    public void updateTable() {
        // clears whole table and reinserts everything
        tableModel.setRowCount(0);
        customerList = sqlHelper.retrieveCustomerAccounts();
        for (CustomerAccount i : customerList) {
            Object[] row = {i.getCustomerID(),i.getCustomerName(),i.getContact(),i.getContactTitle(),i.getBusiness()};
            tableModel.addRow(row);
        }
    }

    // disables cell editing
    public boolean editCellAt(int row, int column, java.util.EventObject e) {
        return false;
    }

}
