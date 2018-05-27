package TestNG.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VMAS_AdminManagement extends BasePage {

	
	//***************Constructor************************
	public VMAS_AdminManagement(WebDriver driver) {
        super(driver);
    }
	
	
	By AdminManagement_AddSubMenu = By.xpath("//h5[contains(text(),'Add Sub Menu')]");
	By AdminManagement_AddMainMenu = By.xpath("//h5[contains(text(),'Add Main Menu')]"); 
	
	
	
	public void Click_AddSubMenu(){
		driver.findElement(AdminManagement_AddSubMenu).click();
	}
	
	public void Click_AddMainMenu(){
		driver.findElement(AdminManagement_AddMainMenu).click();
	}
}
