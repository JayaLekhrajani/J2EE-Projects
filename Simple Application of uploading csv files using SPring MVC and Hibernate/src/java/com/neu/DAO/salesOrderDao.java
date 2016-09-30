/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.DAO;

import com.neu.pojo.SalesOrder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaya
 */
public class salesOrderDao {
    
    private String driver;
    private String dburl;
    private String dbuser;
    private String dbpassword;  
    

    public salesOrderDao() {
        driver = "com.mysql.jdbc.Driver";
        dburl = "jdbc:mysql://localhost:3306/salesdb";
        dbuser = "root";
        dbpassword = "root";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(salesOrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insert(ArrayList<SalesOrder> salesOrderList) throws SQLException {
        Connection conn = getConnection();
        String query = "insert into salesOrder values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pStatement = conn.prepareStatement(query);
        int batchSize = 100;

        for (SalesOrder so : salesOrderList) {
            pStatement.setString(1, so.getSalesOrderID());
            pStatement.setString(2, so.getRevisionNumber());
            pStatement.setString(3, so.getOrderDate());
            pStatement.setString(4, so.getDueDate());
            pStatement.setString(5, so.getShipDate());
            pStatement.setString(6, so.getStatus());
            pStatement.setString(7, so.getOnlineOrderFlag());
            pStatement.setString(8, so.getSalesOrderNumber());
            pStatement.setString(9, so.getPurchaseOrderNumber());
            pStatement.setString(10, so.getAccountNumber());
            pStatement.setString(11, so.getCustomerID());
            pStatement.setString(12, so.getSalesPersonID());
            pStatement.setString(13, so.getTerritoryID());
            pStatement.setString(14, so.getBillToAddressID());
            pStatement.setString(15, so.getShipToAddressID());
            pStatement.setString(16, so.getShipMethodID());
            pStatement.setString(17, so.getCreditCardID());
            pStatement.setString(18, so.getCreditCardApprovalCode());
            pStatement.setString(19, so.getCurrencyRateID());
            pStatement.setString(20, so.getSubTotal());
            pStatement.setString(21, so.getTaxAmt());
            pStatement.setString(22, so.getFreight());
            pStatement.setString(23, so.getTotalDue());
            pStatement.setString(24, so.getComment());
            pStatement.setString(25, so.getModifiedDate());

            pStatement.addBatch();
        }

        pStatement.executeBatch(); //for remaining batch queries if total record is odd no.

        // conn.commit();
        pStatement.close();

    }

    public Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
        } catch (SQLException ex) {
            Logger.getLogger(salesOrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;

    }

    public void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(salesOrderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(salesOrderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(salesOrderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
