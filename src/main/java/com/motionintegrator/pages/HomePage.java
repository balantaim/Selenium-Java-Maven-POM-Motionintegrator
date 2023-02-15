package com.motionintegrator.pages;

import com.motionintegrator.base.PropertiesHelper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePageObject {

    // Check element in the browser with F12 -> console -> $x("<locator>")

    @FindBy(xpath = "//h2[text()='Opening hours']")
    WebElement open;

    final String myHover = "//span[text()='Tires change']",
            tiresBtn = "/html/body/div[1]/div/div/main/section[2]/div/div/div/article[1]/a/div",
            city = "//a[text()='Workshops Lublin']",
            myArticle = "//article[@data-testid='listing-tile']",
            imageOfTheElement = "WorkshopImagestyled__Image-sc-ycjnbx-4",
            myStars = "/html/body/div[1]/div/main/div/div[3]/div/section/section[1]/div/p[1]",
            mySection = "/html/body/div[1]/div/main/div[3]/section[2]";

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void loadPageUrl() {
        PropertiesHelper properties = new PropertiesHelper();
        driver.get(properties.baseUrl);
    }

    public void myTiresBtn() {
        scrollWithCustomValue(1000);
        WebElement hoverBtn = driver.findElement(By.xpath(myHover));
        hoverOverElement(hoverBtn);
        WebElement afterHover = waitUntilPresenceOfElement(By.xpath(tiresBtn), 15);
        afterHover.click();
    }

    public void choiceCity() {
        scrollWithCustomValue(1100);
        waitForVisibilityOf(By.xpath(city));
        WebElement choiceCity = driver.findElement(By.xpath(city));
        choiceCity.click();
    }

    public void mySection() {
        WebElement section = waitUntilPresenceOfElement(By.xpath(mySection), 15);
        section.findElements(By.xpath(myArticle)).get(1).findElement(By.className(imageOfTheElement)).click();
    }

    public boolean openHours() {
        waitForVisibilityOf(By.xpath("//h2[text()='Opening hours']"), 15);
        return (open == null ? false:open.isDisplayed());
    }

    public WebElement checkStars() {
        return waitUntilPresenceOfElement(By.xpath(myStars), 15);
    }

}
