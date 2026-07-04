package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparisonPage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC006_CompareProductTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_ProductComparison() {

		logger.info("********** Starting TC006_CompareProductTest **********");

		HomePage homePage = new HomePage(driver);
		SearchPage searchPage = new SearchPage(driver);
		ProductPage productPage = new ProductPage(driver);
		ProductComparisonPage comparisonPage = new ProductComparisonPage(driver);

		String productName = properties.getProperty("product");

		// Step 1 : Search Product
		logger.info("Searching product : " + productName);
		homePage.searchBox(productName);
		homePage.clickSearchIcon();

		// Step 2 : Open Product
		logger.info("Opening searched product");
		searchPage.clickSearchProduct();

		// Step 3 : Hover on Compare Product
		logger.info("Hovering on Compare Product icon");
		productPage.hoverOnCompareProduct();

		// ER-1 : Verify Tooltip
		String tooltip = productPage.getCompareTooltip();

		Assert.assertEquals(tooltip, "Compare this Product", "Tooltip text mismatch");

		logger.info("Tooltip verified successfully");

		// Step 4 : Click Compare Product
		logger.info("Clicking Compare Product");
		productPage.clickCompareProduct();

		// ER-2 : Verify Success Message
		String successMsg = productPage.getSuccessMessage();

		Assert.assertTrue(successMsg.contains("Success: You have added"), "Success message not displayed");

		logger.info("Success message verified");

		// Step 5 : Click Product Comparison Link
		logger.info("Navigating to Product Comparison page");
		productPage.clickComparisonLink();

		// ER-3 : Verify Comparison Page
		Assert.assertTrue(comparisonPage.isProductComparisonPageExists(), "Product Comparison page is not displayed");

		logger.info("Comparison page displayed successfully");

		// Verify Correct Product
		String actualProduct = comparisonPage.getComparedProductName();

		Assert.assertEquals(actualProduct, productName, "Incorrect product displayed in comparison page");

		logger.info("Correct product displayed in comparison page");

		logger.info("********** TC006_CompareProductTest PASSED **********");
	}
}