package com.servlet;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
import com.dao.MarkDAO;
import com.model.StudentMark;

public class AddMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            StudentMark mark = new StudentMark();
            mark.setStudentName(request.getParameter("name"));
            mark.setSubject(request.getParameter("subject"));
            mark.setMarks(Integer.parseInt(request.getParameter("marks")));
            mark.setExamDate(Date.valueOf(request.getParameter("date")));

            MarkDAO dao = new MarkDAO();
            dao.insertMark(mark);

            response.sendRedirect("DisplayMarksServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}