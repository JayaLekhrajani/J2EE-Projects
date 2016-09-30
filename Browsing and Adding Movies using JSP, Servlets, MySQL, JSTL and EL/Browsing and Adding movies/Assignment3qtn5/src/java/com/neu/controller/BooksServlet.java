/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jaya_L
 */
@WebServlet(name = "BooksServlet", urlPatterns = {"/BooksServlet"})
public class BooksServlet extends HttpServlet {

    
    
    DAO dao;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        //PrintWriter out=response.getWriter();
     DAO dao;
     Connection conn;
     PreparedStatement insertStatement;
     ResultSet resultSet;
     String value1=null;
     String value2=null;
     String value3=null;
     String value4=null;
        
        
        
        
        try (PrintWriter out=response.getWriter())
        {
            
            HttpSession session=request.getSession();
            dao=new DAO();
            if(session.getAttribute("count")==null)
            {
            int noOfBooks=Integer.parseInt(request.getParameter("noOfBooks"));
            session.setAttribute("count", noOfBooks);
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            
            
            }
            else
            
            {
                int result = 0;
                int k = 0;
                int noOfBooks = (int) session.getAttribute("count");
                for (int i = 1; i <= noOfBooks; i++) {
                    for (int j = 1; j <= 4; j++) {
                        k++;
                        System.out.println(request.getParameter("value" + k));
                        if (j == 1) {
                            value1 = request.getParameter("value" + k);
                        } else if (j == 2) {
                            value2 = request.getParameter("value" + k);
                        } else if (j == 3) {
                            value3 = request.getParameter("value" + k);
                        } else if (j == 4) {
                            value4 = request.getParameter("value" + k);
                        }
                    }
                    conn = dao.getConnection();
                    String insertQuery = "insert into books values(?,?,?,?)";
                    insertStatement = conn.prepareStatement(insertQuery);
                    insertStatement.setString(1, value1);
                    insertStatement.setString(2, value2);
                    insertStatement.setString(3, value3);
                    insertStatement.setString(4, value4);

                    result = insertStatement.executeUpdate();
                }

                if (result > 0) {
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Views/Success.jsp");
                    rd.forward(request, response);
                }
            }
            
            
            
            
            }
            
            /* TODO output your page here. You may use following sample code. */
            
        }
        
        
      
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BooksServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BooksServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}// </editor-fold>


