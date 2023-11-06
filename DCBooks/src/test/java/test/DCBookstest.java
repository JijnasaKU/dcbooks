package test;

import org.testng.annotations.Test;

import Base.baseclass;
import page.homePage;
import page.registrationPage;


public class DCBookstest extends baseclass
{
	@Test()
	public void test1() throws Exception
	{  
		registrationPage rep=new registrationPage(driver);
	    rep.signUpClick("manu", "viswanath", "manu@gmail.com", "9656086554", "manu@1995");
	    //rep.copyAndPastePwd();
	}
	@Test()
	public void test2()
	{
		homePage hp=new homePage(driver);
		hp.verifyTitle();
		hp.verifyLogo();
		hp.searchBook("SAPHALAMEEYATHRA");
		hp.addToCart();
		hp.verifyDropDown();
		hp.linkValidation();
	}
	
}
