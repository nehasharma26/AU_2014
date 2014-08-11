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

<div class="wrapper">
		<h1>Add course info</h1>
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">
				<form class="register active" action="updateInfo?id="<%=inst.getTitle()%>"/> method="GET">
					<h3 align="center">Update institute info</h3>
					<div class="column">
					<div>
							<label>ID:</label> <input type="text" name="id" value="<%=inst.getInstId()%>" readonly="readonly"/> <span
								class="error">This is an error</span>
						</div>
						<div>
							<label>Title:</label> <input type="text" name="Title" value="<%=inst.getTitle()%>"/> <span
								class="error">This is an error</span>
						</div>
						<div>
							<label>Description:</label> <input type="text" name="Description" value="<%=inst.getDescription()%>"/>
							<span class="error">This is an error</span>
						</div>
						<div>
							<label>Location</label> <input type="text"
								name="Duration" value="<%=inst.getLocation()%>"/> <span class="error">This is an error</span>
						</div>
						<div>
							<label>Branches</label> <input type="text"
								name="AdmissionProcess" value="<%=inst.getBranches()%>"/> <span class="error">This is an error</span>
						</div>
						<div>
							<label>courses:</label> <input type="text"
								name="EligibilityCriteria" value="<%=inst.getCourses()%>"/> <span class="error">This is an error</span>
						</div>
					</div>
					<div class="bottom"></div>
					<input type="submit" value="Add" />
					<div class="clear"></div>
			</div>

		</div>
		<div class="clear"></div>
	</div>

</body>
</html>