/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.DAO;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jaya_L
 */
public class DAO {
    
    private String driver;
    private String dburl;
    private String dbuser;
    private String dbpassword;
    
    
    public DAO()
    {
    
        driver="com.mysql.jdbc.Driver";
        dburl="jdbc:mysql://localhost:3306/booksdb";
        dbuser="root";
        dbpassword="jaya";
        
        
    
    try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
    public Connection getConnection()
    {
    
    Connection connection=null;
    try {
            connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    
    
    
    }
    
    public void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void close(ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
    
    
}
