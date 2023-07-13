package businessComponents;

import com.relevantcodes.extentreports.LogStatus;

import commonHelper.CommonFunctions;
import pageObjects.hcpLoginPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import utils.DriverBase;
import utils.ExtentReportListner;

@Listeners(ExtentReportListner.class)
public class Login extends ExtentReportListner {
    private WebDriver driver;
    
    public Login(WebDriver driver) {
        this.driver = driver;
    }
    
	 private CommonFunctions cf = new CommonFunctions(DriverBase.driver);
	 private hcpLoginPage lp = new hcpLoginPage(DriverBase.driver);
	
	public void login() throws IOException {
		
		driver.manage().window().maximize();   
		
		driver.get("https://pro.housecallpro.com/pro/log_in");
		
		cf.sendText(lp.emailTxtBox(), "kamity969@gmail.com");
		cf.sendText(lp.pwdTxtBox(), "Victory@54");
		cf.clickElement(lp.siginButton());
		
	}
}