package TestNG.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
public static Properties objConfig = new Properties();
	
	public static void LoadAllConfig(){
		try {
			objConfig = new Properties();
			objConfig.load(new FileInputStream(	System.getProperty("user.dir") + "/src/test/java/TestNG/resources/Config.properties"));
			objConfig.setProperty("os.name", System.getProperty("os.name"));
			/*System.setProperty("testPlatform",Platform);
			System.setProperty("testBrowser",Browser);*/
			System.setProperty("test.implicitWait", objConfig.getProperty("test.implicitWait"));
			System.setProperty("test.webDriverWait", objConfig.getProperty("test.webDriverWait"));
			System.setProperty("test.enableScreenshotCapture", objConfig.getProperty("test.enableScreenshotCapture"));
			System.setProperty("test.browser", objConfig.getProperty("test.browser"));
			System.out.println("Load All Config Successful");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
