/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.controller;

import com.neu.edu.DAO.csvDAO;
import com.neu.edu.DAO.salesOrderDao;
import com.neu.edu.pojo.SalesOrder;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.springframework.web.portlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Jaya
 */
public class csvController implements Controller {

    csvDAO csvDao;
    salesOrderDao salesOrderDao;

    public csvController(csvDAO csvDao, salesOrderDao salesOrderDao) {
        this.csvDao = csvDao;
        this.salesOrderDao = salesOrderDao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ModelAndView mv = new ModelAndView();
        String action = "default";
        if (hsr.getParameter("action") != null) {
            action = hsr.getParameter("action");
        }
        if (action.equalsIgnoreCase("view")) {
            ArrayList<SalesOrder> salesOrderList = new ArrayList<SalesOrder>();
            String nameCsvFile = hsr.getParameter("nameCsv");
            HttpSession session=hsr.getSession();
            session.setAttribute("file", nameCsvFile);
            int page = 1;
            int recordsPerPage = 50;
            if (hsr.getParameter("page") != null) {
                page = Integer.parseInt(hsr.getParameter("page"));
            }
            salesOrderList = csvDao.getCsv((String) session.getAttribute("file"), (page - 1) * recordsPerPage, recordsPerPage);
            mv.addObject(salesOrderList);
            mv.setViewName("index");

        }        
        else if (action.equalsIgnoreCase("insert")) {
            String[] parameterValues = hsr.getParameterValues("value");
            ArrayList<SalesOrder> salesOrdersList = new ArrayList<>();
            int j = 0;
            int count;
            while (j < parameterValues.length) {
                int i = 1;
                while (i <= 25) {

                    SalesOrder so = new SalesOrder();

                    so.setSalesOrderID(parameterValues[j++]);
                    i++;
                    so.setRevisionNumber(parameterValues[j++]);
                    i++;
                    so.setOrderDate(parameterValues[j++]);
                    i++;
                    so.setDueDate(parameterValues[j++]);
                    i++;
                    so.setShipDate(parameterValues[j++]);
                    i++;
                    so.setStatus(parameterValues[j++]);
                    i++;
                    so.setOnlineOrderFlag(parameterValues[j++]);
                    i++;
                    so.setSalesOrderNumber(parameterValues[j++]);
                    i++;
                    so.setPurchaseOrderNumber(parameterValues[j++]);
                    i++;
                    so.setAccountNumber(parameterValues[j++]);
                    i++;
                    so.setCustomerID(parameterValues[j++]);
                    i++;
                    so.setSalesPersonID(parameterValues[j++]);
                    i++;
                    so.setTerritoryID(parameterValues[j++]);
                    i++;
                    so.setBillToAddressID(parameterValues[j++]);
                    i++;
                    so.setShipToAddressID(parameterValues[j++]);
                    i++;
                    so.setShipMethodID(parameterValues[j++]);
                    i++;
                    so.setCreditCardID(parameterValues[j++]);
                    i++;
                    so.setCreditCardApprovalCode(parameterValues[j++]);
                    i++;
                    so.setCurrencyRateID(parameterValues[j++]);
                    i++;
                    so.setSubTotal(parameterValues[j++]);
                    i++;
                    so.setTaxAmt(parameterValues[j++]);
                    i++;
                    so.setFreight(parameterValues[j++]);
                    i++;
                    so.setTotalDue(parameterValues[j++]);
                    i++;
                    so.setComment(parameterValues[j++]);
                    i++;
                    so.setModifiedDate(parameterValues[j++]);
                    i++;
                    salesOrdersList.add(so);
                }

            }
            count = salesOrdersList.size();
            salesOrderDao.insert(salesOrdersList);
            mv.addObject("count", count);
            mv.setViewName("index");
        } else {
            ArrayList<SalesOrder> salesOrderList = new ArrayList<SalesOrder>();
            HttpSession session=hsr.getSession(false);            
            int page = 1;
            int recordsPerPage = 50;
            if (hsr.getParameter("page") != null) {
                page = Integer.parseInt(hsr.getParameter("page"));
            }
            salesOrderList = csvDao.getCsv((String) session.getAttribute("file"), (page - 1) * recordsPerPage, recordsPerPage);
            mv.addObject(salesOrderList);
            mv.setViewName("index");
        }
        return mv;
    }

}
