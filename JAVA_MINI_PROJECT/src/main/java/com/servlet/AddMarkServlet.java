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
            StudentMark s = new StudentMark();
            s.setStudentId(Integer.parseInt(req.getParameter("id")));
            s.setStudentName(req.getParameter("name"));
            s.setSubject(req.getParameter("subject"));
            s.setMarks(Integer.parseInt(req.getParameter("marks")));
            s.setExamDate(Date.valueOf(req.getParameter("date")));

            new MarkDAO().addMark(s);
            res.sendRedirect("markdisplay.jsp");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}