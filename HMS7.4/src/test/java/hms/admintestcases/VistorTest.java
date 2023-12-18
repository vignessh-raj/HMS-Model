package hms.admintestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Frontofficepage;
import hms.pages.Loginpage;
import hms.pages.Vistorpage;
import hms.utility.ReadExcel;

public class VistorTest extends Testbase {
	
	Loginpage objlog;
	Frontofficepage objfo;
	Vistorpage objvis;
	
	public VistorTest()
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
		objfo.clickfomenu();
		objfo.clickonvistorbook();
		objvis=new Vistorpage();
	}
	
	@DataProvider
	public Object[][] getvisdata()
	{
		Object[][] data=ReadExcel.getTestData("testdata");
		
		return data;
		
	}


	@Test(dataProvider = "getvisdata")
	public void addvistordetails(String vistor[])
	{
		String expectedtabletitle="Visitor List";
		String actualtabletitle=objvis.gettabletitle();
		Assert.assertEquals(actualtabletitle, expectedtabletitle);
		objvis.clickonaddvistor();
		
		String Expectedscreentitle="Add Visitor";
		String actualscreentitle=objvis.getscreentitle();
		Assert.assertEquals(actualscreentitle, Expectedscreentitle);
		
		objvis.addvistorvistordetails(vistor);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
}
