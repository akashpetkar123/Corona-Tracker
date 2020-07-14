<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is a test project to show the corona cases of the given countries</h1>
	<form action="${pageContext.request.contextPath}/home/coronaInformation" method="post">
		<table border="2">
			<tr>
				<th>Select the Country</th>
				<td>
					<select name="country" >
						<option value="IN">India</option>
						<option value="US">United States of America</option>
						<option value="BR">Brazil</option>
						<option value="RU">Russia</option>
						<option value="PE">Peru</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Submit"/>
				</td>
			</tr>
		</table>
	</form>
	<%-- <div>
		<h1>This is a Test Website for Corona Information of India</h1>
		<a href="${pageContext.request.contextPath}/home/coronaInformation">Link to Corona Information</a>
	</div> --%>
	
</body>
</html>
