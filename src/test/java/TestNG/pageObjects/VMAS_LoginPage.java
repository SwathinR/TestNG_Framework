package TestNG.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VMAS_LoginPage extends BasePage{

    //*********Constructor*********
    public VMAS_LoginPage(WebDriver driver) {
        super(driver);
    }
    
    //*********Page Variables*********
    String baseURL = "http://vzwdt.com:7999/DeviceAnalytics/";

    //*********Web Elements*********
    static By VMAS_UserName = By.id("uswin");
	static By VMAS_Password = By.id("signinpwd");
	static By VMAS_SignIn = By.xpath("//button[contains(text(),'Sign In')]");
	static By SignIn_Error = By.id("invalidUSWIN_Msg");

    //*********Page Methods*********
	
	//Open Application
	public void GotoVMAS() {
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
		
	//Login to application
	public void SignIntoVMAS(String username, String password){
		
		sendKeys(VMAS_UserName, username);
		sendKeys(VMAS_Password, password);
		click(VMAS_SignIn);
	}

    //Verify invalid credential error message
	public String SignIn_ErrorCheck()throws Exception{
		
		//Entering invalid credentials to verify proper error message
		sendKeys(VMAS_UserName, "test");
		sendKeys(VMAS_Password, "test");
		click(VMAS_SignIn);
		String errorMsg = getText(SignIn_Error);
		return errorMsg;
	}	
}
