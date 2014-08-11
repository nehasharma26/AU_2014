<%@page import="assignment.hibernate.enteties.Institute"%>
<%@page import="assignment.hibernate.enteties.ManageInstitute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add institute info</title>
<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/cufon-yui.js" type="text/javascript"></script>
<script src="js/ChunkFive_400.font.js" type="text/javascript"></script>
<script type="text/javascript">
	Cufon.replace('h1', {
		textShadow : '1px 1px #fff'
	});
	Cufon.replace('h2', {
		textShadow : '1px 1px #fff'
	});
	Cufon.replace('h3', {
		textShadow : '1px 1px #000'
	});
	Cufon.replace('.back');
</script>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("id"));
ManageInstitute mi=new ManageInstitute();
Institute inst=mi.getinstitute(id);
%> 
<table background="white" align="center" width=70%>
<tr><td>Title:</td><td><%=inst.getTitle()%></td></tr>
<tr><td>Description:</td><td><%=inst.getDescription()%></td></tr>
<tr><td>Location:</td><td><%=inst.getLocation()%></td></tr>
<tr><td>Branches:</td><td><%=inst.getBranches()%></td></tr>
<tr><td>Courses:</td><td><%=inst.getCourses()%></td></tr>
<tr></tr>
<tr><td><a href="viewFullInfo.jsp?id=<%=id%>">view full info of institute</a></td></tr>
<tr><td><a href="deleteInst.jsp?id=<%=id%>">Delete institute</a></td></tr>
<tr><td><a href="update.jsp?id=<%=id%>">update institute</a></td></tr>
</table>
</body>
</html>