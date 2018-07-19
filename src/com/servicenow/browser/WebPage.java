/*
package com.servicenow.browser;

import jdk.internal.org.xml.sax.Locator;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class WebPage extends SeleniumBrowser
{
    private WebDriver driver;
    private Map<String, WebElement> cachedPageElements = new HashMap();
    private WebElement parentObject;
    private BufferedImage cachedScreenshotImage;
    private File cachedScreenshotFile;
    private int offsetLeft = 0;
    private int offsetTop = 0;

    public WebPage(WebDriver driver) {
        super(driver);
    }

    private WebElement findObjectContext(SearchContext searchContext, Locator objectContextLocator)
    {
        if (objectContextLocator != null)
        {
            ByChain byChain = ByChain.fromLocator(objectContextLocator);
            if (byChain == null) {
                throw new RuntimeException("Cannot convert locator " + objectContextLocator.prettyString());
            }
            return byChain.findElement(searchContext);
        }
        throw new IllegalArgumentException("objectContextLocator cannot be null");
    }

    public PageElement getObject(Locator objectLocator)
    {
        return locatorToElement("unnamed", objectLocator);
    }

    public PageElement getObject(String objectName, Locator objectLocator)
    {
        if (objectName != null)
        {
            PageElement pageElement = (PageElement)this.cachedPageElements.get(objectName);
            if (pageElement == null)
            {
                pageElement = getObject(objectLocator);
                this.cachedPageElements.put(objectName, pageElement);
                return pageElement;
            }
            return pageElement;
        }
        return locatorToElement("unnamed", objectLocator);
    }

    private List<WebElement> driverFindElements(ByChain byChain)
    {
        return byChain.findElements(this.driverSearchContext);
    }

    private WebElement driverFindElement(ByChain byChain)
    {
        return byChain.findElement(this.driverSearchContext);
    }

    private PageElement locatorToElement(String objectName, Locator objectLocator)
    {
        ByChain byChain = ByChain.fromLocator(objectLocator);
        PageElement pageElement;
        try
        {
            WebElement webElement = driverFindElement(byChain);
            pageElement = new WebPageElement(this.driver, objectName, webElement, objectLocator).withOffset(this.offsetLeft, this.offsetTop);
        }
        catch (NoSuchElementException e)
        {
            PageElement pageElement;
            pageElement = new AbsentPageElement();
        }
        return pageElement;
    }

    public PageElement getSpecialObject(String objectName)
    {
        if ("screen".equals(objectName)) {
            return new ScreenElement(this.driver).withOffset(this.offsetLeft, this.offsetTop);
        }
        if ("viewport".equals(objectName)) {
            return new ViewportElement(this.driver);
        }
        if (("parent".equals(objectName)) || ("self".equals(objectName)))
        {
            if (this.parentObject != null) {
                return this.parentObject;
            }
            throw new RuntimeException("There is no " + objectName + " object defined on page");
        }
        return null;
    }

    public int getObjectCount(Locator locator)
    {
        return driverFindElements(ByChain.fromLocator(locator)).size();
    }

    public Page createObjectContextPage(Locator objectContextLocator)
    {
        return new WebPage(this.driver, this.driverSearchContext, objectContextLocator);
    }

    public File getScreenshotFile()
    {
        if (this.cachedScreenshotFile == null) {
            this.cachedScreenshotFile = createNewScreenshot();
        }
        return this.cachedScreenshotFile;
    }

    private File createNewScreenshot()
    {
        try
        {
            if (WebConfig.getConfig().getBooleanProperty(WebProperty.SCREENSHOT_FULLPAGE)) {
                return GalenUtils.makeFullScreenshot(this.driver);
            }
            return makeSimpleScreenshot();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error making screenshot", e);
        }
    }

    private File makeSimpleScreenshot()
            throws IOException
    {
        return GalenUtils.takeScreenshot(this.driver);
    }

    public void setScreenshot(File screenshotFile)
    {
        this.cachedScreenshotFile = screenshotFile;
    }

    public BufferedImage getScreenshotImage()
    {
        if (this.cachedScreenshotImage == null) {
            try
            {
                this.cachedScreenshotImage = Rainbow4J.loadImage(getScreenshotFile().getAbsolutePath());
            }
            catch (Exception e)
            {
                throw new RuntimeException("Couldn't take screenshot for page", e);
            }
        }
        return this.cachedScreenshotImage;
    }

    public String getTitle()
    {
        return this.driver.getTitle();
    }

    public void switchToFrame(PageElement mainObject)
    {
        WebPageElement webPageElement = (WebPageElement)mainObject;
        this.driver.switchTo().frame(webPageElement.getWebElement());
    }

    public void switchToParentFrame()
    {
        this.driver.switchTo().parentFrame();
    }

    public Page createFrameContext(PageElement frameElement)
    {
        WebPage framePage = new WebPage(this.driver);

        Rect mainObjectArea = frameElement.getArea();
        framePage.setOffset(mainObjectArea.getLeft(), mainObjectArea.getTop());
        framePage.switchToFrame(frameElement);
        framePage.setParentObject(frameElement);
        return framePage;
    }

    private void setOffset(int offsetLeft, int offsetTop)
    {
        this.offsetLeft = offsetLeft;
        this.offsetTop = offsetTop;
    }

    public PageElement getParentObject()
    {
        return this.parentObject;
    }

    public void setParentObject(PageElement parentObject)
    {
        this.parentObject = parentObject;
    }

    public WebDriver getDriver()
    {
        return this.driver;
    }
}*/
