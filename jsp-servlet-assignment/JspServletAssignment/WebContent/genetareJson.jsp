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
SessionFactory sessionFactory = new Configuration().configure()
.buildSessionFactory();

Session session = sessionFactory.getCurrentSession();

// Get All Employees
JSONArray array=new JSONArray();

Transaction tx = session.beginTransaction();
Query query = session.createQuery("from Institute");
List<Institute> empList = query.list();


for (Institute course1 : empList) {
JSONObject object=new JSONObject();



object.put("name", course1.getTitle());
object.put("description", course1.getDescription());
object.put("durationInMonths", course1.getDurationInMonths());
object.put("eligibilityCriteria", course1.getEligibilityCriteria());


JSONArray array2=new JSONArray();
JSONObject object2=new JSONObject();
Query query2 = session
 .createQuery("from Course c where c.InstituteId = "+ course1.getInstituteId());
List<Course> course = query2.list();

for (Course course2 : course) {

object2.put("name", course2.getTitle());
object2.put("description", course2.getDescription());
object2.put("durationInMonths", course2.getDurationInMonths());
object2.put("eligibilityCriteria", course2.getEligibilityCriteria());
array2.put(object2);
}
object.put("Course", array2);
array.put(object);
}
tx.rollback();
session.close();
response.sendRedirect("index.jsp");
%>

</body>
</html>