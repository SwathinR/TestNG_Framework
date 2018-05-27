package TestNG.framework;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import TestNG.tests.BaseTest;

public class CommonFunctions extends BaseTest{


	static WebElement element;
	static String SSPath;

	public static void click(By ElementLocator){
		driver.findElement(ElementLocator).click();
	}

	public static void elementIsPresent(By ElementLocator) {
		Wait<WebDriver> wait= new WebDriverWait(driver,20).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(ElementLocator));
	}

	public void waitForPageToLoad() 
	{
		ExpectedCondition<Boolean> expect =  null;
		Wait<WebDriver> wait = new WebDriverWait(driver, Integer.parseInt(System.getProperty("test.pageLoadTimeout"))).ignoring(StaleElementReferenceException.class);
		//Condition to check page load complete
		expect = new ExpectedCondition<Boolean>(){ public Boolean apply(WebDriver dr)
		{
			return  ((JavascriptExecutor)dr).executeScript("return document.readyState").equals("complete");
		}
		};
		wait.until(expect);
	}

	public static void sendKeys(By ElementLocator, String text){
		try{
			driver.findElement(ElementLocator).sendKeys(text);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String takeScreenshot(WebDriver driver){
		try{
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			Calendar cal = Calendar.getInstance();
			String currentTime= dateFormat.format(cal.getTime());
			File SSFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String SSPath =System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+".jpg";
			FileUtils.copyFile(SSFile,new File(SSPath));
			return  SSPath;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
