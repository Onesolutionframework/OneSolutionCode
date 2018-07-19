package com.project.zEnhancements;

import com.project.utilities.BasePage;
import com.project.utilities.ExceptionHandler;
import com.project.utilities.Report;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.project.utilities.FuncLib.getWebElement;
/**
 * Created by Muni on 5/4/17.
 */
public class JSE1 extends BasePage {

	@SuppressWarnings("rawtypes")
	public JSE1(AppiumDriver inputDriver) {
		super(inputDriver);
	}

	public static void main(String[] args) {

	}

	public static boolean scroll_Script(String locatorString) throws ExceptionHandler {
		By by=By.xpath(locatorString);
		String locator=by.toString();
		try{
			WebElement strTempElement=getWebElement(by);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", strTempElement);
			return true;
		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}catch(Exception ex){
			throw new ExceptionHandler(ex);
		}
		return false;
	}
	public static boolean selectByVisibleText_Script(WebDriver driver,By by,String sVal) {
		try {
			WebElement select = driver.findElement(by);
			((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", select, sVal);
			return true;
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
		return false;
	}
	
	public static boolean iClick_Script(WebDriver driver,By by) {
		try {
			WebElement element=driver.findElement(by);
			if (element.isEnabled() && element.isDisplayed()) {
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
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

	public static boolean iClick_Script(String bys, String name) throws ExceptionHandler {
		By by=By.xpath(bys);
		String locator=by.toString();
		try{
			WebElement strTempElement=driver.findElement(By.xpath(bys));
			if(strTempElement.isEnabled() ){
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", strTempElement);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", strTempElement);
				Report.log("pass", "Clicked on "+"'"+name+"'"+ " button");
				return true;
			}else{
				Report.log("fail", "'"+name+"'" + " : Button is not enabled");
				return false;
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

		return false;
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
	
	
	public static boolean selectCheckboxByName(WebDriver driver,String name) {
		try {
			// Find the checkbox or radio button element by its name.
			List<WebElement> list = driver.findElements(By.name("checkbox"));

			// Get the number of checkboxes available.
			int count = list.size();

			// Now, iterate the loop from first checkbox to last checkbox.
			for (int i = 0; i < count; i++) {

				if((list.get(i).isSelected()))
					return true;
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
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
		return false;
	}
	
	public static boolean RightClick(WebElement element){
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String javaScript = "var evt = document.createEvent('MouseEvents');"
							+ "var RIGHT_CLICK_BUTTON_CODE = 2;"
							+ "evt.initMouseEvent('contextmenu', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, RIGHT_CLICK_BUTTON_CODE, null);"
							+ "arguments[0].dispatchEvent(evt)";
			js.executeScript(javaScript, element);

			TimeUnit.SECONDS.sleep(1000);
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
		return false;
	}

	public static void RightClick(String bys) throws ExceptionHandler {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			By by=By.xpath(bys);
			String locator=by.toString();
			WebElement strTempElement = getWebElement(by);
			String javaScript = "var evt = document.createEvent('MouseEvents');"
					+ "var RIGHT_CLICK_BUTTON_CODE = 2;"
					+ "evt.initMouseEvent('contextmenu', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, RIGHT_CLICK_BUTTON_CODE, null);"
					+ "arguments[0].dispatchEvent(evt)";
			js.executeScript(javaScript, strTempElement);
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		}catch (Exception e){
			throw new ExceptionHandler(e);
		}
	}

	public String getVal(WebElement webElement) {
		JavascriptExecutor e = (JavascriptExecutor) driver;
		return (String) e.executeScript(String.format("return $('#%s').val();", webElement.getAttribute("id")));
	}
/*
	public static boolean mouseHover(WebElement element) throws InterruptedException {
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',	true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScript,element);
		Thread.sleep(3);
		return true;
	}
*/

	/**
	 * Uses {@code JavascriptExecutor} with the specified driver to perform a hover on the specified element.
	 *
	 * @param driver  the {@code WebDriver} to use with {@code JavascriptExecutor} for performing the hover
	 * @param element the {@code WebElement} to hover
	 */
	public static boolean mouseHover(WebElement element){
		String script = "if(document.createEvent) {" +
				"var evObj = document.createEvent('MouseEvents');" +
				"evObj.initEvent( 'mouseover', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
				"arguments[0].dispatchEvent(evObj);" +
				"} else if( document.createEventObject ) {" +
				"arguments[0].fireEvent('onmouseover');" +
				"}";

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(script, element);
		return true;
	}
}
