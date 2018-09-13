package nomadAutomation;

import org.testng.annotations.Test;

import nomadClasses.NomadUserClasses;

import org.testng.annotations.BeforeTest;
import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TestSuite {
	public ResourceBundle bundle = ResourceBundle.getBundle("NomadAutomation.Config");
	public String nomadUrl = bundle.getString("nomadUrl");
	public String mockUrl = bundle.getString("mockUrl");
	public String driverPath = bundle.getString("driverPath");
	public static WebDriver driver;
	public NomadUserClasses objet = new NomadUserClasses(bundle, nomadUrl, driverPath);

	@BeforeTest(description = "Ouverture du Navigateur")
	public void OpenBrowser() {
		driver = objet.openingNomadOnFirefoxe(driver, driverPath, nomadUrl);
		
		
	}

	@Test(description = "Scénarion 1")
	public void main() {
		driver = objet.userAuthentication(bundle.getString("adminLogin"), bundle.getString("adminMdp"),
				driver, nomadUrl);
		//driver= objet.goToCeateUser(driver, nomadUrl);
		

	}

	@AfterTest(description = "Fermeture du navigateur")
	public void CloseBrowser() {
		driver.close();
	}

}
