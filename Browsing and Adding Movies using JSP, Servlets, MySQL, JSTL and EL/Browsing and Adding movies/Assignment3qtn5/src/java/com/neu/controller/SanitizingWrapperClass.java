/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;



import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class SanitizingWrapperClass extends HttpServletRequestWrapper {
  public SanitizingWrapperClass(HttpServletRequest servletRequest) {
        super(servletRequest);
    }
   @Override
    public String[] getParameterValues(String parameter) {
      String[] values = super.getParameterValues(parameter);
        if (values == null) {
           return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = removingDirtyString(values[i]);
        }
        return encodedValues;
  }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
     return removingDirtyString(value);
    }
    private String removingDirtyString(String value) {
        if (value != null) {
            value = value.replaceAll("", "");
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
            value = value.replaceAll("[^\\dA-Za-z ]","");
            scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
        }
        return value;
    }
}
