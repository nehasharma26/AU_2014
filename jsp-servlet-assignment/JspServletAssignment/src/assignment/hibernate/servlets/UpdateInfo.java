package assignment.hibernate.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

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
@WebServlet("/updateInfo")
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ManageInstitute.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
     public UpdateInfo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json");
	    PrintWriter out = response.getWriter();

	    try {
	    	int id=Integer.parseInt(request.getParameter("id"));
	        String title=request.getParameter("Title");
	       // System.out.println(title);
	        String description=request.getParameter("Description");
	        String location=request.getParameter("Location");
	        String branches=request.getParameter("Branches");
	        String image=request.getParameter("Image");	     
	        String courses=request.getParameter("Courses");
	        ManageInstitute instDetail = new ManageInstitute();
	        instDetail.deleteInstitute(Integer.parseInt(request.getParameter("id")));
	       Institute insti = new Institute(title,description,location,branches, image,courses);
	        instDetail.addInstitute(insti);
	       // instDetail.deleteInstitute(1);
	      //  System.out.println("inst details"+instDetail.getinstitute(1).getTitle());
	    } catch (Exception ex) {
	    	logger.info("caught exception "+ex);
	        ex.printStackTrace();
	    } finally {
	    	//response.sendRedirect("index.jsp");
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
