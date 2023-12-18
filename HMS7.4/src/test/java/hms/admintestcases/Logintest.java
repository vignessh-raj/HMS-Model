package hms.admintestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;

public class Logintest extends Testbase{
	
	Loginpage objlog;
	
	public Logintest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initlization();
		objlog=new Loginpage();
	}
	
	@Test
	public void hmsadminlogintest()
	{
		String expectedpagetitle="Smart Hospital : Hospital Management System";
		String actualtitle=objlog.togetpagetite();
		Assert.assertEquals(actualtitle, expectedpagetitle);
		
		Assert.assertTrue(objlog.islogodisplayed());
		
		String expectedscreentitle="Admin Login";
		String actualscreentitle=objlog.getscreentitle();
		Assert.assertEquals(actualscreentitle, expectedscreentitle);
		
		
		objlog.adminlogin(prop.getProperty("username"), prop.getProperty("password"));
		
		objlog.logout();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
