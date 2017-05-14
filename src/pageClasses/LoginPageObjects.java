package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects{
	
	public LoginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	public WebElement unTextBox;
	
	@FindBy(id = "password")
	public WebElement pwTextBox;
	
	@FindBy(name = "commit")
	public WebElement loginButton;


	public void LogIn (String username, String password){
		unTextBox.sendKeys(username);
		pwTextBox.sendKeys(password);
	}
	
	public void ClickLogin(){
		loginButton.click();
	}

}
