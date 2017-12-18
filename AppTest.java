package by.htp.testng.tstng_study;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AppTest {
	
	private static final String DRIVER_FIREFOX = "webdriver.gecko.driver";
	private static final String DRIVER_FIREFOX_PATH = "D:\\\\driver\\geckodriver.exe";
	private static final String MAIN_TUTBY ="//div[@id=\"title_news_block\"]/div/h3";
	private static final String MAIN_LINK = ".anounce__link";
	private static final String MAIN_TEXT = "#article_body>p";
	private static final String REGISTRATION_QUIZFUL = "/html/body/div[1]/ul[2]/li[3]/a";
	private static final String LOGIN_REGISTRATION = "//input[@id=\"login\"]";
	private static final String PASSWORD_REGISTRATION = "//input[@name=\"registrationForm.password\"]";
	private static final String PASSWORD_AGAIN = "//input[@name=\"registrationForm.repassword\"]";
	private static final String EMAIL = "//input[@name=\"registrationForm.email\"]";
	private static final String CAPTCHA = "//input[@name=\"registrationForm.captcha\"]";
	private static final String ENTER = "/html/body/div[1]/ul[2]/li[1]/a";
	private static final String LOGIN = "//input[@id=\"login\"]";
	private static final String PASSWORD = "//input[@name=\"loginForm.password\"]";
	private static final String SUBMIT = "/html/body/div[2]/div[3]/div[3]/div[3]/form/p/input";
	private static final String USER = "/html/body/div[1]/ul[2]/li[1]/b/a";
	private static final String PERSONAL_INFO = "#profile-personal-form > div.title";
	private static final String EDIT_INFO = "//div[@class=\"btn-group\"]/a";
	private static final String NAME = "//input[@name=\"personalForm.name\"]";	
	private static final String SECONDNAME = "//input[@name=\"personalForm.surname\"]";
	private static final String DATEOFBIRTH = "//input[@name=\"personalForm.birthyear\"]";
	private static final String SITE = "//input[@name=\"personalForm.site\"]";
	private static final String COMPANY = "//input[@name=\"personalForm.company\"]";
	//private static final String CITY = "//input[@name=\"personalForm.zone\"]";
	private static final String TIME = "//input[@name=\"personalForm.zone\"]";
	private static final String ABOUT_MYSELF = "//textarea[@name=\"personalForm.about\"]";
	private static final String SAVE = "/html/body/div[2]/div[3]/div[2]/div[2]/div[3]/form/div/input";
	
	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
		System.setProperty(DRIVER_FIREFOX, DRIVER_FIREFOX_PATH);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}

	@Test
	public void testTutBy() {
		System.out.println("Test1");
		driver.get("http://www.tut.by");
		WebElement mainTitle = driver.findElement(By.xpath(MAIN_TUTBY));
		System.out.println(mainTitle.getText());
		WebElement mainLink = driver.findElement(By.cssSelector(MAIN_LINK));
		mainLink.click();
		try {
	    	Thread.sleep(5000);
	    }catch(InterruptedException e) {
	        e.printStackTrace();	
	    }
		List<WebElement> mainText = driver.findElements(By.cssSelector(MAIN_TEXT));
		System.out.println(mainText.size());
		try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	        e.printStackTrace();	
	    }
	}

	@Test
	public void findGoogle() {
		System.out.println("test2");
		driver.get("http://google.by");
		WebElement searchGoogle = driver.findElement(By.name("q"));
	    searchGoogle.sendKeys("Java");
	    searchGoogle.submit();
		try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	        e.printStackTrace();	
	    }
		String title = driver.getTitle();
		assertTrue(title.contains("Java")); 
	}

	@Test
	public void registrationQuizful() {
		System.out.println("test3");
		driver.get("http://www.quizful.net");
		WebElement element = driver.findElement(By.xpath(REGISTRATION_QUIZFUL));
		element.click();
		WebElement login = driver.findElement(By.xpath(LOGIN_REGISTRATION));
		login.sendKeys("Name5542");
		WebElement password = driver.findElement(By.xpath(PASSWORD_REGISTRATION));
		password.sendKeys("4547As21ff");
		WebElement passwordAgain = driver.findElement(By.xpath(PASSWORD_AGAIN));
		passwordAgain.sendKeys("4547As21ff");
		WebElement email = driver.findElement(By.xpath(EMAIL));
		email.sendKeys("yeji@p33.org");
		WebElement checkboxCorporate = driver.findElement(By.cssSelector("#corporate"));
		checkboxCorporate.click();
		WebElement captcha = driver.findElement(By.xpath(CAPTCHA));
		try {
	    	Thread.sleep(10000);
	    }catch(InterruptedException e) {
	        e.printStackTrace();	
	    }
		WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/form/p[2]/input[1]"));
		submit.click();
	}
	
	@Test
	public void editPersonalInfo() {
		System.out.println("test4");
		driver.get("http://www.quizful.net");
		WebElement enter = driver.findElement(By.xpath(ENTER));
		enter.click();
		WebElement login = driver.findElement(By.xpath(LOGIN));
		login.sendKeys("AlenaAnt");
		WebElement password = driver.findElement(By.xpath(PASSWORD));
		password.sendKeys("dtlmvf");
		WebElement submit = driver.findElement(By.xpath(SUBMIT));
		submit.click();
		WebElement user = driver.findElement(By.xpath(USER));
		user.click();
		WebElement edit = driver.findElement(By.xpath(EDIT_INFO));
		edit.click();
		WebElement personalInfo = driver.findElement(By.cssSelector(PERSONAL_INFO));
		personalInfo.click();
		WebElement name = driver.findElement(By.xpath(NAME));
		name.sendKeys("Alena");
		WebElement secondname = driver.findElement(By.xpath(SECONDNAME));
		secondname.sendKeys("Fomina");
		WebElement dateofbirth = driver.findElement(By.xpath(DATEOFBIRTH));
		dateofbirth.sendKeys("1996");
		WebElement site = driver.findElement(By.xpath(SITE));
		site.sendKeys("vk.com");
		WebElement company = driver.findElement(By.xpath(COMPANY));
		company.sendKeys("BSU");
		Select selCountry = new Select(driver.findElements(By.name("personalForm.countryId")).get(0));
		selCountry.selectByVisibleText("Беларусь");
		Select selCity = new Select(driver.findElements(By.name("personalForm.cityId")).get(0));
		selCity.selectByVisibleText("Минск");
		WebElement aboutMyself = driver.findElement(By.xpath(ABOUT_MYSELF));
		aboutMyself.sendKeys("Люблю фотографировать, учусь в университете");
		WebElement save = driver.findElement(By.xpath(SAVE));
		save.click();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
		driver.close();
		driver = null;
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest");
	}

}
