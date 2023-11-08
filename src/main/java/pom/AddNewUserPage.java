package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewUserPage {
	//Declaration
	@FindBy(xpath=" //b[text()='Add New User']")
	public WebElement pageHeader;
	
	@FindBy(xpath=" //input[@id='email' and @required]")
	public WebElement emailTF;
	
	@FindBy(xpath="  //input[@id='password' and @required]")
	public WebElement passwordTF;
	
	@FindBy(xpath=" //input[@id='firstname' and @required]")
	public WebElement firstnameTF;
	
	@FindBy(xpath=" //input[@id='lastname' and @required]")
	public WebElement lastnameTF;
	
	@FindBy(xpath=" //textarea[@id='address']")
	public WebElement addressTextArea;
	
	@FindBy(xpath=" //input[@id='contact']")
	public WebElement contactInfoTF;
	
	@FindBy(xpath=" (//input[@id='photo'])[3]")
	public WebElement photo;
	
	@FindBy(xpath=" //button[@name='add']")
	public WebElement saveButton;

	//Initialization
	public AddNewUserPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void createNewUser(String email,String password,String firstname,String lastname,String address,String contact,String photoPath) {
		emailTF.sendKeys(email);
		passwordTF.sendKeys(password);
		firstnameTF.sendKeys(firstname);
		lastnameTF.sendKeys(lastname);
		addressTextArea.sendKeys(address);
		contactInfoTF.sendKeys(contact);
		photo.sendKeys(photoPath);
		saveButton.click();
	}
	
	

}
