package page;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class homePage 
{
WebDriver driver;
@FindBy(name="search")
WebElement search;
@FindBy(xpath="//*[contains(text(),' VIEW DETAILS')]")
WebElement viewBtn;
@FindBy(xpath="*//button[@class='searchbut']")
WebElement searchBtn;
@FindBy(xpath="//*[@id=\"AddCartForm\"]/div[2]/div[3]/div/div/div[3]/div[1]/img")
WebElement aToCart;
@FindBy(xpath="//*[contains(@href,'https://dcbookstore.com/carts/myshoppingcart')]")
WebElement cart;
@FindBy(name="quantity")
WebElement quantity;
@FindBy(xpath="//*[contains(text(),'MY CART')]")
WebElement myCart;
@FindBy(name="allcategory")
WebElement dropDown;
@FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div/div/div[1]/a/img")
WebElement logo;
public homePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void verifyTitle()
{
	String actualTitle=driver.getTitle();
	String expTitle="Buy Malayalam Books – Latest Malayalam Books online India, Kerala";
    Assert.assertEquals(actualTitle, expTitle);
}
public void verifyLogo()
{
	boolean pic=logo.isDisplayed();
	Assert.assertTrue(pic);
}
public void searchBook(String Bname)
{
	search.sendKeys(Bname);
	searchBtn.click();
	viewBtn.click();
	
	String pw=driver.getWindowHandle();
	Set <String>allWindow=driver.getWindowHandles();
	for(String handle:allWindow)
	{
		if(!handle.equalsIgnoreCase(pw))
		{
			driver.switchTo().window(handle);
			aToCart.click();
			String text=driver.getPageSource();
			if(text.contains(" In Stock"))
			{
				System.out.println("Book is available");
			}
			else
			{
				System.out.println("book is not available");
			}
			
		}
	}
}
public void addToCart()
{
	cart.click();
	String c=driver.getPageSource();
	if(c.contains("SAPHALAMEEYATHRA"))
	{
		System.out.println("Successfully added to cart");
	}
	else
	{
		System.out.println("Item is not added to cart");
	}
	Actions a=new Actions(driver);
	a.moveToElement(quantity).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
	quantity.sendKeys("2");
	myCart.click();
	System.out.println("Successfully changed the number of items in the cart");
}
public void verifyDropDown()
{
	dropDown.click();
	Select s=new Select(dropDown);
	s.selectByIndex(4);
	searchBtn.click();
	System.out.println("DropDown work successfully");
}
public void linkValidation()
{
	List<WebElement>li= driver.findElements(By.tagName("a"));
	System.out.println("Total links:"+li.size());
	for(WebElement element:li)
	{
		String link=element.getAttribute("href");
		verify(link);
	}
}
public void verify(String link) 

{
	
try{
 
	URL u=new URL(link);
	HttpURLConnection con=(HttpURLConnection)u.openConnection();
	con.connect();
	if(con.getResponseCode()==404)
	{
		System.out.println("Brokenlink"+link);
	}
	
}
catch(Exception e)
{
	System.out.println(e.getMessage());
}
	
}

}
