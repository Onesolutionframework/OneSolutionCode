package com.servicenow.browser;

public enum WebProperty
{
    SCREENSHOT_AUTORESIZE("galen.screenshot.autoresize", "true"),
    SCREENSHOT_FULLPAGE("galen.browser.screenshots.fullPage", "false"),
    SCREENSHOT_FULLPAGE_SCROLLTIMEOUT("galen.browser.screenshots.fullPage.scrollTimeout", "250"),
    SCREENSHOT_FULLPAGE_SCROLLWAIT("galen.browser.screenshots.fullPage.scrollWait", "0"),
    SPEC_IMAGE_TOLERANCE("galen.spec.image.tolerance", "25"),
    SPEC_IMAGE_ERROR_RATE("galen.spec.image.error", "0px"),
    SPEC_GLOBAL_VISIBILITY_CHECK("galen.spec.global.visibility", "true"),
    TEST_JS_SUFFIX("galen.test.js.file.suffix", ".test.js"),
    TEST_SUFFIX("galen.test.file.suffix", ".test"),
    TEST_JAVA_REPORT_OUTPUTFOLDER("galen.test.java.report.outputFolder", "target/galen-html-reports"),
    TEST_JAVA_TIMEOUT_PAGELOAD("galen.test.java.timeout.pageLoad", "20"),
    TEST_JAVA_TIMEOUT_IMPLICITYWAIT("galen.test.java.timeout.implicitWait", "1"),
    GALEN_CONFIG_FILE("galen.config.file", "galen.config"),
    GALEN_RANGE_APPROXIMATION("galen.range.approximation", "2"),
    GALEN_REPORTING_LISTENERS("galen.reporting.listeners", ""),
    DEFAULT_BROWSER("default.browser", "chrome"),
    GALEN_LOG_LEVEL("galen.log.level", "10"),
    GALEN_USE_FAIL_EXIT_CODE("galen.use.fail.exit.code", "true"),
    SPEC_COLORSCHEME_TOLERANCE("spec.colorscheme.tolerance", "3"),
    BROWSERFACTORY_SELENIUM_RUNINGRID("browserFactory.selenium.runInGrid", "false"),
    BROWSERFACTORY_SELENIUM_GRID_URL("browserFactory.selenium.grid.url", null),
    BROWSERFACTORY_SELENIUM_GRID_BROWSER("browserFactory.selenium.grid.browser", null),
    BROWSERFACTORY_SELENIUM_GRID_BROWSERVERSION("browserFactory.selenium.grid.browserVersion", null),
    BROWSERFACTORY_SELENIUM_GRID_PLATFORM("browserFactory.selenium.grid.platform", null),
    GALEN_BROWSER_VIEWPORT_ADJUSTSIZE("galen.browser.viewport.adjustSize", "false"),
    GALEN_BROWSER_PAGELEMENT_AREAFINDER("galen.browser.pageElement.areaFinder", "native"),
    GALEN_BROWSER_PAGELEMENT_AREAFINDER_CUSTOM_SCRIPT("galen.browser.pageElement.areaFinder.custom.script", null),
    FILE_CREATE_TIMEOUT("galen.file.wait.timeout", "30"),
    DEFAULT_WAIT_4_ELEMENT("default.wait.4.element","30"),
    DEFAULT_WAIT_4_PAGE("default.wait.4.page","60");

    protected final String propertyName;
    protected final String defaultValue;

    private WebProperty(String propertyName, String defaultValue)
    {
        this.propertyName = propertyName;
        this.defaultValue = defaultValue;
    }
}
