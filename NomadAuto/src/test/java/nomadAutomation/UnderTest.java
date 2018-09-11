package nomadAutomation;


		import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;
	import static org.testng.Assert.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class UnderTest {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeTest
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			
	  }

	  @Test()
	  public void testUntitledTestCase() throws Exception {
	    driver.get("http://10.0.0.198:8082/mocks-G4R2-MEDITEL/sms/list");
	    driver.findElement(By.linkText("2018-05-10 17:25:16.0")).click();
	    driver.findElement(By.xpath("//div[@id='show-sms']/ol/li[3]/span[2]")).click();
	    driver.findElement(By.xpath("//div[@id='show-sms']/ol/li[3]/span[2]")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | //div[@id='show-sms']/ol/li[3]/span[2] | ]]
	  System.out.println(driver.findElement(By.xpath("//div[@id='list-sms']/table/tbody/tr/td[3]\"")).getText());
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}

