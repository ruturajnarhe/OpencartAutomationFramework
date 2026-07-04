package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;
	
	public void setEmail(String email) {
		waitForVisibility(emailAddress);
		emailAddress.sendKeys(email);
	}
	public void setPassword(String pwd) {
		waitForVisibility(password);
		password.sendKeys(pwd);
	}
	public void clickLogin() {
		waitForClickable(loginbtn);
		loginbtn.click();
	}
	
}
