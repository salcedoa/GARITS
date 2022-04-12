package GUI;

import businesslogic.Job;
import database.SQLHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class JobsTable extends JTable {
    private SQLHelper sqlHelper = new SQLHelper();
    private ArrayList<Job> jobsList;
    private String columnNames[] = {"ID","Name", "Description","Status"};
    private DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);

    public JobsTable() {
        setModel(tableModel);
        jobsList = sqlHelper.retrieveJobs();
        for (Job i : jobsList) {
            Object[] row = {i.getJobID(),i.getCustomerName(),i.getNotes(),i.getStatus()};
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
        getColumn("Description").setPreferredWidth(300);
        getColumn("Status").setPreferredWidth(120);
    }

    public void updateTable() {
        // clears whole table and reinserts everything
        tableModel.setRowCount(0);
        jobsList = sqlHelper.retrieveJobs();
        for (Job i : jobsList) {
            Object[] row = {i.getJobID(),i.getCustomerName(),i.getNotes(),i.getStatus()};
            tableModel.addRow(row);
        }
    }

    // disables cell editing
    public boolean editCellAt(int row, int column, java.util.EventObject e) {
        return false;
    }

}
