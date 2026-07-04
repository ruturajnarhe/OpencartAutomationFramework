package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC004_LogoutTest extends BaseClass {

    @Test(groups = {"Sanity"})
    public void verify_Logout() {

        logger.info("***** Starting TC004_LogoutTest *****");

        try {

            // Home Page
            HomePage homePage = new HomePage(driver);

            logger.info("Clicking on My Account");
            homePage.clickMyAccount();
            
            logger.info("Clicking on Login");
            homePage.clickLogin();

            // Login Page
            LoginPage loginPage = new LoginPage(driver);

            logger.info("Entering email");
            loginPage.setEmail(properties.getProperty("email"));

            logger.info("Entering password");
            loginPage.setPassword(properties.getProperty("password"));

            logger.info("Clicking on Login button");
            loginPage.clickLogin();

            // My Account Page
            MyAccountPage myAcc = new MyAccountPage(driver);

            logger.info("Clicking on My Account");
            myAcc.clickMyAccount();

            logger.info("Clicking on Logout");
            myAcc.clickLogout();

            // Logout Page
            LogoutPage logoutPage = new LogoutPage(driver);

            logger.info("Verifying logout page");
            boolean targetPage = logoutPage.isLogoutPageExists();

            Assert.assertTrue(targetPage, "Logout page is not displayed");

            logger.info("Clicking on Continue button");
            logoutPage.clickContinue();

            // Home Page Validation
            logger.info("Verifying home page title");
            String title = driver.getTitle();

            Assert.assertEquals(title, "Your Store", "Home page title mismatch");

            logger.info("TC004_LogoutTest Passed");

        } catch (Exception e) {

            logger.error("Test case failed : " + e.getMessage());
            Assert.fail();
        }

        logger.info("***** Finishing TC004_LogoutTest *****");
    }
}
