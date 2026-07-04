package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparisonPage extends BasePage {

    public ProductComparisonPage(WebDriver driver) {
        super(driver);
    }

    // Product Comparison Heading
    @FindBy(xpath="//h1[normalize-space()='Product Comparison']")
    WebElement headingMsg;

    // Compared Product Name
    @FindBy(xpath="//table[@class='table table-bordered']//tbody[1]//tr[1]//td[2]/a")
    WebElement productName;

    // Verify Comparison Page
    public boolean isProductComparisonPageExists() {
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