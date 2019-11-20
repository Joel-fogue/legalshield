import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.LegalShieldHomePage;
import PageObjects.LegalShieldNavigation;
import Utils.CONSTANTS;

public class main {
	public WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
		System.setProperty(CONSTANTS.chromeDriverPathKey, CONSTANTS.chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testGettitleLegalShield() throws InterruptedException {
		driver.get(CONSTANTS.legalShieldHomePage);
		Thread.sleep(5000); // Let the user actually see something!
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, CONSTANTS.legalShieldHomePageTitle);
	}

	@Test
	public void testNavigateToWhyLegalShieldPage() throws InterruptedException {
		LegalShieldHomePage legalShieldNavigation = new LegalShieldHomePage(driver);
		legalShieldNavigation.getLegalshieldNavigation().gotoWhyLegalShield();
		String title = legalShieldNavigation.getPageTitle();
		Assert.assertEquals(title, CONSTANTS.WhyLegalShieldTitle);
	}

	@Test
	public void testNavigateToLawFirm() throws InterruptedException {
		LegalShieldHomePage legalShieldNavigation = new LegalShieldHomePage(driver);
		legalShieldNavigation.getLegalshieldNavigation().gotoLawFirms();
		String title = legalShieldNavigation.getPageTitle();
		Assert.assertEquals(title, CONSTANTS.LawFirmsPageTitle);
	}

	@Test
	public void testNavigateToPersonal() throws InterruptedException {
		LegalShieldHomePage legalShieldNavigation = new LegalShieldHomePage(driver);
		legalShieldNavigation.getLegalshieldNavigation().gotoPersonal();
		String title = legalShieldNavigation.getPageTitle();
		Assert.assertEquals(title, CONSTANTS.PersonalPageTitle);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}