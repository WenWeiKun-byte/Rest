package com.rhcloud.unity3d.servlet;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.rhcloud.unity3d.ejb.ConverterBean;

@WebServlet
public class ConverterServlet extends HttpServlet {
  @EJB
  ConverterBean converterBean;
  
}
