package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MarkDAO;
import com.model.StudentMark;

public class DisplayMarksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

            MarkDAO dao = new MarkDAO();

            // Get all records from database
            List<StudentMark> list = dao.getAllMarks();

            // Send list to JSP page
            request.setAttribute("list", list);

            // Open update page with records
            RequestDispatcher rd =
                request.getRequestDispatcher("markupdate.jsp");

            rd.forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}