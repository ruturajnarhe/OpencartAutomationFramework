package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver) ;
	}
	
	// Shopping Cart heading
	@FindBy(xpath="//h1[contains(text(),'Shopping Cart')]")
	WebElement headingMsg ;
	
	// Shopping Cart Product Name 
    @FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
    WebElement productName ;
	
    // Verify Shopping Cart Page
	public boolean isShoppingCartPageExists() {
		try {
            waitForVisibility(headingMsg);
            return headingMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
	}
	
	// Get Compared Product Name
    public String getComparedProductName() {
        waitForVisibility(productName);
        return productName.getText();
    }
	
}
