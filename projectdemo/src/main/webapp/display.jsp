<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>



<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="link" %>
</head>
<body>
<%@ include file="header-admin.jsp" %>


<%

String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/spri";
String database = "spri";
String userid = "root";
String password = "Kannada123";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<table class = "table table-striped" >
<tr>
<th scope="col">Employee_id</th>
<th scope="col">Date</th>
<th scope="col">Employee_name</th>
<th scope="col">Status</th>
<th scope="col">Action</th>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();

String sql ="select * from spri.attendance;";
System.out.println(sql);
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getInt("eid") %></td>
<td><%=resultSet.getString("date") %></td>
<td><%=resultSet.getString("ename") %></td>
<td><%=resultSet.getString("status") %></td>
<td>
<form action="/">
<button type="submit" class="btn btn-secondary">Done</button>
</form>
</td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>


<%@ include file="script" %>
</body>
</html>





