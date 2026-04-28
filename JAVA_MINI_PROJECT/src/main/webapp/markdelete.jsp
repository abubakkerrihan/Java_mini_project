<!DOCTYPE html>
<html>
<head>
<title>Delete Marks</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Delete Student Record</h2>

<form action="DeleteMarkServlet" method="post" class="form">
    <input type="number" name="id" placeholder="Student ID" required>
    <button type="submit">Delete</button>
</form>

<a href="index.jsp">Back</a>

</body>
</html>