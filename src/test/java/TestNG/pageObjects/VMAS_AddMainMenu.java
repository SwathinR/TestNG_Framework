package TestNG.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VMAS_AddMainMenu extends BasePage {

	WebDriver driver;

	//*******Constructor***********
	public VMAS_AddMainMenu(WebDriver driver) {
        super(driver);
    }


	public By MainMenuName = By.id("menuNameId");
	public By Description = By.id("descId");
	public By Displayorder = By.id("displayOrder");
	public By SelectMenuIcon = By.id("menuImage_title");
	public By MenuIcondropdown=By.xpath(".//*[@id='menuImage_child']/ul/li[11]/span");
	public By SelectSectionImage = By.id("sectionImage_title");
	public By SectionImagedropdown=By.xpath(".//*[@id='sectionImage_child']/ul/li[5]/span");
	public By SelectBannerImage = By.id("bannerImage_title");
	public By BannerImagedropdown=By.xpath("//*[@id='bannerImage_child']/ul/li[4]/span");
	public By SaveButton = By.id("Save_Menu");
	//public By Edit_BasedonMenuName = By.xpath("//tr/..//td[contains(text(),'"+System.getProperty("MenuName")+"')]/..//a/img[@src='images/edit.jpg']");
	//public By Delete_BasedonMenuName = By.xpath("//tr/..//td[contains(text(),'"+System.getProperty("MenuName")+"')]/..//a/img[@src='images/delete.jpg']");

}
