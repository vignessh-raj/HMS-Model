package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Commonutility;
import hms.utility.Datepicker;

public class Vistorpage extends Testbase
{
	@FindBy(css="h3.box-title")WebElement tabletxt;
	@FindBy(css="div.box-tools>a")WebElement addvistor;
	@FindBy(xpath="//h4[text()=' Add Visitor']")WebElement screentitle;
	
	@FindBy(css="form#formadd select[name='purpose']")WebElement purpose;
	@FindBy(css="form#formadd input[name='name']")WebElement pname;
	@FindBy(css="form#formadd input[name='contact']")WebElement phno;
	@FindBy(css="form#formadd input[name='id_proof']")WebElement idpro;
	@FindBy(css="form#formadd input[name='pepples']")WebElement noper;
	@FindBy(css="form#formadd input[name='date']")WebElement datepicker;
	@FindBy(css="form#formadd textarea[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='file']")WebElement upfile;
	
	@FindBy(css="//*[@id=\"myModal\"]")WebElement cls;
	
	
	public Vistorpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String gettabletitle()
	{
		return tabletxt.getText();
	}
	
	public void clickonaddvistor()
	{
		addvistor.click();
	}
	
	public String getscreentitle()
	{
		wbwait(screentitle);
		return screentitle.getText();
		
	}
	
	
	public void addvistorvistordetails(String dat[])
	{
		Select drp=new Select(purpose);
		drp.selectByVisibleText(dat[0]);
		pname.sendKeys(dat[1]);
		phno.sendKeys(dat[2]);
		idpro.sendKeys(dat[3]);
		noper.sendKeys(dat[5]);
		datepicker.click();
		Datepicker dt=new Datepicker();
		dt.datpicker(dat[4]);
		note.sendKeys(dat[6]);
		
		Commonutility.mouseclick(upfile);
		
		Commonutility.robotupload(dat[7]);
		
		cls.click();
	}
	
	
}
