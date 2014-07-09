package com.NehaAssignment2.app;
 
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Date;
import org.apache.commons.lang3.StringUtils.*;
 

/**
 *
 *Test for the app AU.java
 *It gives a date which is specific number of dates 
 *before current date
 *
 */

public class AUTest
extends TestCase
{
/** 
 * create test case
 *
 * @param testName :Name of the test case
 *
 */
public AUTest( String testName )
{
super( testName );
}
 
/**
 *
 *@return the suite of tests being tested
 *
 */
public static Test suite()
{
return new TestSuite( AUTest.class );
}
 
/**
  * Rigourous Test
  */
public void testApp()
{
assertTrue( true );
}
 
 
// A test case that will fail was added to see how it affects when packaging is done.
/*public void testApp1()
  {
  assertTrue( false );
  }*/
 
 
public void testApp1()
{
assert(org.apache.commons.lang3.StringUtils.isNotBlank(new Date().toString()));
}
 
}