package TestNG.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

   /* @BeforeClass
    public void setup () {
    	
    	if(System.getProperty("test.browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/java/TestNG/Resources/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Running tests on Chrome Browser");
		}else if(System.getProperty("test.browser").equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/java/TestNG/Resources/geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Running tests on Firefox Browser");
		}
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("test.implicitWait")), TimeUnit.SECONDS);
        //Create a wait. All test classes use this.

        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }*/

}
