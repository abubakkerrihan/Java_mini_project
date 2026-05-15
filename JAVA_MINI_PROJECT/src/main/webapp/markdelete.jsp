<!DOCTYPE html>
<html>
<head>
<title>Delete Marks</title>
<link rel="stylesheet" href="style.css">

<script>
function confirmDelete() {
    return confirm("Are you sure you want to delete this student record?");
}
</script>

</head>

<body>

<h2>Delete Student Record</h2>

<form action="DeleteMarkServlet"
      method="post"
      class="form"
      onsubmit="return confirmDelete();">

    <input type="number"
           name="id"
           placeholder="Student ID"
           required>

    <button type="submit">Delete</button>

</form>

<a href="index.jsp">Back</a>

</body>
</html>