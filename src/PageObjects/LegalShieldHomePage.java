package PageObjects;

import org.openqa.selenium.WebDriver;

public class LegalShieldHomePage extends Page{
	// Prepaid Legal Plans, Family Law Attorneys & Divorce Lawyers Near You
	public LegalShieldNavigation legalshieldNavigation;
	public WebDriver driver;

	public LegalShieldHomePage(WebDriver driver) {		
		super(driver);
		this.driver = driver;
	}

	public LegalShieldNavigation getLegalshieldNavigation() {
		return new LegalShieldNavigation(driver);
	}


}
