package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class SettingsPageObjects{
	
	public SettingsPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (linkText = "Settings")
	public WebElement settingsPageTitle;
	
	@FindBy(id = "edit_settings_phone_label")
	public WebElement simNicknameEditLink;
	
	@FindBy(id = "my_amaysim2_setting_phone_label")
	public WebElement simNicknameField;
	
	@FindBy(xpath = "//form[@id='edit_settings_sim_nickname']/div[3]/div/input")
	public WebElement simNicknameSave;
	
	@FindBy(xpath = "//a[@id='show_settings_sim_nickname']")
	public WebElement simNicknameCancel;
	
	@FindBy(xpath = "//div[@id='settings_sim_nickname']/div/div/div/div[2]")
	public WebElement simName;
	

	public void EditSimNickname (String nickname) throws InterruptedException{
		Assert.assertEquals(settingsPageTitle.getText(),"Settings");
		simNicknameEditLink.click();
		simNicknameField.clear();
		simNicknameField.sendKeys(nickname);
		simNicknameSave.click();
		Thread.sleep(5000);
		AssertJUnit.assertEquals(simName.getText(), nickname);
	}
	
	public void CancelSimNickname (String nickname) throws InterruptedException{
		AssertJUnit.assertEquals(settingsPageTitle.getText(),"Settings");
		String currentName = simName.getText();
		simNicknameEditLink.click();
		simNicknameField.clear();
		simNicknameField.sendKeys(nickname);
		simNicknameCancel.click();
		Thread.sleep(3000);
		AssertJUnit.assertEquals(simName.getText(), currentName);
	}
	

}
