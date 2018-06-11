package TestNG.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestNG.framework.CommonFunctions;
import TestNG.framework.DataFilesReader;
import TestNG.pageObjects.VMAS_AddMainMenu;
import TestNG.pageObjects.VMAS_AddSubMenu;
import TestNG.pageObjects.VMAS_AdminManagement;
import TestNG.pageObjects.VMAS_HomePage;
import TestNG.pageObjects.VMAS_LoginPage;

public class VMAS_RegressionSuite1_Test extends BaseTest{

	//@Test(priority=0,enabled=true)
	public void Test1_Verify_Invalid_LoginCredentials_ErrorMessage()throws Exception{

		VMAS_LoginPage loginPage = new VMAS_LoginPage(driver);
		loginPage.GotoVMAS();		
		String errorMsg = loginPage.SignIn_ErrorCheck();
		Assert.assertEquals(errorMsg, "User cannot be authenticated.\n" + 
				"Check account status.","Expected message does not match actual message");
	}
	
	//@DataProvider(name="credentials")
	public static Object[][] dp2()throws Exception{
		Object[][] data = DataFilesReader.ReadExcelSpreadSheet(System.getProperty("user.dir")+"/src/test/java/TestNG/testDataFiles/Excelread.xlsx", "Credentials");
		return data;
	}


	//@Test(priority=1,enabled=true,dataProvider="credentials")
	public void Test2_Verify_Successful_Login_to_VMASApp(String UserName, String Password)throws Exception{
		VMAS_LoginPage loginPage = new VMAS_LoginPage(driver);
		VMAS_HomePage homePage = new VMAS_HomePage(driver);
		loginPage.SignIntoVMAS(UserName,Password);
		//Assertion statement below to verify presence of home page element to verify user is successfully navigated to home page
		homePage.verifyPresenceOfHomePageElements();
	}

	//@Test(priority=2,enabled=false)
	public void Test3_Verify_AddSubMenu() throws Exception{
		VMAS_HomePage homePage = new VMAS_HomePage(driver);
		VMAS_AdminManagement adminMgmtPage = new VMAS_AdminManagement(driver); 
		VMAS_AddSubMenu AddSubMenuPage = new VMAS_AddSubMenu (driver);			

		homePage.goToAdminMgmtPage();

		adminMgmtPage.Click_AddSubMenu();
		System.setProperty("MenuName", "Test_Automation");
		CommonFunctions.sendKeys(AddSubMenuPage.SubMenuName,System.getProperty("MenuName"));
		CommonFunctions.sendKeys(AddSubMenuPage.Description,"TestTEst");
		CommonFunctions.sendKeys(AddSubMenuPage.MainMenu,"Device Analytics");
		CommonFunctions.sendKeys(AddSubMenuPage.IsDirectTitle,"No");
		Thread.sleep(3000);
		CommonFunctions.click(AddSubMenuPage.SelectSubMenuIcon);
		Thread.sleep(3000);
		CommonFunctions.click(AddSubMenuPage.SubMenuIcondropdown);
		CommonFunctions.click(AddSubMenuPage.SelectSectionImage);
		Thread.sleep(3000);
		CommonFunctions.click(AddSubMenuPage.SectionImagedropdown);
		CommonFunctions.click(AddSubMenuPage.SelectBannerImage);
		Thread.sleep(3000);
		CommonFunctions.click(AddSubMenuPage.BannerImagedropdown);
		Thread.sleep(3000);
		CommonFunctions.click(AddSubMenuPage.SaveButton);
		Thread.sleep(10000);
		System.out.println("Sub Menu Created Successfully");

		driver.findElement(By.xpath("//tr/..//td[contains(text(),'"+System.getProperty("MenuName")+"')]/..//a/img[@src='images/edit.jpg']")).click();
		Thread.sleep(20000);
		driver.findElement(AddSubMenuPage.Description).clear();

		CommonFunctions.sendKeys(AddSubMenuPage.Description,"Edit Check");
		CommonFunctions.sendKeys(AddSubMenuPage.MainMenu,"Executive Analytics");
		CommonFunctions.click(AddSubMenuPage.SaveButton);
		System.out.println("Sub Menu Edited Successfully");
		//delete
		driver.findElement(By.xpath("//tr/..//td[contains(text(),'"+System.getProperty("MenuName")+"')]/..//a/img[@src='images/delete.jpg']")).click();
		String s=driver.switchTo().alert().getText();
		System.out.println(s);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		System.out.println("Sub Menu Deleted Successfully");
		//logger.log(LogStatus.INFO, logger.addScreenCapture(CommonFunctions.takeScreenshot(driver)));
	}
/*
	@DataProvider
	public Object[][] MainMenuData() throws Exception{

		Object[][] testObjArray = DataFilesReader.ReadExcelSpreadSheet(System.getProperty("user.dir")+"testDataFiles/VMAS_Scripts_DataSheet.xlsx","Sheet1");
		return (testObjArray);

	}*/

