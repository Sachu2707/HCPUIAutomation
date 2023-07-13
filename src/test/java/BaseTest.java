import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import businessComponents.Login;
import utils.DriverBase;
import utils.ExtentReportListner;

@Listeners(ExtentReportListner.class)
public class BaseTest {
	
    	
	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	 
	WebDriver driver=DriverBase.getDriver("chrome");

	@Test
	public void testLogin() throws IOException {
		BasicConfigurator.configure();
		logger.info("Test started..");
		Login login = new Login(DriverBase.driver);
		login.login();
		logger.info("Test Completed..");
	}
}
