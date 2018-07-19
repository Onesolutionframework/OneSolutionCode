package com.servicenow.browser;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class WebConfig
{
    private static final Logger LOG = LoggerFactory.getLogger(WebConfig.class);
    public static final WebConfig instance = new WebConfig();
    public static final String GALEN_USER_HOME_CONFIG_NAME = ".web.config";
    private Properties properties;

    private WebConfig()
    {
        try
        {
            loadConfig();
        }
        catch (Exception e)
        {
            LOG.trace("Cannot load web config", e);
        }
    }

    public Properties getProperties()
    {
        return this.properties;
    }

    private void loadConfig()
            throws IOException
    {
        this.properties = new Properties();
        loadConfigFromUserHome();
        loadConfigFromLocal();
    }

    private void loadConfigFromUserHome()
            throws IOException
    {
        String webconf = System.getProperty("user.dir") + "/src/main/resources/" + "web.config";
        InputStream stream = WebUtils.findFileOrResourceAsStream(webconf);
        if (stream != null) {
            loadFromStream(stream);
        }
    }

    private void loadConfigFromLocal()
            throws IOException
    {
        InputStream stream = WebUtils.findFileOrResourceAsStream(readProperty(WebProperty.GALEN_CONFIG_FILE));
        if (stream == null) {
            stream = WebUtils.findFileOrResourceAsStream("config");
        }
        loadFromStream(stream);
    }

    private void loadFromStream(InputStream stream)
            throws IOException
    {
        if (stream != null)
        {
            this.properties.load(stream);
            stream.close();
        }
        setSystemPropertiesFromConfig();
    }

    private void setSystemPropertiesFromConfig()
    {
        Enumeration<?> names = this.properties.propertyNames();
        while (names.hasMoreElements())
        {
            String name = names.nextElement().toString();
            //if (name.startsWith("$.")) {
                System.setProperty(name.substring(2), this.properties.getProperty(name));
            //}
        }
    }

    public static void reloadConfigFromPath(String configPath)
            throws IOException
    {
        getConfig().reloadConfig(configPath);
    }

    private void reloadConfig(String configPath)
            throws IOException
    {
        this.properties = new Properties();
        InputStream stream = WebUtils.findFileOrResourceAsStream(configPath);
        loadFromStream(stream);
    }

    private List<String> convertCommaSeparatedList(String text)
    {
        String[] arr = text.split(",");

        List<String> list = new LinkedList();
        for (String item : arr)
        {
            String itemText = item.trim();
            if (!itemText.isEmpty()) {
                list.add(itemText);
            }
        }
        return list;
    }

    public String readProperty(WebProperty property)
    {
        return this.properties.getProperty(property.propertyName,
                System.getProperty(property.propertyName, property.defaultValue));
    }

    public String readMandatoryProperty(WebProperty property)
    {
        String value = this.properties.getProperty(property.propertyName, System.getProperty(property.propertyName));
        if ((value == null) || (value.trim().isEmpty())) {
            throw new RuntimeException("Missing property: " + property.propertyName);
        }
        return value;
    }

    public static synchronized WebConfig getConfig()
    {
        return instance;
    }

    public void reset()
            throws IOException
    {
        loadConfig();
    }

    public int getRangeApproximation()
    {
        return Integer.parseInt(readProperty(WebProperty.GALEN_RANGE_APPROXIMATION));
    }

    public List<String> getReportingListeners()
    {
        return convertCommaSeparatedList(readProperty(WebProperty.GALEN_REPORTING_LISTENERS));
    }

    public String getDefaultBrowser()
    {
        return readProperty(WebProperty.DEFAULT_BROWSER);
    }

    public Integer getIntProperty(WebProperty property)
    {
        String value = readProperty(property);
        try
        {
            return Integer.valueOf(Integer.parseInt(value));
        }
        catch (Exception e)
        {
            throw new RuntimeException(String.format("Couldn't parse property \"%s\" from config file", new Object[] { property.propertyName }));
        }
    }

    public int getIntProperty(WebProperty property, int min, int max)
    {
        int value = getIntProperty(property).intValue();
        if ((value >= min) && (value <= max)) {
            return value;
        }
        throw new RuntimeException(String.format("Property \"%s\"=%d in config file is not in allowed range [%d, %d]", new Object[] { property.propertyName,
                Integer.valueOf(value), Integer.valueOf(min), Integer.valueOf(max) }));
    }

    public boolean getBooleanProperty(WebProperty property)
    {
        String value = readProperty(property);
        return Boolean.parseBoolean(value);
    }

    public int getLogLevel()
    {
        String value = readProperty(WebProperty.GALEN_LOG_LEVEL);
        if (StringUtils.isNumeric(value)) {
            return Integer.parseInt(value);
        }
        return 10;
    }

    public boolean getUseFailExitCode()
    {
        return getBooleanProperty(WebProperty.GALEN_USE_FAIL_EXIT_CODE);
    }

    public String getTestJsSuffix()
    {
        return readProperty(WebProperty.TEST_JS_SUFFIX);
    }

    public boolean shouldAutoresizeScreenshots()
    {
        return getBooleanProperty(WebProperty.SCREENSHOT_AUTORESIZE);
    }

    public boolean shouldCheckVisibilityGlobally()
    {
        return getBooleanProperty(WebProperty.SPEC_GLOBAL_VISIBILITY_CHECK);
    }

    public int getImageSpecDefaultTolerance()
    {
        return getIntProperty(WebProperty.SPEC_IMAGE_TOLERANCE).intValue();
    }

    /*public SpecImage.ErrorRate getImageSpecDefaultErrorRate()
    {
        return SpecImage.ErrorRate.fromString(readProperty(WebProperty.SPEC_IMAGE_ERROR_RATE));
    }*/

    public void setProperty(WebProperty property, String value)
    {
        this.properties.setProperty(property.propertyName, value);
    }

    public String getTestSuffix()
    {
        return readProperty(WebProperty.TEST_SUFFIX);
    }

    public String getStringProperty(WebProperty property)
    {
        return readProperty(property);
    }
}

