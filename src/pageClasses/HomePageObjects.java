package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects{
	
	public HomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='welcome_popup']")
	public WebElement popUp;
	
	@FindBy(xpath="//div[@id='welcome_popup']/a")
	public WebElement closePopUp;
	
	@FindBy(xpath = "//span[contains(text(),'Settings')]")
	public WebElement settingsLink;
	
	@FindBy(xpath = "//a[@id='logout-link']")
	public WebElement logout;
	

	public void ClosePopUp(WebDriver driver) {		 
		closePopUp.click();
	}
	
	public void ClickSettingsLink(){
		settingsLink.click();
	}
	
	public void ClickLogout(){
		logout.click();
	}

}
