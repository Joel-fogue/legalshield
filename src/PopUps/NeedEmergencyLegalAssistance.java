package PopUps;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.CONSTANTS;

public class NeedEmergencyLegalAssistance {
	public WebDriver driver;

	public NeedEmergencyLegalAssistance(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopUp() throws InterruptedException {
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		Thread.sleep(2000);
		driver.switchTo().window(subWindowHandler); // switch to popup window
		Thread.sleep(4000);
		// Click to close the popup icon
		driver.findElement(By.cssSelector(CONSTANTS.PopUpCloseIcon)).click();
	}

	public Boolean isClosePopupXIconPresent() {
		WebElement popUp = driver.findElement(By.cssSelector(CONSTANTS.PopUpCssSelector));
		WebElement X = popUp.findElement(By.cssSelector(CONSTANTS.PopUpCloseIcon));
		if (X.isDisplayed())
			return true;
		return false;
	}
}
