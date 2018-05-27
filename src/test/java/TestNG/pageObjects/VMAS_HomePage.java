package TestNG.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import TestNG.framework.CommonFunctions;

public class VMAS_HomePage extends BasePage {

	//**************Constructor******************
	public VMAS_HomePage(WebDriver driver) {
        super(driver);
    }
	
	By VMAS_Logout = By.xpath("//a[contains(text(),'Log Out')]");
	By VMAS_UserProfile = By.xpath("//a[contains(text(),'User Profile')]");
	By VMAS_WelcomeMessage = By.xpath("//div[@class='firstName']");
	
	//Main Menus 
	By VMAS_MainMenus_MyVMAS = By.xpath("//a[@title='My VMAS']");
	By VMAS_MainMenus_DTTechNew = By.xpath("//a[@title='DT Tech News']");
	By VMAS_MainMenus_VMASLibrary = By.xpath("//a[@title='VMAS Library']");
	By VMAS_MainMenus_Feedback = By.xpath("//a[@title='Feedback']");
	By VMAS_MainMenus_AboutVMAS = By.xpath("//a[@title='About VMAS']");
	
	//Menus Under About VMAS
	By AboutVMAS_AdminManagement = By.xpath("//a/..//span[contains(text(),'Admin Management')]");
	
	public void verifyPresenceOfHomePageElements(){
		CommonFunctions.elementIsPresent(VMAS_Logout);
		//CommonFunctions.elementIsPresent(VMAS_UserProfile);
		//CommonFunctions.elementIsPresent(VMAS_WelcomeMessage);
	}
	public void goToAdminMgmtPage(){
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(VMAS_MainMenus_AboutVMAS)).build().perform();
		driver.findElement(AboutVMAS_AdminManagement).click();
	}
}
