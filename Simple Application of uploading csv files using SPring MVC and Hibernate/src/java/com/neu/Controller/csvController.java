/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.Controller;

import com.neu.DAO.salesOrderDao;
import com.neu.pojo.SalesOrder;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Jaya
 */
public class csvController implements Controller{
    
    salesOrderDao salesOrderDao;

    public csvController( salesOrderDao salesOrderDao) {
        
        this.salesOrderDao = salesOrderDao;
    }

    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ModelAndView mv = new ModelAndView();
        String action = hsr.getParameter("action");
        if (action.equalsIgnoreCase("view")) {
            String nameCsvFile=hsr.getParameter("nameCsv");
            action="disp";
            mv.addObject("action",action);
            mv.setViewName("index");

        } else if(action.equalsIgnoreCase("insert")) {
            String[] parameterValues = hsr.getParameterValues("value");
            ArrayList<SalesOrder> salesOrdersList = new ArrayList<>();
            int j=0;
            int count;
            while (j<parameterValues.length) {
                int i = 1;
                while (i <= 25) {

                    SalesOrder so = new SalesOrder();
                    
                    so.setSalesOrderID(parameterValues[j++]);i++;
                    so.setRevisionNumber(parameterValues[j++]);i++;
                    so.setOrderDate(parameterValues[j++]);i++;
                    so.setDueDate(parameterValues[j++]);i++;
                    so.setShipDate(parameterValues[j++]);i++;
                    so.setStatus(parameterValues[j++]);i++;
                    so.setOnlineOrderFlag(parameterValues[j++]);i++;
                    so.setSalesOrderNumber(parameterValues[j++]);i++;
                    so.setPurchaseOrderNumber(parameterValues[j++]);i++;
                    so.setAccountNumber(parameterValues[j++]);i++;
                    so.setCustomerID(parameterValues[j++]);i++;
                    so.setSalesPersonID(parameterValues[j++]);i++;
                    so.setTerritoryID(parameterValues[j++]);i++;
                    so.setBillToAddressID(parameterValues[j++]);i++;
                    so.setShipToAddressID(parameterValues[j++]);i++;
                    so.setShipMethodID(parameterValues[j++]);i++;
                    so.setCreditCardID(parameterValues[j++]);i++;
                    so.setCreditCardApprovalCode(parameterValues[j++]);i++;
                    so.setCurrencyRateID(parameterValues[j++]);i++;
                    so.setSubTotal(parameterValues[j++]);i++;
                    so.setTaxAmt(parameterValues[j++]);i++;
                    so.setFreight(parameterValues[j++]);i++;
                    so.setTotalDue(parameterValues[j++]);i++;
                    so.setComment(parameterValues[j++]);i++;
                    so.setModifiedDate(parameterValues[j++]);i++;
                    salesOrdersList.add(so);
                }

            }
            count=salesOrdersList.size();
            salesOrderDao.insert(salesOrdersList);
            mv.addObject("count",count);
            mv.setViewName("index");
        }
        return mv;
    }
    
}
