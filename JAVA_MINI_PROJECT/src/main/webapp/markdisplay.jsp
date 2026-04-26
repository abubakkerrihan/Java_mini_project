<%@ page import="java.util.*,com.dao.*,com.model.*" %>

<html>
<head>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Student Marks</h2>

<table border="1">
<tr>
<th>ID</th><th>Name</th><th>Subject</th><th>Marks</th>
</tr>

<%
try {
    List<StudentMark> list = new MarkDAO().getAllMarks();
    for(StudentMark s : list){
%>
<tr>
<td><%= s.getStudentId() %></td>
<td><%= s.getStudentName() %></td>
<td><%= s.getSubject() %></td>
<td><%= s.getMarks() %></td>
</tr>
<%
    }
} catch(Exception e){
    out.println("Error: " + e.getMessage());
}
%>

</table>

</body>
</html>