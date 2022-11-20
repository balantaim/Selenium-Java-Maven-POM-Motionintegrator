package com.motionintegrator.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	By open = By.xpath("/html/body/div[1]/div/main/div/div[2]/div[2]/section/article[1]/div/section[1]/div/div/div/div[1]/ul/li/div");
	By myStarts = By.className("ReviewSummarystyled__Score-sc-1scryp4-2");
	
	@Test(description = "Visit the webpage, navigate to workshop and check the info")
	public void findTiresBtn() throws InterruptedException {
		//Step 1: Scroll to the Button "Tires change", then mouse hover it and click 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement hoverBtn = driver.findElement(myHover);
		Actions action = new Actions(driver);
		action.moveToElement(hoverBtn).perform();
		WebElement tiresBtn = driver.findElement(tires);
		tiresBtn.click();
		Thread.sleep(2000);
		//Step 2: Scroll to the button "Lublin" and click it
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		WebElement choiceCity = driver.findElement(city);
		choiceCity.click();
		Thread.sleep(2000);
		//Step 3: Select the second car workshop from the list
		WebElement section = driver.findElement(mySection);
		section.findElements(myArticle).get(1).findElement(myImageOfTheElement).click();
		Thread.sleep(2000);
		//Step 4: Verify visibility of text in Now open/closed position
		WebElement openHours = driver.findElement(open);
		assertEquals(true, openHours.isDisplayed());
		Thread.sleep(2000);
		//Step 5: Verify that the workshop rating is equal to 5
		WebElement checkStars = driver.findElement(myStarts);
		assertEquals("5", checkStars.getText());
	}

}
