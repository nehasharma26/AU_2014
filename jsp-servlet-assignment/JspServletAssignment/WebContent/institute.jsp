<%@page import="java.util.*"%>
<%@page import=" org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="assignment.hibernate.enteties.ManageInstitute"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="hibernate.util.HibernateUtil"%>
<%@page import=" org.hibernate.HibernateException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="assignment.hibernate.enteties.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index.jsp</title>
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


</body>
<div class="wrapper">
	<form method="post">

		<table width=80% border=0 >
			<tr>
				<td><h4>instId</h4></td>
				<td><h4>title</h4></td>
				<td><h4>description</h4></td>
				<td><h4>location</h4></td>
				<td><h4>branches</h4></td>
			</tr>
			<%
				final SessionFactory factory = HibernateUtil.getSessionFactory();
				Session ses = factory.openSession();
				Transaction tx = null;
				//ArrayList<Institute> array=null;
				try {
					tx = ses.beginTransaction();
					List inst = ses.createQuery("FROM Institute").list();
					for (Iterator iterator1 = inst.iterator(); iterator1.hasNext();) {
						Institute insti = (Institute) iterator1.next();
						//array.add(institute);
			%>
			<tr>
				<td><%=insti.getInstId()%></td>
				<td><%=insti.getTitle()%></td>
				<td><%=insti.getDescription()%></td>
				<td><%=insti.getLocation()%></td>
				<td><%=insti.getBranches()%></td>
				
			</tr><tr><td><a href="displayInfo.jsp?id=<%=insti.getInstId()%>">view info</a></td></tr><tr><td>   </td></tr><tr><td>   </td></tr>
			<%
				}
					tx.commit();
				} catch (HibernateException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				} finally {
					
					//converting to json
					Gson gson = new Gson();
			        String jsonNames = gson.toJson(array);
				}
			%>


		</table>


	</form>
</div>
</html>