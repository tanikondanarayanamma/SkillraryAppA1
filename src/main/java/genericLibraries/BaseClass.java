package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pom.AddNewCategoryPage;
import pom.AddNewCoursePage;
import pom.AddNewUserPage;
import pom.AdminHomePage;
import pom.CategoryPage;
import pom.CourseListPage;
import pom.Loginpage;
import pom.UsersPage;
import pom.WelcomePage;

public class BaseClass {
	//BeforeSuite:-Database Connections
	//BeforeTest:-Parallel Execution
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	protected WebDriver driver;
	
	protected static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	protected WelcomePage welcome;
	protected Loginpage login;
	protected AdminHomePage home;
	protected UsersPage users;
	protected CourseListPage course;
	protected CategoryPage category;
	protected AddNewUserPage address;
	protected AddNewCoursePage addCourse;
	protected AddNewCategoryPage addCategory;
	
	
	
	
	@BeforeClass
	public void classConfig() {
		property = new PropertiesUtility();
		excel= new ExcelUtility();
		jutil = new JavaUtility();
		webUtil = new WebDriverUtility();
		
		property.PropertiesInitialization(IconstantPath.PROPERTIES_PATH);
		driver =webUtil.launchBrowser(property.readFromProperties("browser"));
		
		sdriver = driver;
		sjutil = jutil;
		
		
	}
	@BeforeMethod
	public void methodConfig() {
		excel.excelInitialization(IconstantPath.PROPERTIES_PATH);
		
		welcome = new WelcomePage(driver);
		login=new Loginpage(driver);
		home = new AdminHomePage(driver);
		users = new UsersPage(driver);
		course = new CourseListPage(driver);
		category = new CategoryPage(driver);
		address= new AddNewUserPage(driver);
		addCourse = new AddNewCoursePage(driver);
		addCategory= new  AddNewCategoryPage(driver);
		
		webUtil.navigateToApp(property.readFromProperties("url"));
		
		long time =Long.parseLong(property.readFromProperties("timeouts"));
		webUtil.waitTillElementFound(time);
		welcome.clickLOginButton();
		login.setEmail(property.readFromProperties("username"));
		login.setPassword(property.readFromProperties("password"));
		login.clickLogin();	
	}
	@AfterMethod
	 public void methodTearDown() {
		excel.closeExcel();
		home.signOutOfApp();
	}
	@AfterClass
	public void methodTearDown1()
	{
		webUtil.closeAllWindow();
	}
	//AfterTest
	//AfterSuite
	
}

