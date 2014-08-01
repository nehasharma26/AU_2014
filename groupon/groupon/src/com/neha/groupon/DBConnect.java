package com.neha.groupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 

public class DBConnect {

	   private Connection connection;

	    public DBConnect(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException{
	        Class.forName("com.mysql.jdbc.Driver");
	        this.connection = DriverManager.getConnection(dbURL, user, pwd);
	    }

	    public Connection getConnection(){
	        return this.connection;
	    }
	}