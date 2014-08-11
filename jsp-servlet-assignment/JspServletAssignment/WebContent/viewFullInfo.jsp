<%@page import="assignment.hibernate.enteties.Institute"%>
<%@page import="assignment.hibernate.enteties.ManageInstitute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("id"));
ManageInstitute mi=new ManageInstitute();
Institute inst=mi.getinstitute(id);
%> 
<table background="white">
<tr><td>Title:</td><td><%=inst.getTitle()%></td></tr>
<tr><td>Description:</td><td><%=inst.getDescription()%></td></tr>
<tr><td>Location:</td><td><%=inst.getLocation()%></td></tr>
<tr><td>Branches:</td><td><%=inst.getBranches()%></td></tr>
<tr><td>Courses:</td><td><%=inst.getCourses()%></td></tr>
<tr></tr>
<tr><td><a href="index.jsp">bacck to main page</a></td></tr>
</table>
 
</body>
</html>