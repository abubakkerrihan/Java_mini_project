package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import com.dao.MarkDAO;
import com.model.StudentMark;

public class ReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String type = request.getParameter("type");

            MarkDAO dao = new MarkDAO();
            List<StudentMark> list = null;

            if (type.equals("above")) {
                int value = Integer.parseInt(request.getParameter("value"));
                list = dao.getAboveMarks(value);
            } 
            else if (type.equals("subject")) {
                String subject = request.getParameter("subject");
                list = dao.getBySubject(subject);
            } 
            else if (type.equals("top")) {
                int n = Integer.parseInt(request.getParameter("n"));
                list = dao.getTopN(n);
            }

            request.setAttribute("list", list);
            RequestDispatcher rd = request.getRequestDispatcher("report_result.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}