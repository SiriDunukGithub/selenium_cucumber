package com.test.sirisha.utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigurationParser {
	static JSONParser jsonParser;
	static JSONObject jsonObject;
	static String env;
	private static ConfigurationParser singleton = new ConfigurationParser( );

   /* Static 'instance' method */
   public static ConfigurationParser getInstance( ) {
      return singleton;
   }

	public static String getHomeDir() {
		try {
			return (new File(".").getCanonicalPath());					
		} catch (IOException e) {
			return "";
		}
	}
	
	public static String getChromeDirver() {
		return (getHomeDir() + "\\src\\test\\resources\\drivers\\chromedriver.exe");					
	}
	
	public static String getJsonFile() {
		return (getHomeDir() + "\\src\\test\\resources\\config\\config.json");					
	}
	
	private ConfigurationParser() {
		jsonParser = new JSONParser();
		env = System.getProperty("environment");

		try {
			JSONObject jsonFileObject = (JSONObject) jsonParser.parse(new FileReader(getJsonFile()));
			jsonObject = (JSONObject)jsonFileObject.get(env);
		} catch (FileNotFoundException e) {
            e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUsername() {
		
		return (String)jsonObject.get("userName");
	}

	public static String getPassword() {
		return (String)jsonObject.get("password");
	}

	public static String getUrl() {
		return (String)jsonObject.get("url");
	}
	
	public static WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", ConfigurationParser.getChromeDirver());					
	    WebDriver driver= new ChromeDriver();					
	    driver.manage().window().maximize();
	    return driver;
	}
	
	public static String capitalize(String normalString) {
		String capitalString = normalString.substring(0, 1).toUpperCase() + normalString.substring(1).toLowerCase();
		return capitalString;
	}
}
