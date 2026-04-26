package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.dao.MarkDAO;
import com.model.StudentMark;
import java.util.List;

public class ReportServlet extends HttpServlet {

 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

  try{
   String type = req.getParameter("type");
   MarkDAO dao = new MarkDAO();

   List<StudentMark> list = null;   // ✅ FIXED

   if(type.equals("above")){
     int val = Integer.parseInt(req.getParameter("value"));
     list = dao.getMarksAbove(val);

   } else if(type.equals("subject")){
     list = dao.getBySubject(req.getParameter("subject"));

   } else if(type.equals("top")){
     int n = Integer.parseInt(req.getParameter("topn"));
     list = dao.getTopN(n);
   }

   req.setAttribute("data", list);
   RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
   rd.forward(req, res);

  } catch(Exception e){
    e.printStackTrace();
  }
 }
}