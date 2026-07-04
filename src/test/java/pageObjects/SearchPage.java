package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver) {
		super(driver) ;
	}
	
	// search product
	@FindBy(xpath="//div[@class='product-thumb']")
	WebElement searchProduct;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement product ;
	
	public void clickSearchProduct() {
		waitForClickable(product);
		product.click();
	}
	
	public boolean isSearchProductExists() {
		try {
			waitForVisibility(searchProduct);
			return (searchProduct.isDisplayed());
		} catch(Exception e) {
			return false;
		}
	}

}
