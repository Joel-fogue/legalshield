package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PopUps.NeedEmergencyLegalAssistance;
import Utils.CONSTANTS;

public class LegalShieldNavigation extends Page {
	public String whyLegalShield;
	public String person;
	public String bussiness;
	public String lawFirms;
	public String legalGuides;
	public WebDriver driver;

	public LegalShieldNavigation(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void gotoWhyLegalShield() {
		driver.findElement(By.linkText(CONSTANTS.WhyLegalShield)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void gotoPersonal() {
		driver.findElement(By.linkText(CONSTANTS.Personal)).click();
		// Get parent window handle QUICKLY before popup comes up
		String parentWindowHandle = getParentWindowHandle();
		try {
			Thread.sleep(8000);
			NeedEmergencyLegalAssistance needEmergencyLegalAssistance = new NeedEmergencyLegalAssistance(driver);
			if (isPopUpOpened())
				needEmergencyLegalAssistance.closePopUp();
			// Switching back to parent window handle
			switchBackToParentWindowHanle(parentWindowHandle);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void gotoLawFirms() {
		driver.findElement(By.linkText(CONSTANTS.LawFirms)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
