<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result submit</title>
</head>
<body>
	<%@ page import="entities.Student" %>

	<%
		Student student = new Student();
		student = (Student) request.getAttribute("student");
		out.println(
					"First name " + student.getFirstName()
					+ "<br/> Last name: " + student.getLastName()
					+ "<br/> Gender: " + student.getGender()
					+ "<br/> Birthday" + student.getDateOfBirth()
				);
		
		%>
			
		
	
</body>
</html>