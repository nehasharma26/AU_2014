package com.NehaAssignment2.app;
/*
*AU.java creates an application to give
*a date by subracting specific number of dates 
*from the current date.
*
* @author Neha Sharma
* @dated 2014-07-08
*
*/

import java.text.*;
import java.util.*;


public class AU {

  // A static funtion to take an integer as input and then return a date which is done by subtracting number of days specified by the input parameter from current date 
  public static String getDate(int no_days)
  {
 
      Calendar now = Calendar.getInstance();

      //SimpleDateFormat returns calculated result in yyyy-MM-dd format.
      SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

      //Calender.add() is used to subtract the days from current date by specificing negative sign behind second parameter i.e. number of days to be subtracted from current date.
      now.add(Calendar.DATE, -no_days);
      Date date=null;
      date=now.getTime();
      String date1 = format1.format(date);   
      return date1;
  }

  public static void main(String[] args) 
  {
     //numOfDays is used to store the number of days to be subtracted from current date
     //instance of Scanner class is created with input stream to take the input from user
     int numOfDays;
     Scanner sc=new Scanner(System.in);
     numOfDays=sc.nextInt();
     System.out.println(getDate(numOfDays));
   
  }
}