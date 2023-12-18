package hms.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import hms.base.Testbase;

public class Commonutility extends Testbase{
	
	//mouse movenment and click
	public static void mouseclick(WebElement el)
	{
		Actions act=new Actions(driver);
		act.moveToElement(el).click().build().perform();
	}

	
	//Robot upload
	public static void robotupload(String loc)
	{
        StringSelection sel=new StringSelection(loc);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		
		Robot rb;
		try {
			rb = new Robot();
			Thread.sleep(2000);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			
			
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
//Screen shot on fails
	public static void screenshots()
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"./Screenshot/"+System.currentTimeMillis()+".png");
		
		try {
			FileHandler.copy(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
