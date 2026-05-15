<!DOCTYPE html>
<html>
<head>
<title>Add Marks</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Add Student Marks</h2>

<form action="AddMarkServlet" method="post" class="form">
    <input type="text" name="name" placeholder="Student Name" required>
    <input type="text" name="subject" placeholder="Subject" required>
    <input type="number" name="marks" placeholder="Marks" required>
    <input type="date" name="date" required>

    <button type="submit">Add</button>
</form>

<a href="index.jsp">Back</a>

</body>
</html>