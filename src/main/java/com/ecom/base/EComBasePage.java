package com.ecom.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ecom.util.EComTestUtil;
import com.ecom.util.WebDriverEventListenerImpl;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EComBasePage {

	public static WebDriver driver;

	public static Properties prop;

	public static EventFiringWebDriver e_driver;

	public static WebDriverEventListenerImpl e_listener;

	public EComBasePage() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\indeztruk\\eclipse-workspace\\ECommerceQAPage\\src\\main\\java\\com\\ecom\\config\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initilization() {
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// remember this too!!
		e_driver = new EventFiringWebDriver(driver);
		e_listener = new WebDriverEventListenerImpl();
		e_driver.register(e_listener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(EComTestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(EComTestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
