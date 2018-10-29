<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPFundamentals : Declarations</title>
</head>
<body>
<%!
double getBonus(double salary){
	return salary * 0.10;
}
%>
<p>The bonus for 500 is : <%=getBonus(500) %></p>
</body>
</html>