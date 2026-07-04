package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	// Compare Product button
	@FindBy(xpath = "//div[@class='col-sm-4']//button[2]")
	WebElement compareProduct;

	// Success message
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;

	// Product Comparison link
	@FindBy(xpath = "//a[normalize-space()='product comparison']")
	WebElement comparisonLink;

	// Click Compare Product
	public void clickCompareProduct() {
		waitForClickable(compareProduct);
		compareProduct.click();
	}

	// Hover on Compare Product
	public void hoverOnCompareProduct() {
		waitForVisibility(compareProduct);

		Actions action = new Actions(driver);
		action.moveToElement(compareProduct).perform();
	}

	// Get Tooltip Text
	public String getCompareTooltip() {
		waitForVisibility(compareProduct);

		// First try the title attribute
		String tooltip = compareProduct.getAttribute("title");

		// Some OpenCart versions use data-original-title
		if (tooltip == null || tooltip.isEmpty()) {
			tooltip = compareProduct.getAttribute("data-original-title");
		}

		return tooltip;
	}

	// Verify Success Message
	public boolean isCompareProductSuccessMsgDisplayed() {
		try {
			waitForVisibility(successMsg);
			return successMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Get Success Message Text
	public String getSuccessMessage() {
		waitForVisibility(successMsg);
		return successMsg.getText();
	}

	// Click Product Comparison Link
	public void clickComparisonLink() {
		waitForClickable(comparisonLink);
		comparisonLink.click();
	}
}