package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.MarkDAO;

public class DeleteMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            MarkDAO dao = new MarkDAO();
            dao.deleteMark(id);

            response.sendRedirect("DisplayMarksServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}