<html><body>
<h2>Reports</h2>
<form action="report" method="post">
<select name="type">
<option value="above">Marks Above</option>
<option value="subject">By Subject</option>
<option value="top">Top N</option>
</select><br>
<input name="value" placeholder="Marks">
<input name="subject" placeholder="Subject">
<input name="topn" placeholder="Top N">
<button>Generate</button>
</form>
</body></html>