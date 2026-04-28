<!DOCTYPE html>
<html>
<head>
<title>Update Marks</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Update Student Marks</h2>

<form action="UpdateMarkServlet" method="post" class="form">
    <input type="number" name="id" placeholder="Student ID" required>
    <input type="text" name="name" placeholder="Student Name" required>
    <input type="text" name="subject" placeholder="Subject" required>
    <input type="number" name="marks" placeholder="Marks" required>
    <input type="date" name="date" required>

    <button type="submit">Update</button>
</form>

<a href="index.jsp">Back</a>

</body>
</html>