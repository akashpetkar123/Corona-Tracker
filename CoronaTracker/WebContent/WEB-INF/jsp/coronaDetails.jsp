<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	table, th, td {
	  border: 1px solid black;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>Confirmed Cases</th>
			<td>${confirmed}</td>
		</tr>
		<tr>
			<th>Death Cases</th>
			<td>${deaths}</td>
		</tr>
		<tr>
			<th>Active Cases</th>
			<td>${activeCases}</td>
		</tr>
		<tr>
			<th>Recovered Cases</th>
			<td>${recovered}</td>
		</tr>
		<tr>
			<th>Recovery Rate</th>
			<td>${recoveryRate} %</td>
		</tr>
		<tr>
			<th>Death Rate</th>
			<td>${deathRate} %</td>
		</tr>
	</table>
	<p>
		<a href="${pageContext.request.contextPath}">Link to Index Page</a>
	</p>
	<p>
		Note:- This API contains information of all the countries. 
	</p>
</body>
</html>