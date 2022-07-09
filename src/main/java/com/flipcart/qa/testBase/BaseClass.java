package com.flipcart.qa.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.flipcart.qa.util.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public BaseClass(){
		try {
			prop = new Properties();
			String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\flipcart\\qa\\config\\config.properties";
			System.out.println(path);
			FileInputStream fil;
			fil = new FileInputStream(path);
			prop.load(fil);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void browserInitialisation()
	{
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("FF")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitwait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
