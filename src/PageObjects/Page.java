package PageObjects;

import org.openqa.selenium.WebDriver;

import PopUps.NeedEmergencyLegalAssistance;

public class Page {
	public String pageTitle;
	public WebDriver driver;
	public String parentWindowHandle;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isPopUpOpened() {
		try {
			return new NeedEmergencyLegalAssistance(driver).isClosePopupXIconPresent();
		} catch (Exception e) {
			System.out.print(e);
		}
		return false;
	}

	public String getParentWindowHandle() {
		return driver.getWindowHandle();
	}

	public void switchBackToParentWindowHanle(String parentWindowHandle) {
		driver.switchTo().window(parentWindowHandle); // switch back to parent window
	}
}
