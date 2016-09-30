/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.CustomTags;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import org.relique.jdbc.csv.CsvDriver;

/**
 *
 * @author Jaya
 */
public class HelloTag extends SimpleTagSupport{
    
    
    private String csvFileName;

    public void setCsvFileName(String csvFileName) {
        this.csvFileName = csvFileName;
    }
    
    StringWriter sw=new StringWriter();
    
    public void doTag() throws JspException, IOException {
        Connection conn;  
        ResultSet results=null ;
        ResultSetMetaData metaData;
        int numberOfColumns;
        try{
        Class.forName("org.relique.jdbc.csv.CsvDriver");
                      
            conn = DriverManager.getConnection("jdbc:relique:csv:C:\\Users\\Jaya\\Desktop\\NEU\\Web Tools");            
            Statement stmt = conn.createStatement();
            String selectQuery="SELECT * FROM "+ csvFileName;
            results= stmt.executeQuery(selectQuery);
            metaData = results.getMetaData();
            numberOfColumns = metaData.getColumnCount();
            
            JspWriter out = getJspContext().getOut();
            out.println("Hello Custom Tag!");
            out.println("File Name "+ csvFileName);
            out.println("<h1>SalesOrder</h1>"+
                "<form action='csv.htm' method='post'>"+
                "<table border='1'>"+
                "<tr>"+
                "<th>SalesOrderID</th>"+
                "<th>RevisionNumber</th>"+
                "<th>OrderDate</th>"+
                "<th>DueDate</th>"+
                "<th>ShipDate</th>"+
                "<th>Status</th>"+
                "<th>OnlineOrderFlag</th>"+
                "<th>SalesOrderNumber</th>"+
                "<th>PurchaseOrderNumber</th>"+
                "<th>AccountNumber</th>"+
                "<th>CustomerID</th>"+
                "<th>SalesPersonID</th>"+
                "<th>TerritoryID</th>"+
                "<th>BillToAddressID</th>"+
                "<th>ShipToAddressID</th>"+
                "<th>ShipMethodID</th>"+
                "<th>CreditCardID</th>"+
                "<th>CreditCardApprovalCode</th>"+
                "<th>CurrencyRateID</th>"+
                "<th>SubTotal</th>"+
                "<th>TaxAmt</th>"+
                "<th>Freight</th>"+
                "<th>TotalDue</th>"+
                "<th>Comment</th>"+
                "<th>ModifiedDate</th>"+
                "</tr>");
            
           
            while(results.next()){
                out.println("<tr>");
                int i = 1;
                while (i <= 25) {
                out.println("<td><input type='text' name='value' value="+results.getString(i++)+"></td>");
                
                }
                out.println("</tr>");
            }
            out.println("<table><br/><br/>"+
                    "<input type='Submit' value='Inert into DB'/>" +
                    "<input type='hidden' name='action' value='insert'/>"+
                    "</form>");
             } catch (ClassNotFoundException ex) {
            Logger.getLogger(HelloTag.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HelloTag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
    
    
    
}
