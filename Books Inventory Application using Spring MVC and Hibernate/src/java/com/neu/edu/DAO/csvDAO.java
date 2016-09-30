/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.DAO;

import com.neu.edu.pojo.SalesOrder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.relique.jdbc.csv.CsvDriver;

/**
 *
 * @author Jaya
 */
public class csvDAO {
    
    QueryRunner queryRunner = new QueryRunner();

    public ArrayList<SalesOrder> getCsv(String nameCsvFile,int offset,int noOfRecords) {
        ArrayList<SalesOrder> salesOrderList = new ArrayList<SalesOrder>();
        ResultSetHandler<List<SalesOrder>> resultListHandler = new BeanListHandler<SalesOrder>(SalesOrder.class);
        try {
            // Load the driver.
            Class.forName("org.relique.jdbc.csv.CsvDriver");

            // Create a Statement object to execute the query with.
            // A Statement is not thread-safe.
            try ( // Create a connection. The first command line parameter is
            // the directory containing the .csv files.
            // A single connection is thread-safe for use by several threads.
                    Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:\\Users\\Jaya\\Desktop\\NEU\\Web Tools")) {
                // Create a Statement object to execute the query with.
                // A Statement is not thread-safe.
                Statement stmt = conn.createStatement();
                
                // Select the ID and NAME columns from sample.csv
                String query = "select * from "+nameCsvFile+" limit "+ noOfRecords + " offset " + offset;
                ResultSet results = stmt.executeQuery(query);
                //"select * from "+salesorder+" limit "+offset+","+noOfRecords
                //ResultSet results = stmt.executeQuery("SELECT * FROM "+ nameCsvFile);
                ResultSetMetaData metadata = results.getMetaData();
                int numberOfColumns = metadata.getColumnCount();
                while (results.next()) {
                    int i = 1;
                    while (i <= numberOfColumns) {
                        SalesOrder so = new SalesOrder();
                        so.setSalesOrderID(results.getString(i++));
                        so.setRevisionNumber(results.getString(i++));
                        so.setOrderDate(results.getString(i++));
                        so.setDueDate(results.getString(i++));
                        so.setShipDate(results.getString(i++));
                        so.setStatus(results.getString(i++));
                        so.setOnlineOrderFlag(results.getString(i++));
                        so.setSalesOrderNumber(results.getString(i++));
                        so.setPurchaseOrderNumber(results.getString(i++));
                        so.setAccountNumber(results.getString(i++));
                        so.setCustomerID(results.getString(i++));
                        so.setSalesPersonID(results.getString(i++));
                        so.setTerritoryID(results.getString(i++));
                        so.setBillToAddressID(results.getString(i++));
                        so.setShipToAddressID(results.getString(i++));
                        so.setShipMethodID(results.getString(i++));
                        so.setCreditCardID(results.getString(i++));
                        so.setCreditCardApprovalCode(results.getString(i++));
                        so.setCurrencyRateID(results.getString(i++));
                        so.setSubTotal(results.getString(i++));
                        so.setTaxAmt(results.getString(i++));
                        so.setFreight(results.getString(i++));
                        so.setTotalDue(results.getString(i++));
                        so.setComment(results.getString(i++));
                        so.setModifiedDate(results.getString(i++));
                        
                        salesOrderList.add(so);
                    }
                }   conn.close();
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salesOrderList;
    }
    
}
