package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {
	
	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Account Logout']")
	WebElement logoutMsg;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement continuebtn;
	
	public boolean isLogoutPageExists() {
		try {
			return (logoutMsg.isDisplayed());
		} catch(Exception e) {
			return false;
		}
	}
	
	public void clickContinue() {
		continuebtn.click();
	}
}
