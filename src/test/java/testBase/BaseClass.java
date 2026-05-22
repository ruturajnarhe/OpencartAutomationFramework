package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;  // log4j
	public Properties properties;

	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException {
		
		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		properties = new Properties();
		properties.load(file);
		
		logger = LogManager.getLogger(this.getClass()); //log4j2
		
		switch(br.toLowerCase()) {
			case "chrome" : driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			default : System.out.println("Invalid browser"); return;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		driver.get("https://tutorialsninja.com/demo/");
		driver.get(properties.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String generatedString = RandomStringUtils.secure().nextAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {
		String generatedNumber = RandomStringUtils.secure().nextNumeric(10);
		return generatedNumber;
	}

	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.secure().nextAlphabetic(5);
		String generatedNumber = RandomStringUtils.secure().nextNumeric(3);
		return (generatedString + "@" + generatedNumber);
	}

}
