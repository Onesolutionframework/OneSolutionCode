package com.servicenow.utilities;

import java.util.List;

import org.openqa.selenium.*;

import io.appium.java_client.AppiumDriver;

import static com.servicenow.utilities.FuncLib.getWebElement;
/**
 * Created by Muni on 5/4/17.
 */
public class JSE extends BasePage {



	@SuppressWarnings("rawtypes")
	public JSE(AppiumDriver inputDriver) {
		super(inputDriver);
	}

	public static void main(String[] args) {

	}

	public static void scroll(String locatorString) throws ExceptionHandler {
		By by=By.xpath(locatorString);
		String locator=by.toString();
		try{
			WebElement strTempElement=getWebElement(by);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", strTempElement);
		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}catch(Exception ex){
			throw new ExceptionHandler(ex);
		}
	}
	public static boolean selectByVisibleText(WebDriver driver,By by,String sVal) {
		try {
			WebElement select = driver.findElement(by);
	
			((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", select, sVal);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean iClick(WebDriver driver,By by) {
		try {
			WebElement element = driver.findElement(by);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			return true;
		}catch(Exception e) {
			return false;
		}
		
		/*
		 * This code will perform the click operation on the WebElement "we" after 100 ms:

			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			
			jse.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", we);
		 */
		 
	}

	public static void iClick(String bys, String name) throws ExceptionHandler {
		By by=By.xpath(bys);
		String locator=by.toString();
		try{
			WebElement strTempElement=driver.findElement(By.xpath(bys));
			if(strTempElement.isEnabled() ){
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", strTempElement);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", strTempElement);
				Report.log("pass", "Clicked on "+"'"+name+"'"+ " button");

			}else{
				Report.log("fail", "'"+name+"'" + " : Button is not enabled");
			}
		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}catch(Exception ex){
			throw new ExceptionHandler(ex);
		}


		/*
		 * This code will perform the click operation on the WebElement "we" after 100 ms:

			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;

			jse.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", we);
		 */

	}
	
	public static boolean jsClick(WebDriver driver,By by) {
		try {
			WebElement element=driver.findElement(by);
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				return true;
			} else {
				System.out.println("Unable to click on element");
				return false;
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
		return false;
		
		/*
		 * This code will perform the click operation on the WebElement "we" after 100 ms:

			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			
			jse.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", we);
		 */
		 
	}
	
	
	public static void selectCheckboxByName(WebDriver driver,String name) {
		try {


				// Find the checkbox or radio button element by its name.
				List<WebElement> list = driver.findElements(By.name("checkbox"));
			
				// Get the number of checkboxes available.
				int count = list.size();
			
				// Now, iterate the loop from first checkbox to last checkbox.
				for (int i = 0; i < count; i++) {
			
					if((list.get(i).isSelected()))
						return;
					// Store the checkbox name to the string variable, using 'Value'
					// attribute
					String sValue = list.get(i).getAttribute("value");
			
					// Select the checkbox if its value is the same that you want.
					if (sValue.equalsIgnoreCase("checkbox")) {
			
						list.get(i).click();
			
						// This statement will get you out of the for loop.
						break;
					}
			
				}
		}catch(Exception e) {
			return;
		}
		
	}
	
	public static void RightClick(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		String javaScript = "var evt = document.createEvent('MouseEvents');"
		                + "var RIGHT_CLICK_BUTTON_CODE = 2;"
		                + "evt.initMouseEvent('contextmenu', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, RIGHT_CLICK_BUTTON_CODE, null);"
		                + "arguments[0].dispatchEvent(evt)";
	
		js.executeScript(javaScript, element);
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void RightClick(String bys) throws ExceptionHandler {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		By by=By.xpath(bys);
		String locator=by.toString();
		try {
			WebElement strTempElement = getWebElement(by);

			String javaScript = "var evt = document.createEvent('MouseEvents');"
					+ "var RIGHT_CLICK_BUTTON_CODE = 2;"
					+ "evt.initMouseEvent('contextmenu', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, RIGHT_CLICK_BUTTON_CODE, null);"
					+ "arguments[0].dispatchEvent(evt)";

			js.executeScript(javaScript, strTempElement);

		}catch (Exception e){
			throw new ExceptionHandler(e);
		}
	}

	public String getVal(WebElement webElement) {
		JavascriptExecutor e = (JavascriptExecutor) driver;
		return (String) e.executeScript(String.format("return $('#%s').val();", webElement.getAttribute("id")));
	}

	public static void mouseHover(WebElement element) throws InterruptedException {
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',	true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScript,element);
		Thread.sleep(3);
	}
}
