/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.DAO.DAO;
import com.neu.model.MovieDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jaya_L
 */
@WebServlet(name = "insertingData", urlPatterns = {"/insertingData"})
public class insertingData extends HttpServlet {

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
         PrintWriter out = response.getWriter();
         
         out.println("Processing the request");
         Statement stmt=null;
         ResultSet rs=null;
         
         String dburl=getServletContext().getInitParameter("dburl");
         String dbuser=getServletContext().getInitParameter("dbuser");
         String dbpassword=getServletContext().getInitParameter("dbpassword");
         String dbdriver=getServletContext().getInitParameter("dbdriver");
        Cookie[] cookies=request.getCookies();
        
        Connection conn=DAO.getConnectionJDBC(dburl, dbuser, dbpassword, dbdriver);
         
        try  {
            
            
            if(request.getParameter("addBrowse").equalsIgnoreCase("add"))
            {
            String title = request.getParameter("title");
           String actor = request.getParameter("actor");
           String actress = request.getParameter("actress");
           String genre = request.getParameter("genre");
           String year = request.getParameter("year");  
            if(conn!=null)
        {
        
        stmt=conn.createStatement();
        out.println("<html><body>"+actor+"</body></html>");
        String query="insert into movies(title,actor,actress,genre,year) "
                + "values( '"+title+"','"+actor+"','"+actress+"','"+genre+"','"+year+"')";
        String remember = request.getParameter("remember");
        int result= stmt.executeUpdate(query);
        
        
        
        if(result>0)
        {
            RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Views/movieAdded.jsp");
            rd.forward(request, response);
        
        }
        
        else
        {
        
        out.println("Result is <0");
        }
        
        
        
        
        
        }
          
            
          else
            {
            
            out.println("Connection is null");
            }
            
            
            }
            
        
            
            
            
            
            
            else if(request.getParameter("addBrowse").equalsIgnoreCase("browse"))
                
            {
            
            String keyword=request.getParameter("keyword");
            request.setAttribute("keyword", keyword);
            String category=request.getParameter("category");
    
          String columns[] = category.split(" ",3); //splits the string into 3 parts, delimiter is first argument
          String col = columns[2];
          String queryTitle = null;
          stmt = conn.createStatement();
          
          if(keyword.isEmpty())
             {
             queryTitle = "SELECT distinct * FROM movies";
             }
             else 
             {
                queryTitle = "SELECT distinct * FROM movies " +
                  " WHERE "+col+" LIKE '%"+keyword+"%'";
             }
            
          rs=stmt.executeQuery(queryTitle);
          ArrayList<MovieDetails> movieDetails= new ArrayList();
          
          while(rs.next())
          {
          MovieDetails md=new MovieDetails();
          md.setTitle(rs.getString("title"));
          md.setActor(rs.getString("actor"));
          md.setActress(rs.getString("actress"));
          md.setGenre(rs.getString("genre"));
          md.setYear(rs.getString("year"));
          movieDetails.add(md);
          
          
          
          }



if(movieDetails.size()==0)
{
RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Views/NoResult.jsp");
rd.forward(request, response);


}


else
{
request.setAttribute("movies", movieDetails);
RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Views/SearchResult.jsp");
rd.forward(request, response);

}
      
            }            
            
            /* TODO output your page here. You may use following sample code. */
           
        }
        
        catch(Exception e)
        {
          out.println("<html><body>"+e.getMessage()+"</body></html>");
        } 
        
         finally {
            out.close();
            conn.close();
        }
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
            Logger.getLogger(insertingData.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(insertingData.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold>

}
