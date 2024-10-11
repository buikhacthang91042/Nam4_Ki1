<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.TaiKhoan" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registered Users</title>
</head>
<body>
    <h2>Registered Users</h2>
    <table border="1">
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Gender</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<TaiKhoan> tks = (List<TaiKhoan>) request.getAttribute("tkList");
                if (tks != null) {
                    for (TaiKhoan tk : tks) {
            %>
                <tr>
                    <td><%= tk.getFirstName() %></td>
                    <td><%= tk.getLastName() %></td>
                    <td><%= tk.getEmail() %></td>
                    <td><%= tk.getGender() %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4">No registered users found</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
