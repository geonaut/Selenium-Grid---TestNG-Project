package testNG.parallel;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
 
public class GoogleTest2 extends TestBase{
	
	//private WebDriver driver;
	private String baseUrl;
	 
	  @Test(dataProvider = "myTest")
	  public void testSearchCountry(String country) throws Exception {
		baseUrl = "http://www.wikipedia.org/";
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    getDriver().get(baseUrl + "/wiki/Main_Page");
	    getDriver().findElement(By.id("searchInput")).clear();
	    getDriver().findElement(By.id("searchInput")).sendKeys(country);
	    getDriver().findElement(By.id("searchButton")).click();
	    String str = getDriver().findElement(By.cssSelector("span")).getText();
	    Assert.assertTrue(country.equals(str.trim()));
	  }
	 
	  @AfterMethod
	  public void tearDown() throws Exception {
		  getDriver().quit();   
	  } 
	}