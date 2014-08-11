package assignment.hibernate.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import assignment.hibernate.enteties.Course;
import assignment.hibernate.enteties.ManageCourse;
/**
 * Servlet implementation class instituteadd
 */
@WebServlet("/addCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
     public AddCourse() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json");
	    PrintWriter out = response.getWriter();

	    try {
	        String name=request.getParameter("Name");
	        String description=request.getParameter("Description");
	        int duration=Integer.parseInt(request.getParameter("Duration"));  
	        String admissionProcess=request.getParameter("AdmissionProcess");
	        String eligibilityCriteria=request.getParameter("EligibilityCriteria");
	        ManageCourse courseDetail = new ManageCourse();
	       Course course = new Course(name,description,duration,admissionProcess,eligibilityCriteria);
	        courseDetail.addCourse(course);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	    	response.sendRedirect("index.jsp");
	        out.flush();
	        out.close();
	    }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
