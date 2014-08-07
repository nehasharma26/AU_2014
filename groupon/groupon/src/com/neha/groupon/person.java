package com.neha.groupon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class user_details
 */
@WebServlet(name = "person", urlPatterns = { "/person" })
public class person extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public person() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(request.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		String line = in.readLine();
		response.setContentType("application/json");
	    PrintWriter out = response.getWriter();

	    try {
	        String username =null,password=null, type=null ,address=null;
	        JSONObject jObj = new JSONObject(request.getParameter("user_data"));
	        DBConnect conn = new DBConnect("jdbc:mysql://localhost:3306/groupon", "root","");
	        Iterator<String> it = jObj.keys(); //gets all the keys
	        if(jObj.has("login"))
	        {
	        //the code to check if the login  is correct	
	        	while(it.hasNext())

		        {

		            String key = (String) it.next(); // get key

		            if(key.equals("username"))
		               username = (String)jObj.get(key);
		            else if(key.equals("password"))
		               password=(String)jObj.get(key);
		        }

	        	 Statement st = conn.getConnection().createStatement(); 
	             ResultSet result= st.executeQuery("select * from preson where username='"+username+"' and password='"+password+"')");
	             if(result.next())
	          	   out.write("Login Successful");
	            else{
	        	out.write("Username and Password doesnt match");

	        }
	        }
	     else if(jObj.has("register")){
	        while(it.hasNext())

	        {

	            String key = (String) it.next(); // get key

	            if(key.equals("username"))
	               username = (String)jObj.get(key);
	            else if(key.equals("password"))
	               password=(String)jObj.get(key);
	            else if(key.equals("type"))
		               type=(String)jObj.get(key);
	            else if(key.equals("address"))
		               address=(String)jObj.get(key);

	        }
           
            
            Statement st = conn.getConnection().createStatement(); 
           int result= st.executeUpdate ("insert into person values('"+username+"','"+password+"','"+type+"','"+address+"')");
           if(result==1)
        	   out.write("Registered successfully!");
            
	        }
	    }
            catch(Exception e){
            	e.printStackTrace();
            }



}
	}
