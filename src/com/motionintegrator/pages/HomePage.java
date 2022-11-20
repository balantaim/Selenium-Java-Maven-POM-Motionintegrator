package com.motionintegrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.motionintegrator.test.BaseTest;

public class HomePage extends BaseTest{
	
	By myHover = By.xpath("/html/body/div[1]/div/div/main/section[2]/div/div/div/article[1]/a");
	By tiresBtn = By.xpath("/html/body/div[1]/div/div/main/section[2]/div/div/div/article[1]/a/div");
	By choiceCity = By.xpath("/html/body/div/div/main/div/div[4]/div/a[9]");
	By section = By.xpath("/html/body/div[1]/div/main/div[3]/section[2]");
	By article = By.xpath("//article[@data-testid='listing-tile']");
	By imageOfTheElement = By.className("WorkshopImagestyled__Image-sc-1oc732e-4");
	By open = By.xpath("/html/body/div[1]/div/main/div/div[2]/div[2]/section/article[1]/div/section[1]/div/div/div/div[1]/ul/li/div");
	By myStarts = By.className("ReviewSummarystyled__Score-sc-1scryp4-2");
	
	public WebElement myHoverBtn() {
		return driver.findElement(myHover);
	}
	public WebElement myTiresBtn() {
		return driver.findElement(tiresBtn);
	}
	public WebElement choiceCity() {
		return driver.findElement(choiceCity);
	}
	public WebElement mySection() {
		return driver.findElement(section);
	}
	public WebElement myArticle() {
		return driver.findElement(article);
	}
	public WebElement myImageBtn() {
		return driver.findElement(imageOfTheElement);
	}

}
