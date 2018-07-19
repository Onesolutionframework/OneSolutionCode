package com.servicenow.zEnhancements;

import com.servicenow.utilities.BasePage;
import com.servicenow.utilities.ExceptionHandler;
import com.servicenow.utilities.Report;
import com.servicenow.utilities.SmartWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/**
 * Created by Muni on 5/4/17.
 */
public class FuncLib1 extends BasePage {
	public FuncLib1(WebDriver inputDriver) {
		super(inputDriver);
	}

	public  static void launch(String URL) throws ExceptionHandler {
		try {
			driver.get(URL);
			Report.log("pass", "Successfully application is launched, " + URL);

		}catch(Exception ex){
			throw new ExceptionHandler(ex);
		}
	}
	
	private static boolean mouseHover(WebDriver driver, By by) {
		try {			
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean doUntilAttributeChange(WebDriver driver, By sourceElement,By targetElement,String actionToPerformed,String attrib) throws InterruptedException{
		try{
			do
			{
				Report.log("done", "hover");
				WebElement ele1 = driver.findElement(sourceElement);
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',	true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				((JavascriptExecutor) driver).executeScript(mouseOverScript,ele1);
				TimeUnit.SECONDS.sleep(5);
			}while(driver.findElement(targetElement).isDisplayed()!=false);
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}

	public static boolean ElementIsClickable(By by) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		return element != null;
	}

	///$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	public static boolean iClick(By by, String sLabel){
		String locator=by.toString();
		try{
			WebElement strTempElement=getWebElement(by);
			if(strTempElement==null) {
				return false;
			}
			if(getWebElement(by).isEnabled() ){
				((JavascriptExecutor)driver).executeScript("window.focus();");
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
				getWebElement(by).click();
				Report.log("pass", "Clicked on "+"'"+sLabel+"'"+ " button");
				return true;
			}else{
				Report.log("fail", "'"+sLabel+"'" + " : Button is not enabled");
		}
		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}
		return false;
	}

	public static boolean iClick(String bys, String name) throws ExceptionHandler {
		By by=By.xpath(bys);
		String locator=by.toString();
		try{
			WebElement strTempElement=getWebElement(by);
			if(strTempElement==null) {
				return false;
			}
			if(strTempElement.isEnabled() ){
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", strTempElement);
				strTempElement.click();
				Report.log("pass", "Clicked on "+"'"+name+"'"+ " element");
				return true;
			}else{
				Report.log("fail", "'"+name+"'" + " : Button is not enabled");
			}
		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : element not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : element not visible");
		}catch(Exception ex){
			throw new ExceptionHandler(ex);
		}
		return false;
	}

	public boolean iClick(WebElement ele, String name){
		try{
			if(ele.isEnabled()){
				((JavascriptExecutor)driver).executeScript("window.focus();");
				ele.click();
				System.out.println("Clicked on "+"'"+name+"'"+ " button");
				return true;
			}else{
				System.out.println("'"+name+"'" + " : Button is not enabled");
				return false;
			}
		}catch(NoSuchElementException e){
			System.out.println(name + " : Button not found");
		}catch(ElementNotVisibleException e){
			System.out.println(name + " : Button not visible");
		}
		return false;
	}

	public static void iSendData(By by, String data,String name){
		String locator=by.toString();
		try{
			if(getWebElement(by).isEnabled()){
				((JavascriptExecutor)driver).executeScript("window.focus();");
				getWebElement(by).sendKeys(data);
				if(name.equalsIgnoreCase("Contrasena") || name.equalsIgnoreCase("password"))
					data="*******";
				Report.log("pass",data + " entered in "+"'"+name+"'"+ ".");
			}else{
				Report.log("fail","'"+name+"'" + " : edit field is not enabled");
			}
		}catch(NoSuchElementException e){
			Report.log("fail",locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail",locator + " : Button not visible");

		}catch(Exception e){
			System.out.println(e.getMessage());
			Report.log("fail","While entering data in " + name + " field, Error occurred: " +e.getMessage());
		}
	}

	public static void iSendData(String bys, String data,String name){
		By by = By.xpath(bys);
		String locator=by.toString();
		try{
			if(getWebElement(by).isEnabled()){
				((JavascriptExecutor)driver).executeScript("window.focus();");
				getWebElement(by).sendKeys(data);
				if(name.equalsIgnoreCase("Contrasena") || name.equalsIgnoreCase("password"))
					data="*******";
				Report.log("pass",data + " entered in "+"'"+name+"'"+ ".");
			}else{
				Report.log("fail","'"+name+"'" + " : edit field is not enabled");
			}
		}catch(NoSuchElementException e){
			Report.log("fail",locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail",locator + " : Button not visible");

		}catch(Exception e){
			System.out.println(e.getMessage());
			Report.log("fail","While entering data in " + name + " field, Error occurred: " +e.getMessage());
		}

	}

	public static void selectByValue(By by, String data,String name){
		String locator=by.toString();
		try{
			if(getWebElement(by).isEnabled()){
				((JavascriptExecutor) driver).executeScript("window.focus();");
				Select oSelect = new Select(getWebElement(by));
				oSelect.selectByValue(data);
				Report.log("pass", data + " entered in "+"'"+name+"'"+ ".");
			}else{
				Report.log("fail", "'"+name+"'" + " : edit field is not enabled");
			}

		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}catch(Exception e){
			Report.log("fail", "While entering data in " + name + " field, Error occurred: " +e.getMessage());
		}
	}

	public static void selectByVisibleText(By by, String data,String name){
		String locator=by.toString();
		try{
			if(getWebElement(by).isEnabled()){
				((JavascriptExecutor) driver).executeScript("window.focus();");
				Select oSelect = new Select(getWebElement(by));
				oSelect.selectByVisibleText(data);
				Report.log("pass", data + " entered in "+"'"+name+"'"+ ".");
			}else{
				Report.log("fail", "'"+name+"'" + " : edit field is not enabled");
			}

		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}catch(Exception e){
			Report.log("fail", "While entering data in " + name + " field, Error occurred: " +e.getMessage());
		}
	}

	public static void selectByVisibleText(String bys, String data,String name){
		By by=By.xpath(bys);
		String locator=by.toString();
		try{
			WebElement strTempElement=getWebElement(by);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", strTempElement);
			if(strTempElement.isEnabled()){
				Select oSelect = new Select(strTempElement);
				oSelect.selectByVisibleText(data);

				Report.log("pass", data + " entered in "+"'"+name+"'"+ ".");

			}else{
				Report.log("fail", "'"+name+"'" + " : edit field is not enabled");
			}

		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}catch(Exception e){
			Report.log("fail", "While entering data in " + name + " field, Error occurred: " +e.getMessage());
		}
	}

	public static WebElement getWebElement(By by){
		WebElement webElement = null;
		String strlocator=by.toString();
		try{
			waitForPageLoaded();
			//waitForJQueryProcessing(driver,60);

			WebElement dd = SmartWait.waitForElement(driver, by, DEFAULT_WAIT_4_ELEMENT);
			if (dd==null){
				System.out.println("element is not appeared");
				return null;
			}
			webElement = driver.findElement(by);

		}catch (StaleElementReferenceException ex) {
			System.out.println("StaleElementReferenceException ...");
		}catch(NoSuchElementException e){
			System.out.println(strlocator + " Element not found");
		}

		return webElement;
	}

	/*public static WebElement getWebElementAlias(By by){

		WebElement webElement = null;

		String strlocator=by.toString();
		try{

			waitForPageLoaded();

			//waitForJQueryProcessing(driver,60);

			WebElement dd =SmartWait.waitForElementToBeClickable(driver, by, 60);
			if (dd==null){
				System.out.println("element is not appeared");
				return null;
			}
			webElement = driver.findElement(by);

		}catch (StaleElementReferenceException ex) {
			System.out.println("StaleElementReferenceException ...");
		}catch(NoSuchElementException e){
			System.out.println(strlocator + " Element not found");
		}catch(InterruptedException e) {
			System.out.println(strlocator + " InterruptedException");

		}

		return webElement;
	}*/

	public WebElement waitForElementPresentForClickable(WebDriver driver, final By by, int timeOutInSeconds) {
		WebElement element;
		int attempts=0;
		int maxAttempts=5;
		timeOutInSeconds=10;
		while(attempts<=maxAttempts)
		{
			try{
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()

				WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
				element = wait.until(ExpectedConditions.elementToBeClickable(by));

				driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); //reset implicitlyWait
				return element; //return the element
			} catch (Exception e) {
				if(attempts==maxAttempts) {
					System.out.println(e.getMessage());
				}
				else
				{
					attempts=attempts+1;
					//continue;
				}
			}
		}
		return null;
	}

	/**
	  * Wait for the List<WebElement> to be present in the DOM, regardless of being displayed or not.
	  * Returns all elements within the current page DOM.
	  *
	  *
	  *
	  * @return List<WebElement> all elements within the current page DOM, or null (if the timeout is reached)
	  */
	public static List<WebElement> waitForListElementsPresent(WebDriver driver, final By by, int timeOutInSeconds) {
		List<WebElement> elements;
		try{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until((new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject) {
					return areElementsPresent(driverObject, by);
				}
			}));

			elements = driver.findElements(by);
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); //reset implicitlyWait
			return elements; //return the element
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private static boolean areElementsPresent(WebDriver driver, By by) {
		try {
			driver.findElements(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	private boolean isElementPresentAndDisplay(WebDriver driver, By by) throws InterruptedException {

		int attempts=0;
		int maxAttempts=5;
		while(attempts<=maxAttempts)
		{
			try {
				return driver.findElement(by).isDisplayed();
			} catch (Exception e) {
				if(attempts==maxAttempts)
				{
					System.out.println(e.getMessage());
					Thread.sleep(2000);
					return false;
				}
				else
				{
					attempts=attempts+1;
					//continue;
					Thread.sleep(10000);
				}
			}
	}
		return true;
}
	public static void waitForPageLoaded()  {
		try {
			/*WebDriver jsWaitDriver=driver;
			JavascriptExecutor jsExec = (JavascriptExecutor) driver;
			WebDriverWait jsWait = new WebDriverWait(jsWaitDriver, 10);
			ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) driver)
					.executeScript("return jQuery.active") == 0);

			//Get JQuery is Ready
			boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

			//Wait JQuery until it is Ready!
			if(!jqueryReady) {
				System.out.println("JQuery is NOT Ready!");
				//Wait for jQuery to load
				jsWait.until(jQueryLoad);
			} else {
				//System.out.println("JQuery is Ready!");
			}*/

			ExpectedCondition<Boolean> expectation = new
					ExpectedCondition<Boolean>() {
						public Boolean apply(WebDriver driver) {
							return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
						}
					};
			try {
				Thread.sleep(10);
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(expectation);
			} catch (Throwable error) {
				Report.log("fail","Timeout waiting for Page Load Request to complete.");
			}
		} catch (Exception error) {
			System.out.println("Timeout waiting for Page Load Request to complete.");
		}
	}



	public static void isReadonly(String locatorVal, String name, boolean bExpected) {
		boolean bActual =isReadonly(locatorVal, name);
		if ( bActual == bExpected){
			if(bExpected){
				Report.log("pass","'" + name + "' is Readonly field.");
			}else
				Report.log("pass","'" + name + "' is Editable field.");
		}else{
			if(bExpected){
				Report.log("fail","'" + name + "' is not Readonly field.");
			}else
				Report.log("fail","'" + name + "' is Readonly field.");
		}
	}

	public static boolean isReadonly(String locatorVal, String name) {
		By by=By.xpath(locatorVal);
		String locator=by.toString();
		try{
			WebElement strTempElement=getWebElement(by);
			if(strTempElement==null) {
				return false;
			}
			if(isAttribtuePresent(strTempElement,"readonly")==false) {
				return false;
			}
			else{
				String sVal=getAttributeValue(strTempElement,"readonly");
				//System.out.println(sVal);
				if(sVal.equalsIgnoreCase("true")) {
					return true;
				}
			}
		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}
		return false;
	}

	public static String getAttributeValue(String locatorVal, String prop) {
		By by=By.xpath(locatorVal);
		String locator=by.toString();
		try{
			WebElement strTempElement=getWebElement(by);
			if(strTempElement==null) {
				return "";
			}
			return getWebElement(by).getAttribute(prop);
		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}
		return "";
	}

	public static String getAttributeValue(WebElement ele, String prop) {
		try{
			return ele.getAttribute(prop);
		}catch(NoSuchElementException e){
			Report.log("fail", " element not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", " element not visible");
		}
		return "";
	}

	public static boolean isMandatory(String locatorVal, String name, boolean bExpected) {
		boolean bActual =isMandatory(locatorVal, name);
		if ( bActual == bExpected){
			if(bExpected){
				Report.log("pass","'" + name + "' is Mandatory field.");
			}else
				Report.log("pass","'" + name + "' is Not Mandatory field.");
			return true;
		}else{
			if(bExpected){
				Report.log("fail","'" + name + "' is not Mandatory field.");
			}else
				Report.log("fail","'" + name + "' is Mandatory field.");
			return false;
		}
	}

	public static boolean isMandatory(String locatorVal, String name) {
		By by=By.xpath(locatorVal);
		String locator=by.toString();
		try{
			WebElement strTempElement=getWebElement(by);
			if(strTempElement==null) {
				return false;
			}
			if(isAttribtuePresent(strTempElement,"mandatory")==false) {
				return false;
			}
			else{
				if(getAttributeValue(strTempElement,"mandatory").equalsIgnoreCase("true")) {
					return true;
				}
			}
		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}
		return false;
	}

	public static boolean isAttribtuePresent(WebElement element, String attribute) {
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null){
				result = true;
			}
		} catch (Exception e) {
			return result;
		}
		return result;
	}

	public static boolean isDisplayed(String locator, String name) {
		return driver.findElement(By.xpath(locator)).isDisplayed();

	}

	public static void VerifyDropdownValues(String locator, String opts, String name) {
	}

	public static void KeyPress(String locatorVal, String action) throws ExceptionHandler {
		try {
			By by = By.xpath(locatorVal);
			String locator = by.toString();

			WebElement strTempElement = getWebElement(by);
			if(action.equalsIgnoreCase("enter"))
				strTempElement.sendKeys(Keys.RETURN);
			else
				System.out.println("other actions yet to be defined!");
		}catch (Exception e){
			throw new ExceptionHandler(e);
		}
	}

	public static void KeyPress(String locatorVal, String action, String name) throws ExceptionHandler {
		try {
			By by = By.xpath(locatorVal);
			String locator = by.toString();

			WebElement strTempElement = getWebElement(by);
			if(action.equalsIgnoreCase("enter"))
				strTempElement.sendKeys(Keys.RETURN);
			else
				System.out.println("other actions yet to be defined!");
		}catch (Exception e){
			throw new ExceptionHandler(e);
		}
	}

	public static boolean isAutoPopulated(String locatorVal, String name) {

		By by=By.xpath(locatorVal);
		String locator=by.toString();
		try{
			WebElement strTempElement=getWebElement(by);
			String sActualVal=strTempElement.getAttribute("value").trim();
			if(sActualVal.equalsIgnoreCase("")){
				Report.log("fail","'" + name + "' field is blank!" );
				return false;
			}else
			{
				Report.log("pass","'" + name + "' field is autopopulated. Default value: " + sActualVal );
				return true;
			}

		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}
		return false;
	}

	public static String getElementText(String locatorVal) {
		By by=By.xpath(locatorVal);
		String locator=by.toString();
		try{
			WebElement strTempElement=getWebElement(by);
			if(strTempElement!=null) {
				String sActualVal = strTempElement.getText().trim();
				return sActualVal;
			}else{
				return null;
			}
		}catch(NoSuchElementException e){
			Report.log("fail", locator + " : Button not found");
		}catch(ElementNotVisibleException e){
			Report.log("fail", locator + " : Button not visible");
		}
		return null;
	}

	public static String getElementText(WebElement eLocator) {
		return eLocator.getText();
	}

	public static void SwitchToNewWindow() throws ExceptionHandler {
		Set<String> handles = driver.getWindowHandles() ;

		if(driver.getWindowHandles().size()<2)
			throw new ExceptionHandler("New Window is not opened");

		String myWindowHandle=driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
			if(!myWindowHandle.equalsIgnoreCase(winHandle))
				driver.switchTo().window(winHandle);
		}
	}



	public static void CloseChildWindowsAndSwitchToMainWindow(String mainWinHandle) {

		driver.switchTo().window(mainWinHandle);
		Set<String> handles = driver.getWindowHandles() ;


		for(String winHandle : driver.getWindowHandles()){
			if(!mainWinHandle.equalsIgnoreCase(winHandle))
				driver.close();
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(pMainFrame);
	}

	public static boolean WaitForUrlToChange(String originalUrl, Integer pollingTimeout, Integer pollingInterval) {
		new FluentWait<>(driver)
				.withTimeout(pollingTimeout, TimeUnit.SECONDS)
				.pollingEvery(pollingInterval, TimeUnit.SECONDS)
				.until((WebDriver driver1) -> !driver1.getCurrentUrl().equals(originalUrl));
		return true;
	}

	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
}
