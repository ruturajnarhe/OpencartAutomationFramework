package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_SearchFunctionalityTest extends BaseClass {

    @Test(groups = {"Regression"})
    public void verify_searchFunctionality() {

        logger.info("***** Starting TC005_SearchFunctionalityTest *****");

        try {

            HomePage homePage = new HomePage(driver);
            
            SearchPage searchPage = new SearchPage(driver);

            logger.info("Entering product name in search box");
            homePage.searchBox(properties.getProperty("product"));

            logger.info("Clicking on search icon");
            homePage.clickSearchIcon();

            logger.info("Verifying searched product");
            boolean searchProduct = searchPage.isSearchProductExists();

            Assert.assertTrue(searchProduct, "Search product is not displayed");

            logger.info("Test case passed");

        } catch (Exception e) {

            logger.error("Test case failed : " + e.getMessage());
            Assert.fail();
        }

        logger.info("***** Finished TC005_SearchFunctionalityTest *****");
    }
}
