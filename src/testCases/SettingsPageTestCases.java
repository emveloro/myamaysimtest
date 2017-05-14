package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.HomePageObjects;
import pageClasses.LoginPageObjects;
import pageClasses.SettingsPageObjects;

public class SettingsPageTestCases {

	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void openBrowser() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://accounts.amaysim.com.au/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl + "/identity/login");
	}

	@Test
	public void editSimName() throws Exception {
		LoginPageObjects lp = new LoginPageObjects(driver);

		lp.LogIn("0468827174", "theHoff34");
		Thread.sleep(3000);
		lp.ClickLogin();

		HomePageObjects hp = new HomePageObjects(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hp.ClosePopUp(driver);
		hp.ClickSettingsLink();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		SettingsPageObjects sp = new SettingsPageObjects(driver);
		Thread.sleep(5000);
		sp.EditSimNickname("Test 001");
		hp.ClickLogout();
	}

	public void cancelEditSimName() throws Exception {
		LoginPageObjects lp = new LoginPageObjects(driver);

		lp.LogIn("0468827174", "theHoff34");
		Thread.sleep(3000);
		lp.ClickLogin();

		HomePageObjects hp = new HomePageObjects(driver);
		hp.ClosePopUp(driver);
		hp.ClickSettingsLink();

		SettingsPageObjects sp = new SettingsPageObjects(driver);
		Thread.sleep(5000);
		sp.CancelSimNickname("Test 002");
		hp.ClickLogout();
	}

	@AfterMethod
	@AfterTest
	public void tearDown() throws Exception {

	}

}
