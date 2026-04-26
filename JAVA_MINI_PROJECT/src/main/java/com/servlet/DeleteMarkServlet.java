package com.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;
import com.dao.MarkDAO;
import com.model.StudentMark;


public class DeleteMarkServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
	  try{
	   int id = Integer.parseInt(req.getParameter("id"));
	   new MarkDAO().deleteMark(id);
	   res.sendRedirect("markdisplay.jsp");
	  }catch(Exception e){e.printStackTrace();}
	 }
	}