<!DOCTYPE html>
<html>
<head>
<title>Reports</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Generate Reports</h2>

<form action="ReportCriteriaServlet" method="post" class="form">

<label>Marks Above:</label>
<input type="number" name="value">
<button name="type" value="above">Generate</button>

<br><br>

<label>By Subject:</label>
<input type="text" name="subject">
<button name="type" value="subject">Generate</button>

<br><br>

<label>Top N Students:</label>
<input type="number" name="n">
<button name="type" value="top">Generate</button>

</form>

<a href="index.jsp">Back</a>

</body>
</html>