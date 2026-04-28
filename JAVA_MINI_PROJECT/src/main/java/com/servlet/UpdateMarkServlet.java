package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
import com.dao.MarkDAO;
import com.model.StudentMark;

public class UpdateMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            StudentMark mark = new StudentMark();
            mark.setStudentID(Integer.parseInt(request.getParameter("id")));
            mark.setStudentName(request.getParameter("name"));
            mark.setSubject(request.getParameter("subject"));
            mark.setMarks(Integer.parseInt(request.getParameter("marks")));
            mark.setExamDate(Date.valueOf(request.getParameter("date")));

            MarkDAO dao = new MarkDAO();
            dao.updateMark(mark);

            response.sendRedirect("DisplayMarksServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}