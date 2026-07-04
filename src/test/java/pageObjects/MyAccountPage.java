package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement headingMsg;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logoutLink;
	
//	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
//	WebElement logoutLink;
	
	
	public boolean isMyAccountPageExists() {
		try {
			waitForVisibility(headingMsg);
			return (headingMsg.isDisplayed());
		} catch(Exception e) {
			return false;
		}
	}
	
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickLogout() {
		logoutLink.click();
	}
	
	
}
