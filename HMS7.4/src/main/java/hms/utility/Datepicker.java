package hms.utility;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import hms.base.Testbase;




public class Datepicker extends Testbase{
	
	 WebElement dateWidget;
	 List<WebElement> month;
	
	 List<WebElement> dates;
	 static List<String> monthlist = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
	 

public void datpicker( String expdate)//7/5/2025
{
	String ddmmyyyy[]=expdate.split("/");
	 String expDate=ddmmyyyy[0];
	 int expMonth=Integer.parseInt(ddmmyyyy[1]);
	 int expYear=Integer.parseInt(ddmmyyyy[2]);
	
// Calendar Month and Year
     boolean dateNotFound=true;
//WebElements of date picker
	 driver.findElement(By.className("datepicker-switch")).click();
	 
		
//while loop to check the month and year
	    while(dateNotFound)
	    {
	        //getting date picker year
		    WebElement picyear= driver.findElement(By.cssSelector("div.datepicker-months>table.table.table-condensed>thead>tr>th.datepicker-switch"));
		   String calYear = picyear.getText();
	     
		   if(Integer.parseInt(calYear)==expYear)
		    {
			  selectmonth(driver,expMonth);
			  selectdat( driver,expDate);
			   dateNotFound=false;
		     }
		 
		    else if(Integer.parseInt(calYear)<expYear)
		    {
			 //clicking on the right arrow
			 driver.findElement(By.cssSelector("div.datepicker-months>table.table.table-condensed>thead>tr>th.next")).click();
		    }
		 
		    else if(Integer.parseInt(calYear)>expYear)
		    {
			 //clicking on the left arrow
			 driver.findElement(By.cssSelector("div.datepicker-months>table.table.table-condensed>thead>tr>th.prev")).click();
		    }	 
			 
	     }
}
//method to select the month	
       public void selectmonth(WebDriver driver,int Month)
       {
    	 month= driver.findElements(By.cssSelector("span.month"));
    	 
	     for (WebElement mon : month) 
	       {
	    	   String calmon=mon.getText();
	    	   String expmon=monthlist.get(Month-1);
               if(calmon.equals(expmon))
                 {
            	    mon.click();
            	     
            	     break;
                 }           
			
		    }
	  
	     
        }
       
//method select date
       public void selectdat(WebDriver driver,String dt)
       {
    	  
    	  dateWidget =driver.findElement(By.cssSelector("div.datepicker-days"));
    	  
    	  dates=dateWidget.findElements(By.xpath("//td[@class='old day']/following::td[@class='day']"));
    	 //dates=dateWidget.findElements(By.cssSelector("td.day"));
    	  
    	  
    	 for (WebElement eldat : dates) {
    		//System.out.println(eldat.getText());
			
			  if(eldat.getText().equals(dt))
			  { 
				  eldat.click(); 
				  break;
			   }
			 
			
		}
       
       }      
       
       
     
}