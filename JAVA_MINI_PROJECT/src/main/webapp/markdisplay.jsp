<%@ page import="java.util.*, com.model.StudentMark" %>

<!DOCTYPE html>
<html>
<head>
<title>Display Marks</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>All Student Records</h2>

<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Subject</th>
<th>Marks</th>
<th>Date</th>
</tr>

<%
List<StudentMark> list = (List<StudentMark>)request.getAttribute("list");

for(StudentMark m : list){
%>

<tr>
<td><%=m.getStudentID()%></td>
<td><%=m.getStudentName()%></td>
<td><%=m.getSubject()%></td>
<td><%=m.getMarks()%></td>
<td><%=m.getExamDate()%></td>
</tr>

<% } %>

</table>

<a href="index.jsp">Back</a>

</body>
</html>