package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;

public class Loginpage extends Testbase {
	
	@FindBy(css="img[src='http://triotend.com/tts/backend/images/s_logo.png']")
	WebElement logo;
	@FindBy(css="h3.font-white")WebElement screentitle;
	@FindBy(css="input#email")WebElement username;
	@FindBy(css="input#password")WebElement password;
	@FindBy(css="button.btn")WebElement signin;
	@FindBy(css="img.topuser-image")WebElement profile;
	@FindBy(css="div.sspass>a:nth-child(3)")WebElement logout;
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//To getpage Title
	public String togetpagetite()
	{
		return driver.getTitle();
		
	}
	
	//check logo
	public boolean islogodisplayed()
	{
		return logo.isDisplayed();
		
	}

	public String getscreentitle()
	{
		return screentitle.getText();
		
	}
	
	
	public void adminlogin(String uname,String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		signin.click();
	}
	
	public void logout()
	{
		profile.click();
		logout.click();
	}
}
