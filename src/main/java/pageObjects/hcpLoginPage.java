package pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hcpLoginPage {
	
	private WebDriver driver;
	    
	    public hcpLoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }


    @FindBy(linkText = "Sign up")
    private WebElement signUpButton;
    
    @FindBy(linkText = "Sign up")
    private WebElement signInText;
    
    @FindBy(id = "email")
    private WebElement emailField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(css = "MuiGrid-root:nth-child(3).MuiButton-label")
    private WebElement forgotPassword;

    @FindBy(css = ".MuiButton-contained")
    private WebElement signInButton;
    
    
    
    public WebElement emailTxtBox() {
    	return emailField;
    }
    
    public WebElement pwdTxtBox() {
    	return passwordField;
    }
    
    public WebElement siginButton() {
    	return signInButton;
    }


}
