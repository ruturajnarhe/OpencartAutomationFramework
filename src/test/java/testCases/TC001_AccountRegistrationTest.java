package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() {
		try {
			logger.info("*** Starting TC001_AccountRegistrationTest ***");
			HomePage homePage = new HomePage(driver);

			homePage.clickMyAccount();
			logger.info("Clicked on MyAccount link.. ");

			homePage.clickRegister();
			logger.info("Clicked on Register Link.. ");

			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

			logger.info("Providing customer details.. ");
			regPage.setFirstName(randomString().toUpperCase());
			regPage.setLastName(randomString().toUpperCase());
			regPage.setEmail(randomString() + "@gmail.com");
			regPage.setTelephone(randomNumber());

			String password = randomAlphaNumeric();

			regPage.setPassword(password);
			regPage.setConfirmPassword(password);

			regPage.clickCheckPolicy();
			regPage.clickContinue();

			logger.info("Validating expected message.. ");
			String confmsg = regPage.getConfirmationMsg();

			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed.. ");
				logger.debug("Debug logs.. ");
				Assert.assertTrue(false);
			}

			// Assert.assertEquals(confmsg, "Your Account Has Been Created!");

		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Finished TC001_AccountRegistrationTest ***");
	}

}
