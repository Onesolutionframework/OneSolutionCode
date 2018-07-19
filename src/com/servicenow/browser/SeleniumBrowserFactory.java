package com.servicenow.browser;



import com.servicenow.browser.SeleniumGridBrowserFactory;
import com.servicenow.utilities.FuncLib;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumBrowserFactory
        implements BrowserFactory
{
    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    public static final String IE = "ie";
    public static final String PHANTOMJS = "phantomjs";
    public static final String SAFARI = "safari";
    public static final String EDGE = "edge";
    private String browserType = WebConfig.getConfig().getDefaultBrowser();

    public SeleniumBrowserFactory(String browserType)
    {
        this.browserType = browserType;
    }

    public SeleniumBrowserFactory() {}

    public  WebDriver openBrowser()
    {
        if (shouldBeUsingGrid()) {
            //return createSeleniumGridBrowser();
        }
        return createLocalBrowser();
    }

    private Browser createSeleniumGridBrowser()
    {
        String gridUrl = WebConfig.getConfig().readMandatoryProperty(WebProperty.BROWSERFACTORY_SELENIUM_GRID_URL);
        SeleniumGridBrowserFactory gridFactory = new SeleniumGridBrowserFactory(gridUrl);

        gridFactory.setBrowser(WebConfig.getConfig().readProperty(WebProperty.BROWSERFACTORY_SELENIUM_GRID_BROWSER));
        gridFactory.setBrowserVersion(WebConfig.getConfig().readProperty(WebProperty.BROWSERFACTORY_SELENIUM_GRID_BROWSERVERSION));
        String platform = WebConfig.getConfig().readProperty(WebProperty.BROWSERFACTORY_SELENIUM_GRID_PLATFORM);
        if ((platform != null) && (!platform.trim().isEmpty())) {
            gridFactory.setPlatform(Platform.valueOf(platform.toUpperCase()));
        }
        return (Browser) gridFactory.openBrowser();
    }

    private  boolean shouldBeUsingGrid()
    {
        return WebConfig.getConfig().getBooleanProperty(WebProperty.BROWSERFACTORY_SELENIUM_RUNINGRID);
    }

    private WebDriver createLocalBrowser()
    {
        SeleniumBrowser.driver=getDriver(this.browserType);
        return SeleniumBrowser.driver;
    }

    public static WebDriver getDriver(String browserType)
    {
        if ((StringUtils.isEmpty(browserType)) || ("firefox".equals(browserType))) {
            System.setProperty("webdriver.gieco.driver", System.getProperty("user.dir") + "/src/main/resources/firefoxdriver.exe");
            return new FirefoxDriver(getBrowserCapabilities(browserType));
        }
        if ("chrome".equals(browserType)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
            return new ChromeDriver(getBrowserCapabilities(browserType));
        }
        if ("ie".equals(browserType)) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/resources/IEDriverServer.exe");
            return new InternetExplorerDriver(getBrowserCapabilities(browserType));
        }
        if ("phantomjs".equals(browserType)) {
            return new PhantomJSDriver();
        }
        if ("safari".equals(browserType)) {
            return new SafariDriver();
        }
        if ("edge".equals(browserType)) {
            return new EdgeDriver();
        }
        throw new RuntimeException(String.format("Unknown browser type: \"%s\"", new Object[] { browserType }));
    }

    public static DesiredCapabilities getBrowserCapabilities(String driverParameter)
    {
        DesiredCapabilities capabilities = null;
        if (driverParameter.equalsIgnoreCase("firefox")) {
            capabilities = DesiredCapabilities.firefox();
        }
        if (driverParameter.equalsIgnoreCase("ie"))
        {
            capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability("ignoreProtectedModeSettings", true);
            capabilities.setCapability("ie.ensureCleanSession", true);
        }
        if (driverParameter.equalsIgnoreCase("chrome")) {
            capabilities = DesiredCapabilities.chrome();
        }
        return capabilities;
    }

    public int hashCode()
    {
        return new HashCodeBuilder().append(this.browserType).toHashCode();
    }

    public String toString()
    {
        return new ToStringBuilder(this).append("browserType", this.browserType).toString();
    }

    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SeleniumBrowserFactory)) {
            return false;
        }
        SeleniumBrowserFactory rhs = (SeleniumBrowserFactory)obj;

        return new EqualsBuilder().append(this.browserType, rhs.browserType).isEquals();
    }
}

