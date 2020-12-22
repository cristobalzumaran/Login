<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%
	String men = request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : "";
%>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Employee Login Form</h1>
		<form action="<%=request.getContextPath()%>/LoginServlet"
			method="post">
			<table style="with: 100%">
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>

			</table>
			<input type="submit" value="Submit" />
		</form>
		<font color=red><%=men%></font>
	</div>
</body>
</html>