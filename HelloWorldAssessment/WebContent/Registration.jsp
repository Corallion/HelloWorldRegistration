<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="registration" action="RegistrationPage" method="post">
<input type="hidden" name="pageName" value="registration">
<table>
	<tr><td>First Name </td><td><input name="FirstName" maxlength="20"/></td></tr>
	<tr><td>Last Name </td><td><input name="LastName" maxlength="20"/></td></tr>
	<tr><td>Address1 </td><td><input name="Address1" maxlength="30"/></td></tr>
	<tr><td>Address2 </td><td><input name="Address2" maxlength="20"/></td></tr>
	<tr><td>City </td><td><input name="City" maxlength="30"/></td></tr>
	<tr><td>State </td><td><input name="State" maxlength="2"/></td></tr>
	<tr><td>Zip </td><td><input name="Zip" maxlength="10"/></td></tr>
	<tr><td>Country (US Only) </td><td><input name="Country" maxlength="2"/></td></tr>
	
	<tr>
		<td><button type="submit">Submit</button></td>
	</tr>
</table>
</form>
</body>
</html>