<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
.con1{
width:50%;
margin-left: 25%;
}
</style>


<%@ include file="link" %>
</head>
<body>
<%@ include file="header-admin.jsp" %>

<div class="con1">

<div class="card">
  <div class="card-header">
   Date of attendance
  </div>
  
  
  <div class="card-body">
    <form action="http://localhost:8080/add">
     <div class="form-group">
    <label for="formGroupExampleInput">Date of Attendance</label>
    <input type="date" placeholder="yyyy-mm-dd " name = "date">
    </div>
    
    
     <button type="submit" class="btn btn-primary mb-2">Add attendance</button>
     
     </form>
  </div>
</div>

</div>

<%@ include file="script" %>
</body>
</html>