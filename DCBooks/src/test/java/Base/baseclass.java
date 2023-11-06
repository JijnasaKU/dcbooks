package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class baseclass 
{
public WebDriver driver;
@BeforeTest
public void setUp()
{
	driver=new ChromeDriver();
	driver.get("https://dcbookstore.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
//public void tearDown()
//{
	//driver.quit();
//}
}