	//@Test(priority=3,enabled=false)
	public void Test4_Verify_AddMainMenu()throws Exception{
		VMAS_HomePage homePage = new VMAS_HomePage(driver);
		VMAS_AdminManagement adminMgmtPage = new VMAS_AdminManagement(driver); 
		VMAS_AddMainMenu AddMainMenuPage = new VMAS_AddMainMenu(driver); 

		homePage.goToAdminMgmtPage();
		adminMgmtPage.Click_AddMainMenu();
		System.setProperty("MenuName", "Test_Automation_Apr17");
		CommonFunctions.sendKeys(AddMainMenuPage.MainMenuName,System.getProperty("MenuName"));

		CommonFunctions.sendKeys(AddMainMenuPage.Description,"TestApr17");
		CommonFunctions.sendKeys(AddMainMenuPage.Displayorder,"18");
		Thread.sleep(3000);
		CommonFunctions.click(AddMainMenuPage.SelectMenuIcon);
		Thread.sleep(3000);
		CommonFunctions.click(AddMainMenuPage.MenuIcondropdown);
		CommonFunctions.click(AddMainMenuPage.SelectSectionImage);
		Thread.sleep(3000);
		CommonFunctions.click(AddMainMenuPage.SectionImagedropdown);
		CommonFunctions.click(AddMainMenuPage.SelectBannerImage);
		Thread.sleep(3000);
		CommonFunctions.click(AddMainMenuPage.BannerImagedropdown);
		Thread.sleep(3000);
		CommonFunctions.click(AddMainMenuPage.SaveButton);
		Thread.sleep(10000);
		System.out.println("Main Menu Created Successfully");


		//Add Assert here
		//logger.log(LogStatus.INFO, logger.addScreenCapture(CommonFunctions.takeScreenshot(driver)));
		//logger.log(LogStatus.PASS, "'add method name here ' Passed!");

		driver.findElement(By.xpath("//tr/..//td[contains(text(),'"+System.getProperty("MenuName")+"')]/..//a/img[@src='images/edit.jpg']")).click();
		Thread.sleep(20000);
		driver.findElement(AddMainMenuPage.Description).clear();
		CommonFunctions.sendKeys(AddMainMenuPage.Description,"Edit Check");
		//logger.log(LogStatus.INFO, logger.addScreenCapture(CommonFunctions.takeScreenshot(driver)));
		CommonFunctions.sendKeys(AddMainMenuPage.Displayorder,"15");
		CommonFunctions.click(AddMainMenuPage.SaveButton);
		System.out.println("Main Menu Edited Successfully");
		//delete
		driver.findElement(By.xpath("//tr/..//td[contains(text(),'"+System.getProperty("MenuName")+"')]/..//a/img[@src='images/delete.jpg']")).click();
		String s=driver.switchTo().alert().getText();
		System.out.println(s);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		System.out.println("Main Menu Deleted Successfully");
	}
}
