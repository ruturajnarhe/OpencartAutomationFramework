package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void verify_login() {

        logger.info("***** Starting TC002_LoginTest *****");

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

            logger.info("Verifying My Account page");
            boolean targetPage = myAcc.isMyAccountPageExists();

            Assert.assertTrue(targetPage, "Login Failed");

            logger.info("Login Test Passed");

        } catch (Exception e) {

            logger.error("Test case failed : " + e.getMessage());
            Assert.fail();
        }

        logger.info("***** Finishing TC002_LoginTest *****");
    }
}
