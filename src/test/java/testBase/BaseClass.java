package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;  // log4j
	public Properties properties;

	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException {
		
		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		properties = new Properties();
		properties.load(file);
		
		logger = LogManager.getLogger(this.getClass()); //log4j2
		
		// Remote Execution
        if (properties.getProperty("execution_env").equalsIgnoreCase("remote")) {

            // Chrome Browser
            if (br.equalsIgnoreCase("chrome")) {

                ChromeOptions options = new ChromeOptions();

                // OS
                if (os.equalsIgnoreCase("windows")) {
                    options.setPlatformName("Windows");
                } 
                else if (os.equalsIgnoreCase("mac")) {
                    options.setPlatformName("macOS");
                } 
                else {
                    System.out.println("No matching OS");
                    return;
                }

                driver = new RemoteWebDriver(
                        new URL("http://localhost:4444"),
                        options);
            }

            // Edge Browser
            else if (br.equalsIgnoreCase("edge")) {

                EdgeOptions options = new EdgeOptions();

                // OS
                if (os.equalsIgnoreCase("windows")) {
                    options.setPlatformName("Windows");
                } 
                else if (os.equalsIgnoreCase("mac")) {
                    options.setPlatformName("macOS");
                } 
                else {
                    System.out.println("No matching OS");
                    return;
                }

                driver = new RemoteWebDriver(
                        new URL("http://localhost:4444"),
                        options);
            }

            else {
                System.out.println("No matching browser");
                return;
            }
        }

        // Local Execution
        else if (properties.getProperty("execution_env").equalsIgnoreCase("local")) {

            switch (br.toLowerCase()) {

                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                default:
                    System.out.println("Invalid browser");
                    return;
            }
        }

        else {
            System.out.println("Invalid execution environment");
            return;
        }
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		driver.get("https://tutorialsninja.com/demo/");
		driver.get(properties.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups= {"Sanity","Regression","Master"})
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
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
