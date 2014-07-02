package testNG.parallel;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
 
public class TestBase {
		 
	    protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	    
	    @BeforeMethod
	    public void setUp() throws MalformedURLException {
	 
	        threadDriver = new ThreadLocal<RemoteWebDriver>();
	        
	        DesiredCapabilities dc = new DesiredCapabilities();
	        
	        //Uncomment following line for IE
	        //dc.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
	        
	        //Uncomment following 3 lines for FF
	        FirefoxProfile fp = new FirefoxProfile();
	        dc.setCapability(FirefoxDriver.PROFILE, fp);
	        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
	        
	        //Uncomment following line for Chrome
	        //dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
	        
	       threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
	    }
 
    public WebDriver getDriver() {
        return threadDriver.get();
    }
 
    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
    }
}