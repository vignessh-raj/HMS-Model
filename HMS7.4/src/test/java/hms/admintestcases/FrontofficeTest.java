package hms.admintestcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Frontofficepage;
import hms.pages.Loginpage;

public class FrontofficeTest extends Testbase{
	
	Loginpage objlog;
	Frontofficepage objfo;
	
	public FrontofficeTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initlization();
		objlog =new Loginpage();
		objlog.adminlogin(prop.getProperty("username"), prop.getProperty("password"));
		objfo=new Frontofficepage();
	}
	
	@Test
	public void frontofficetest()
	{
		objfo.clickfomenu();
		String expectedtabletitle="Appointment Details";
		String actualtabletitle=objfo.gettabletitle();
		Assert.assertEquals(actualtabletitle, expectedtabletitle);
		
		objfo.clickonvistorbook();
	}
	
}
