<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "update" method="post">
		Enter Book Id : <input type = "text" name = "updatebookId">
		<br><br>
		Enter only those values which you want to update. 
		<br><br>
		Enter Book Name : <input type = "text" name = "updatebookName">
		<br><br>
		Enter Author Name : <input type = "text" name = "updateAuthor">
		<br><br>
		Enter Publisher Name : <input type = "text" name = "updatePublisher">
		<br><br>
		<input type ="submit" value ="Update">
	</form>
</body>
</html>