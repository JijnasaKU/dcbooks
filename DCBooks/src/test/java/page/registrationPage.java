package page;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registrationPage
{
WebDriver driver;
@FindBy(xpath ="//*[contains(text(),'Sign Up')]")
WebElement signup;
@FindBy(name="firstname")
WebElement fName;
@FindBy(name="lastname")
WebElement LName;
@FindBy(id="email")
WebElement eMail;
@FindBy(id="phone")
WebElement Phone;
@FindBy(xpath="//*[contains(text(),' Female')]")
WebElement gender;
@FindBy(name="password")
WebElement pwd;
@FindBy(name="re_password")
WebElement Rpwd;
@FindBy(xpath="//*[@id=\"email\"]")
WebElement userName;
@FindBy(xpath="//*[@id=\"password\"]")
WebElement Lpwd;
@FindBy(xpath="//*[@id=\"Loginform\"]/div[2]/div[4]/div[1]/input")
WebElement login;
@FindBy(xpath="//*[@id=\"register-form\"]/div[4]/div[2]/div[1]/input")
WebElement submitBtn ;
@FindBy(xpath="/html/body/div[2]/div[1]/div[3]/div/div/div[1]/a/img")
WebElement logo;
public registrationPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void copyAndPastePwd() throws IOException
{
	Actions act=new Actions(driver);
		act.keyDown(pwd,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(pwd,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(Rpwd,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		act.perform();
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	org.openqa.selenium.io.FileHandler.copy(src, new File("C:\\Users\\vivu4\\OneDrive\\Desktop\\software testing\\DCbooks\\error1.png"));
}

public void signUpClick(String Fn,String Ln,String Em,String Pn,String pass)
{
	signup.click();
	fName.sendKeys(Fn);
	LName.sendKeys(Ln);
	eMail.sendKeys(Em);
	Phone.sendKeys(Pn);
	gender.click();
	pwd.sendKeys(pass);
	Rpwd.sendKeys(pass);
	submitBtn.click();
	userName.sendKeys(Em);
	Lpwd.sendKeys(pass);
	login.click();
}

}

