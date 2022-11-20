package com.motionintegrator.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	protected static WebDriver driver;
	
	 public String browser;
	 public String baseUrl;
	 public Properties properties;
	 
	 private void loadProperties() {
	        FileInputStream fis = null;

	        try {
	            properties = new Properties();
	            fis = new FileInputStream("C:\\Users\\Balantaim\\eclipse-workspace\\MotionIntegrator-Test-Maven\\src\\config\\config.properties");
	            properties.load(fis);

	            browser = properties.getProperty("browser");
	            baseUrl = properties.getProperty("baseUrl");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                fis.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private void openBrowser() {
	        if (browser.equals("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        }
	        driver.manage().window().maximize();
	        //Delete all cookies if it necessary
			//driver.manage().deleteAllCookies();
			//Setup timeout
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
	    }

	    public void closeBrowser() {
	        driver.quit();
	    }

	    public void closeWindow() {
	        driver.close();
	    }

	    public Boolean goToHomepage() {
	        try {
	            loadProperties();
	            openBrowser();
	            driver.get(baseUrl);
	        } catch (Exception e) {
	            System.out.println("Unable to navigate to the homepage");
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }
}
