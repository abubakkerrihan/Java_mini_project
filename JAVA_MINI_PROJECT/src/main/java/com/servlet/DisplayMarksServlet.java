package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import com.dao.MarkDAO;
import com.model.StudentMark;

public class DisplayMarksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            MarkDAO dao = new MarkDAO();
            List<StudentMark> list = dao.getAllMarks();

            request.setAttribute("list", list);
            RequestDispatcher rd = request.getRequestDispatcher("markdisplay.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}