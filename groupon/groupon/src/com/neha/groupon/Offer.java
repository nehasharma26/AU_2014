package com.neha.groupon;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

/**
 * Servlet implementation class order
 */
@WebServlet("/offer")
public class Offer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Offer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
	    PrintWriter out = response.getWriter();

	    try {
	        JSONObject jObj = new JSONObject(request.getParameter("offer_data"));
	        DBConnect conn = new DBConnect("jdbc:mysql://localhost:3306/groupon", "root","");
	        Iterator<String> it = jObj.keys(); 
	        if(jObj.has("add_offer")){
	        	int numPeople,price;
	        	String name = null,description = null,image = null,startDate=null,endDate = null,category=null,pusername=null;
	        	while(it.hasNext())

		        {

		            String key = (String) it.next(); 

		            if(key.equals("name"))
		                name = (String)jObj.get(key);
		            else if(key.equals("description"))
		               description=(String)jObj.get(key);
		            else if(key.equals("numPeople"))
			               numPeople=(Integer) jObj.get(key);
		            else if(key.equals("image"))
			               image=(String)jObj.get(key);
		            else if(key.equals("startDate"))
		            	startDate=(String)jObj.get(key);
		            else if(key.equals("endDate"))
		            	endDate=(String)jObj.get(key);
		            else if(key.equals("price"))
			               price=(Integer) jObj.get(key);
		            else if(key.equals("pusername"))
		            	pusername=(String) jObj.get(key);
		            else if(key.equals("category"))
		            	category=(String) jObj.get(key);



		        }

	        	Statement st = conn.getConnection().createStatement(); 
	        	int result= st.executeUpdate("insert into offer values(name='"+name+"',description='"+description+"',numPeople=numPeople,image='"+image+"',startDate='"+startDate+"',endDate='"+endDate+"',category='"+category+"',price=price,username='"+pusername+"')");
	             if(result==0)
	          	   out.write("Order added successfully");
	            else
	        	out.write("");

	        }

	        else if(jObj.has("viewoffer")){
	        	String name=null,pusername=null;
	        	Statement st = conn.getConnection().createStatement(); 
	        	ResultSet rs=st.executeQuery("select * from offer where numPeople_remain >0 and endDate>CURDATE()");
	        	List<Map<String,String>> Result=new ArrayList<Map<String,String>>();
	        	Map<String,String> set;
	        	while(rs.next()){
	       		set=new HashMap<String,String>();
	        		set.put("name",rs.getString("name"));
	        		set.put("description",rs.getString("description"));
	        		set.put("numPeople_remain",rs.getString("numPeople"));
	        		set.put("startDate",rs.getString("startDate"));
	        		set.put("endDate",rs.getString("endDate"));
	        		set.put("image",rs.getString("image"));
	        		set.put("price",rs.getString("price"));
	        		set.put("category",rs.getString("category"));
	        		Result.add(set);
	        		}
	        	 Gson gson = new Gson();

	        	String json= gson.toJson(Result);

	            response.getWriter().write(json);
	        }
	        else if(jObj.has("viewofferCorporate")){

	        	String name=null,pusername=null;
	        	while(it.hasNext())

		        {

		            String key = (String) it.next(); // get key

		            if(key.equals("name"))
		                name = (String)jObj.get(key);
		            if(key.equals("username")) 	
		                pusername = (String)jObj.get(key);
	        }		
	        	Statement st = conn.getConnection().createStatement(); 
	        	ResultSet rs=st.executeQuery("select * from offer where username='"+pusername+"'");
	        	List<Map<String,String>> Result=new ArrayList<Map<String,String>>();
	        	Map<String,String> set;
	        	while(rs.next()){
	        		set=new HashMap<String,String>();
	        		set.put("name",rs.getString("name"));
	        		set.put("description",rs.getString("description"));
	        		set.put("numPeople",rs.getString("numPeople"));
	        		set.put("startDate",rs.getString("startDate"));
	        		set.put("endDate",rs.getString("endDate"));
	        		set.put("image",rs.getString("image"));
	        		set.put("price",rs.getString("price"));
	        		set.put("category",rs.getString("category"));
	        		Result.add(set);
	        		}
	        	 Gson gson = new Gson();

	        	String json= gson.toJson(Result);

	            response.getWriter().write(json);
	        }
	        else if(jObj.has("deleteoffer")){
	        	String name=null, pusername=null;
	        	while(it.hasNext())

		        {

		            String key = (String) it.next(); // get key

		            if(key.equals("name"))
		                name = (String)jObj.get(key);

		            else if(key.equals("username"))
		                pusername = (String)jObj.get(key);
		            }
	        	Statement st = conn.getConnection().createStatement();
	        	st.executeUpdate("delete from offer where name='"+name+"' and username='"+pusername+"'");

	        }
	        else if(jObj.has("createoffer")){
	        	String offername=null,usedate=null;
	        	int numppl=0;

	        	String username = null;
				while(it.hasNext())

		        {

		            String key = (String) it.next(); // get key

		            if(key.equals("username"))
		               username = (String)jObj.get(key);
		            else if(key.equals("ordername"))
		               offername=(String)jObj.get(key);
		            else if(key.equals("numppl"))
			               numppl=(Integer) jObj.get(key);
		            else if(key.equals("usedate"))
			               usedate=(String)jObj.get(key);
		        }

	        	 Statement st = conn.getConnection().createStatement(); 

	             int result= st.executeUpdate("insert into order_booked values('"+username+"','"+offername+"', '"+numppl+"','"+usedate+"')");
	             if(result==0)

	          	   out.write("Enrolled successfully");
	            else
	        	out.write("Oops! something went wrong! try again later.");

	            st.executeUpdate("update offer set remPeople=numPeople-'"+numppl+"'");

	    }
	    }

	    catch(Exception e){
	    e.printStackTrace();	
	    }
	    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		}

}