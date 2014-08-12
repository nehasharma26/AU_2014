<%@page import="assignment.hibernate.enteties.Institute"%>
<%@page import="assignment.hibernate.enteties.ManageInstitute"%>
<%@page  import="assignment.jaxb.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Using JAXB</title>
</head>
<body>

<%
int id=Integer.parseInt(request.getParameter("id"));
ManageInstitute mi=new ManageInstitute();
Institute inst=mi.getinstitute(id);
InstituteXML instxml=new InstituteXML();
instxml.setTitle(inst.getTitle());
instxml.setDescription(inst.getDescription());
instxml.setLocation(inst.getLocation());
instxml.setBranches(inst.getBranches());
instxml.setCourses(inst.getCourses());
JaxbRun.jaxbRun(instxml);
response.sendRedirect("index.jsp");
%> 

</body>
</html>