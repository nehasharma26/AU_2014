<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<div class="wrapper">
		<h1>Add course info</h1>
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">
				<form class="register active" action="addCourse" method="GET">
					<h3>Add Course</h3>
					<div class="column">
						<div>
							<label>Title:</label> <input type="text" name="Name" /> <span
								class="error">This is an error</span>
						</div>
						<div>
							<label>Description:</label> <input type="text" name="Description" />
							<span class="error">This is an error</span>
						</div>
						<div>
							<label>Duration in months:</label> <input type="text"
								name="Duration" /> <span class="error">This is an error</span>
						</div>
						<div>
							<label>Admission process:</label> <input type="text"
								name="AdmissionProcess" /> <span class="error">This is an error</span>
						</div>
						<div>
							<label>Eligibility criteria:</label> <input type="text"
								name="EligibilityCriteria" /> <span class="error">This is an error</span>
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