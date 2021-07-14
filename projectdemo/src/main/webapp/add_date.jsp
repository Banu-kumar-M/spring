<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>


<!DOCTYPE html>
<html>
<head>
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
<th scope="col">Mark</th>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String a =(String)request.getAttribute("date");

String sql ="select * from spri.attendance where date ='"+a+"';";
System.out.println(sql);
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getInt("eid") %></td>
<td><%=resultSet.getString("ename") %></td>
<td><%=resultSet.getString("date") %></td>
<td><%=resultSet.getString("status") %></td>
<td>
<%

if(resultSet.getString("status").equalsIgnoreCase("Pending")){ %>
<form action="/mark">
<input type="hidden" id="custId" name="eid" value=<%=resultSet.getInt("eid") %>>
<input type="hidden" id="custId" name="date" value=<%=resultSet.getString("date") %>>

<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="radio" id="inlineRadio1" value="Present">
  <label class="form-check-label" for="inlineRadio1">P</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="radio" id="inlineRadio1" value="Absent">
  <label class="form-check-label" for="inlineRadio1">A</label>
</div>
 
<input class="btn btn-warning" type="submit" value="Mark">
</form>
<% }else{ %>
<button type="button" class="btn btn-success">Marked</button>
<% } %>  
</td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
<form action="/">
<button type="submit" class="btn btn-secondary">Done Marking</button>
</form>
</table>


<%@ include file="script" %>
</body>
</html>