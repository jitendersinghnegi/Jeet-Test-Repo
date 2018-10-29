<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*,java.util.*"%>
<%! 
Connection con;

private boolean isValidUser(String userName,String password){
	try{
		String sql = "select * from users where username = ? and password = ?";
		PreparedStatement ps  = con.prepareStatement(sql);
		ps.setString(1,userName);
		ps.setString(2,password);
		
		ResultSet resultSet = ps.executeQuery();
		if(resultSet.next()){
			return true;
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
	}
	return false;
}
%>

<% 
String userName = request.getParameter("userName");
String password = request.getParameter("password");

String driverClass = application.getInitParameter("dbDriver");
String url = application.getInitParameter("dbUrl");
String dbUser = application.getInitParameter("dbUser");
String dbPassword = application.getInitParameter("dbPwd");

try{
	Class.forName(driverClass);
}catch(Exception ex){
	ex.printStackTrace();
}

con = DriverManager.getConnection(url, dbUser, dbPassword);
application.setAttribute("Connection", con);
boolean authFlag = isValidUser(userName,password);
session.setAttribute("User", userName);
if(authFlag){
	response.sendRedirect("rooms.jsp");
}else{
	response.sendRedirect("error.jsp");
}
%>