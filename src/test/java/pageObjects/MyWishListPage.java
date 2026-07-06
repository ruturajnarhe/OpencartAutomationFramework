package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWishListPage extends BasePage {

	public MyWishListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Wish List']")
	WebElement headingMsg;

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
	WebElement productName;

	// Verify My Wish List Page
	public boolean isMyWishListPageExists() {
		try {
			waitForVisibility(headingMsg);
			return headingMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Get Wish List Product Name
	public String getWishListProductName() {
		waitForVisibility(productName);
		return productName.getText();
	}

}
