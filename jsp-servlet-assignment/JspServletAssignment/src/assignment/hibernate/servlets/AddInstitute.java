package assignment.hibernate.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment.hibernate.enteties.Institute;
import assignment.hibernate.enteties.ManageInstitute;
/**
 * Servlet implementation class instituteadd
 */
@WebServlet("/addInstitute")
public class AddInstitute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
     public AddInstitute() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json");
	    PrintWriter out = response.getWriter();

	    try {
	        String title=request.getParameter("Title");
	       // System.out.println(title);
	        String description=request.getParameter("Description");
	        String location=request.getParameter("Location");
	        String branches=request.getParameter("Branches");
	        String image=request.getParameter("Image");	     
	        String courses=request.getParameter("Courses");
	        ManageInstitute instDetail = new ManageInstitute();
	       Institute insti = new Institute(title,description,location,branches, image,courses);
	        instDetail.addInstitute(insti);
	       // instDetail.deleteInstitute(1);
	      //  System.out.println("inst details"+instDetail.getinstitute(1).getTitle());
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
