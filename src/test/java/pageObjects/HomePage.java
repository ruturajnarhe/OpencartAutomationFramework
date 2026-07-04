package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	// MyAccount in home page
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	// Register
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	
	// Login
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement loginLink;
	
	// Search input
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchBox;
	
	// search icon
	@FindBy(xpath="//i[@class='fa fa-search']")
	WebElement searchIcon;
	
	public void clickMyAccount() {
		
		waitForClickable(myAccount);
		myAccount.click();
	}
	
	public void clickRegister() {
		waitForClickable(register);
		register.click();
	}
	
	
	public void clickLogin() {
		waitForClickable(loginLink);
		loginLink.click();
	}
	
	public void searchBox(String product) {
		waitForVisibility(searchBox);
		searchBox.sendKeys(product);
	}
	
	public void clickSearchIcon() {
		waitForClickable(searchIcon);
		searchIcon.click();
	}
	
}
