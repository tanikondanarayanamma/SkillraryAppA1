package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	
	
	//Declaration
	@FindBy(xpath="//h1[normalize-space(text()='User')]")
	private WebElement pageHeader;
	
	@FindBy(xpath="//a[text()=' New']")
	private WebElement plusNewButton;
	
	
	@FindBy(xpath="//ul[@class='pagination']/li[last()-1]/a")
	private WebElement usersListLastPage;
	
	
	@FindBy(xpath="//table/tbody//tr[last()]/td[3]")
	private WebElement lastUser;
	
	//Initialization
	public UsersPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void clickNewButton() {
		plusNewButton.click();
		
	}
	public void clickUserListLastPage() {
		usersListLastPage.click();
	}
	public String getLastUserName() {
		return lastUser.getText();
	}
	

	

}
