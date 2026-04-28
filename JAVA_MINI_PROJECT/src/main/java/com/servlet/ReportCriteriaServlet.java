package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ReportCriteriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");

        if (type.equals("above")) {
            response.sendRedirect("ReportServlet?type=above&value=" + request.getParameter("value"));
        } 
        else if (type.equals("subject")) {
            response.sendRedirect("ReportServlet?type=subject&subject=" + request.getParameter("subject"));
        } 
        else if (type.equals("top")) {
            response.sendRedirect("ReportServlet?type=top&n=" + request.getParameter("n"));
        }
    }
}