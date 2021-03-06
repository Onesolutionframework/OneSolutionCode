package com.project.browser;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.galenframework.browser.Browser;
import com.galenframework.browser.BrowserFactory;
import com.galenframework.browser.SeleniumBrowser;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridBrowserFactory implements BrowserFactory {

    private String gridUrl;
    private String browser;
    private String browserVersion;
    private Platform platform;
    private Map<String, String> desiredCapabilities = new HashMap<>();

    public SeleniumGridBrowserFactory(String gridUrl) {
        this.setGridUrl(gridUrl);
    }

    @Override
    public Browser openBrowser() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        if (platform != null) {
            desiredCapabilities.setPlatform(platform);
        }

        if (browser != null) {
            desiredCapabilities.setBrowserName(browser);
        }

        if (browserVersion != null) {
            desiredCapabilities.setVersion(browserVersion);
        }

        for (Map.Entry<String, String> dc : this.desiredCapabilities.entrySet()) {
            desiredCapabilities.setCapability(dc.getKey(), dc.getValue());
        }

        try {

            WebDriver driver = new RemoteWebDriver(new URL(gridUrl), desiredCapabilities);
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            return new SeleniumBrowser(augmentedDriver);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public com.project.browser.SeleniumGridBrowserFactory withBrowser(String browser) {
        this.setBrowser(browser);
        return this;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public com.project.browser.SeleniumGridBrowserFactory withBrowserVersion(String browserVersion) {
        this.setBrowserVersion(browserVersion);
        return this;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public com.project.browser.SeleniumGridBrowserFactory withPlatform(Platform platform) {
        this.setPlatform(platform);
        return this;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getGridUrl() {
        return gridUrl;
    }

    public void setGridUrl(String gridUrl) {
        this.gridUrl = gridUrl;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder() //@formatter:off
                .append(this.browser)
                .append(this.browserVersion)
                .append(this.gridUrl)
                .append(this.platform)
                .append(this.desiredCapabilities)
                .toHashCode(); //@formatter:on
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this) //@formatter:off
                .append("browser", this.browser)
                .append("browserVersion", this.browserVersion)
                .append("gridUrl", this.gridUrl)
                .append("platform", this.platform)
                .append("desiredCapabilities", this.desiredCapabilities)
                .toString(); //@formatter:on
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.galenframework.browser.SeleniumGridBrowserFactory)) {
            return false;
        }
        com.project.browser.SeleniumGridBrowserFactory rhs = (com.project.browser.SeleniumGridBrowserFactory)obj;

        return new EqualsBuilder() //@formatter:off
                .append(this.browser, rhs.browser)
                .append(this.browserVersion, rhs.browserVersion)
                .append(this.gridUrl, rhs.gridUrl)
                .append(this.platform, rhs.platform)
                .append(this.desiredCapabilities, desiredCapabilities)
                .isEquals(); //@formatter:on
    }

    public com.project.browser.SeleniumGridBrowserFactory withDesiredCapability(String name, String value) {
        desiredCapabilities.put(name, value);
        return this;
    }

    public void setDesiredCapabilites(Map<String, String> desiredCapabilities) {
        this.desiredCapabilities = desiredCapabilities;
    }

}

