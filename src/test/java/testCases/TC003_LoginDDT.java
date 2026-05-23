package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven") // getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp) {
		
		logger.info("*** Starting TC003_LoginDDT ***");
		
		try {
			
			// HomePage
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickLogin();
			
			// Login
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(email);
			loginPage.setPassword(pwd);
			loginPage.clickLogin();
			
			
			// MyAccount 
			MyAccountPage myAcc = new MyAccountPage(driver);
			boolean targetPage = myAcc.isMyAccoutPageExists();
			
			
			/* Data is Valid - login success - test pass - logout
			   				 - login failed - test failed
			   				 
			   Data is invalid - login success - test failed - logout
			   				   - login failed - test passe
			 */
			
			if(exp.equalsIgnoreCase("Valid")) {
				if(targetPage == true) {
					myAcc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid")) {
				if(targetPage == true) {
					myAcc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
			
		} catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Finishing TC003_LoginDDT ***");
		
	}
}
