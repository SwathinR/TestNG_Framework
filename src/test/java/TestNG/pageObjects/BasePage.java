package TestNG.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;

    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    //Click Method
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void sendKeys (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String getText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
}
