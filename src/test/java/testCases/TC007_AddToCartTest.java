package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC007_AddToCartTest extends BaseClass {

	@Test
	public void verify_addToCart() {

		HomePage homePage = new HomePage(driver);
		SearchPage searchPage = new SearchPage(driver);
		ProductPage productPage = new ProductPage(driver);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

		String productName = properties.getProperty("product");

		// Step 1 : Search Product
		logger.info("Searching product : " + productName);
		homePage.searchBox(productName);
		homePage.clickSearchIcon();

		// Step 2 : Open Product
		logger.info("Opening searched product");
		searchPage.clickSearchProduct();

		// Step 3 : Click on add to cart
		logger.info("Click on Add To Cart");
		productPage.clickAddToCart();

		// ER-1 Verify Success Msg
		String successMsg = productPage.getSuccessMessage();

		Assert.assertTrue(successMsg.contains("Success: You have added"), "Success message not displayed");

		logger.info("Success message verified");

		// Step 5 : Click on the shopping cart link
		logger.info("Navigating to Shopping Cart page");
		productPage.clickShoppingCartLink();

		// ER-2 : Verify Comparison Page
		Assert.assertTrue(shoppingCartPage.isShoppingCartPageExists(), "Product Shopping Cart page is not displayed");

		logger.info("Shopping Cart page displayed successfully");

		// Verify Correct Product
		String actualProduct = shoppingCartPage.getComparedProductName();

		Assert.assertEquals(actualProduct, productName, "Incorrect product displayed in Shopping cart page");

		logger.info("Correct product displayed in shopping cart page");

	}

}
