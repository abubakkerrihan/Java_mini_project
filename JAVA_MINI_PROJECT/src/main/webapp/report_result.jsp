<%@ page import="java.util.*,com.model.*" %>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Subject</th><th>Marks</th></tr>
<%
 List<StudentMark> list = (List<StudentMark>)request.getAttribute("data");
 for(StudentMark s:list){
%>
<tr>
<td><%=s.getStudentId()%></td>
<td><%=s.getStudentName()%></td>
<td><%=s.getSubject()%></td>
<td><%=s.getMarks()%></td>
</tr>
<% } %>
</table>