package com.motionintegrator.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.motionintegrator.pages.HomePage;

public class HomeTest extends BaseTest {
	
	HomePage homePage = new HomePage();
	
	By myHover = By.xpath("/html/body/div[1]/div/div/main/section[2]/div/div/div/article[1]/a");
	By tires = By.xpath("/html/body/div[1]/div/div/main/section[2]/div/div/div/article[1]/a/div");
	By city = By.xpath("/html/body/div/div/main/div/div[4]/div/a[9]");
	By mySection = By.xpath("/html/body/div[1]/div/main/div[3]/section[2]");
	By myArticle = By.xpath("//article[@data-testid='listing-tile']");
	By myImageOfTheElement = By.className("WorkshopImagestyled__Image-sc-1oc732e-4");
	By open = By.xpath("//*[@id=\"__next\"]/div/main/div/div[2]/div[2]/section/article[1]/div/section/div/div/div[1]/div[1]/div");
	By myStarts = By.xpath("//*[@id=\"__next\"]/div/main/div/div[3]/div/section/section[1]/div/p[1]");
	
	@Test(description = "Visit the webpage, navigate to workshop and check the info")
	public void myWorkshopTest() throws InterruptedException {
		
		//Step 1: Scroll to the Button "Tires change", then mouse hover it and click 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement hoverBtn = driver.findElement(myHover);
		Actions action = new Actions(driver);
		action.moveToElement(hoverBtn).perform();
		WebElement tiresBtn = driver.findElement(tires);
		tiresBtn.click();
		//Step 2: Scroll to the button "Lublin" and click it
		js.executeScript("window.scrollBy(0,1000)");
		
		//Explicit wait example
		WebDriverWait wait  =new WebDriverWait(driver, Duration.ofSeconds(5));
		//Wait until the element is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(city));
		
		WebElement choiceCity = driver.findElement(city);
		choiceCity.click();
		//Step 3: Select the second car workshop from the list
		WebElement section = driver.findElement(mySection);
		section.findElements(myArticle).get(1).findElement(myImageOfTheElement).click();
		//Step 4: Verify visibility of text in Now open/closed position
		WebElement openHours = driver.findElement(open);
		assertEquals(true, openHours.isDisplayed());
		//Step 5: Verify that the workshop rating is equal to 5
		WebElement checkStars = driver.findElement(myStarts);
		assertEquals("5", checkStars.getText());
	}

}
