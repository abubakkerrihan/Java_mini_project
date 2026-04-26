package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;
import com.dao.MarkDAO;
import com.model.StudentMark;

public class AddMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            String idStr = req.getParameter("id");
            String marksStr = req.getParameter("marks");
            String dateStr = req.getParameter("date");

            if(idStr == null || marksStr == null || dateStr == null ||
               idStr.isEmpty() || marksStr.isEmpty() || dateStr.isEmpty()) {

                res.getWriter().println("ERROR: All fields are required");
                return;
            }

            StudentMark s = new StudentMark();
            s.setStudentId(Integer.parseInt(idStr));
            s.setStudentName(req.getParameter("name"));
            s.setSubject(req.getParameter("subject"));
            s.setMarks(Integer.parseInt(marksStr));
            s.setExamDate(Date.valueOf(dateStr));

            new MarkDAO().addMark(s);

            res.sendRedirect("markdisplay.jsp");

        } catch(Exception e){
            e.printStackTrace();
            res.setContentType("text/plain");
            res.getWriter().println("ERROR: " + e.getMessage());
        }
    }
}