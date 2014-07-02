package testNG.parallel;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
 
public class GoogleTest1 extends TestBase{
	
	private String baseUrl;
 
    @Test(groups = { "group4"})
    public void testLink()throws Exception{
    	GenerateData genData = new GenerateData();
	  	baseUrl = "http://www.wikipedia.org/";
	  	getDriver().get(baseUrl + "/wiki/Main_Page");
	  	Thread.sleep(3000);
	  	getDriver().findElement(By.id("searchInput")).clear(); 
	  	Thread.sleep(3000);
	  	getDriver().findElement(By.id("searchInput")).sendKeys(genData.generateRandomString(12));
	  	getDriver().findElement(By.id("searchButton")).click();
    }
 
}