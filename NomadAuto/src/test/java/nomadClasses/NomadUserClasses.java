package nomadClasses;

import java.util.ResourceBundle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NomadUserClasses {

	ResourceBundle bundle;
	String baseUrl="";
	String driverPath="";
	WebDriver driver;
	String expected = "";
	String actual = "";

	public NomadUserClasses(ResourceBundle bundle, String baseUrl, String driverPath) {
		this.bundle = bundle;
		this.baseUrl = baseUrl;
		this.driverPath = driverPath;
	}

	@Test(description = "Ouverture du navigateur")
	public WebDriver openingNomadOnFirefoxe(WebDriver driver, String driverPath, String baseUrl) {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		return driver;
	}

	@Test(description = "Authentification à Nomad")
	public WebDriver userAuthentication(String Login, String Pwd, WebDriver driver, String baseURl) {
		driver.findElement(By.id("username")).sendKeys(Login);
		driver.findElement(By.id("password")).sendKeys(Pwd);
		driver.findElement(By.id("submit")).click();
		expected = baseURl;
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		return driver;
	}

	@Test(description = "Ouverture de l'écran Créer un utilisateur ")
	public WebDriver goToCeateUser(WebDriver driver, String baseUrl) {
		driver.findElement(By.xpath("//*[contains(text(), 'Créer un utilisateur')]")).click();
		expected = baseUrl + "user/create";
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		return driver;
	}
	
	@Test(description = "Création d'un administrateur fonctionnel")
	public WebDriver createUserAdminFonctionnel(WebDriver driver, String baseUrl) {
		driver.findElement(By.linkText("Cr�er un utilisateur")).click();
		driver.findElement(By.id("username")).sendKeys("AdminID");
		driver.findElement(By.id("firstName")).sendKeys("AdminPrenom");
		driver.findElement(By.id("lastName")).sendKeys("AdminNom");
		driver.findElement(By.id("contactNumber")).sendKeys("0867654666");
		driver.findElement(By.id("contactNumberSpecial")).sendKeys("0867654667");
		driver.findElement(By.id("email")).sendKeys("AdminEmail@gmail.com");
		driver.findElement(By.id("address")).sendKeys("AdminAdress");
		driver.findElement(By.id("webAccess")).click();
		driver.findElement(By.id("role_2")).click();
		driver.findElement(By.className("create")).click();
		expected = baseUrl + "/user/index";
		actual = driver.getCurrentUrl();
		Assert.assertNotEquals(actual, expected);
		return driver;
	}

	@Test(description = "Ouverture du Paramètrages Généraux ")
	public WebDriver goToParametrage(WebDriver driver, String baseUrl) {
		driver.findElement(By.linkText("Param�trage")).click();
		expected = baseUrl + "configuration/edit";
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		return driver;
	}

}
