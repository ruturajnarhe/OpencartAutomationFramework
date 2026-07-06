package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.MyWishListPage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC008_WishListTest extends BaseClass {

	@Test
	public void verify_whishList() {
		
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		SearchPage searchPage = new SearchPage(driver);
		ProductPage productPage = new ProductPage(driver);
		MyWishListPage myWishListPage = new MyWishListPage(driver);
		
		String productName = properties.getProperty("product");
		String email = properties.getProperty("email");
		String password = properties.getProperty("password");
		
		// Step 1 : Login
		homePage.clickMyAccount();
		homePage.clickLogin();
		loginPage.setEmail(email);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		
		// Step 2 : Search Product 
		logger.info("Searching product : " + productName);
		myAccountPage.searchBox(productName);
		myAccountPage.clickSearchIcon();
		
		// Step 3 : Open Product
		logger.info("Opening searched product");
		searchPage.clickSearchProduct();
		
		// Step 4 : click on wish list button
		logger.info("Click on Wish List Button");
		productPage.clickWishListButton();
		
		// ER-1 : Verify success Msg
		String successMsg = productPage.getSuccessMessage();

		Assert.assertTrue(successMsg.contains("Success: You have added"), "Success message not displayed");
		
		logger.info("Success message verified");

		// Step 5 : Click on the Wish List link
		logger.info("Navigating to Wish List page");
		productPage.clickWishListLink();
		
		// ER-2 : Verify Shopping Cart Page
		Assert.assertTrue(myWishListPage.isMyWishListPageExists(), "Product Wish List page is not displayed");
		
		logger.info("Shopping Cart page displayed successfully");

		// Verify Correct Product
		String actualProduct = myWishListPage.getWishListProductName();

		Assert.assertEquals(actualProduct, productName, "Incorrect product displayed in Wish List page");

		logger.info("Correct product displayed in Wish List page");
		
	}
	
}
