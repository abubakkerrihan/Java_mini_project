<%@ page import="java.util.*,com.model.StudentMark" %>

<!DOCTYPE html>
<html>
<head>
<title>Update Student Marks</title>

<style>

body{
    font-family: Arial, sans-serif;
    background: linear-gradient(to right,#e3f2fd,#f4f7fc);
    margin:0;
    padding:30px;
}

.container{
    width:95%;
    margin:auto;
}

h2{
    text-align:center;
    color:#0d47a1;
    margin-bottom:30px;
    font-size:32px;
}

.table-container{
    background:white;
    padding:20px;
    border-radius:12px;
    box-shadow:0 4px 15px rgba(0,0,0,0.1);
    overflow-x:auto;
}

table{
    width:100%;
    border-collapse:collapse;
}

table th{
    background:#1976d2;
    color:white;
    padding:15px;
    font-size:16px;
}

table td{
    padding:14px;
    text-align:center;
    border-bottom:1px solid #ddd;
}

table tr:hover{
    background:#f5f5f5;
}

.form-container{
    width:450px;
    margin:40px auto;
    background:white;
    padding:30px;
    border-radius:15px;
    box-shadow:0 4px 15px rgba(0,0,0,0.1);
}

.form-container h3{
    text-align:center;
    color:#1565c0;
    margin-bottom:20px;
}

.form input{
    width:100%;
    padding:12px;
    margin:10px 0;
    border:1px solid #ccc;
    border-radius:8px;
    font-size:15px;
    box-sizing:border-box;
}

.form input:focus{
    border-color:#1976d2;
    outline:none;
    box-shadow:0 0 5px rgba(25,118,210,0.4);
}

button{
    width:100%;
    padding:12px;
    background:#1976d2;
    color:white;
    border:none;
    border-radius:8px;
    font-size:16px;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    background:#0d47a1;
}

.edit-btn{
    background:#ff9800;
    color:white;
    border:none;
    padding:8px 14px;
    border-radius:6px;
    cursor:pointer;
    transition:0.3s;
}

.edit-btn:hover{
    background:#f57c00;
}

.back-btn{
    display:block;
    width:200px;
    margin:20px auto;
    text-align:center;
    text-decoration:none;
    background:#424242;
    color:white;
    padding:12px;
    border-radius:8px;
    transition:0.3s;
}

.back-btn:hover{
    background:#212121;
}

</style>

</head>

<body>

<div class="container">

<h2>Update Student Marks</h2>

<div class="table-container">

<table>

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Subject</th>
    <th>Marks</th>
    <th>Date</th>
    <th>Action</th>
</tr>

<%

List<StudentMark> list =
(List<StudentMark>)request.getAttribute("list");

if(list != null){

    for(StudentMark m : list){

%>

<tr>

    <td><%= m.getStudentID() %></td>

    <td><%= m.getStudentName() %></td>

    <td><%= m.getSubject() %></td>

    <td><%= m.getMarks() %></td>

    <td><%= m.getExamDate() %></td>

    <td>

        <button
            type="button"
            class="edit-btn"
            onclick="fillForm(
                '<%= m.getStudentID() %>',
                '<%= m.getStudentName() %>',
                '<%= m.getSubject() %>',
                '<%= m.getMarks() %>',
                '<%= m.getExamDate() %>'
            )">

            Edit

        </button>

    </td>

</tr>

<%
    }
}
%>

</table>

</div>

<div class="form-container">

<h3>Update Record</h3>

<form action="UpdateMarkServlet"
      method="post"
      class="form"
      onsubmit="return confirmUpdate();">

    <input type="number"
           id="id"
           name="id"
           placeholder="Student ID"
           readonly
           required>

    <input type="text"
           id="name"
           name="name"
           placeholder="Student Name"
           required>

    <input type="text"
           id="subject"
           name="subject"
           placeholder="Subject"
           required>

    <input type="number"
           id="marks"
           name="marks"
           placeholder="Marks"
           required>

    <input type="date"
           id="date"
           name="date"
           required>

    <button type="submit">
        Update Record
    </button>

</form>

</div>

<a href="index.jsp" class="back-btn">
    Back To Home
</a>

</div>

<script>

function fillForm(id,name,subject,marks,date){

    document.getElementById("id").value = id;
    document.getElementById("name").value = name;
    document.getElementById("subject").value = subject;
    document.getElementById("marks").value = marks;
    document.getElementById("date").value = date;

    window.scrollTo({
        top:document.body.scrollHeight,
        behavior:'smooth'
    });
}

function confirmUpdate(){

    return confirm(
        "Are you sure you want to update this student record?"
    );
}

</script>

</body>
</html>