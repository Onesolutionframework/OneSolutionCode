package com.project.utilities;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Muni on 5/4/17.
 */
public class WebDriverCapabilities {

    private DesiredCapabilities caps = null;

    private DesiredCapabilities getCapabiltyObject(){
        return new DesiredCapabilities();
    }

    public DesiredCapabilities getDesiredCapability(){
        return caps;
    }


    public DesiredCapabilities setDesiredCapabilities(String platform, String browser, String browserVersion){

        caps = new DesiredCapabilities();

        caps.setCapability(CapabilityType.PLATFORM, platform);
        caps.setCapability(CapabilityType.BROWSER_NAME, browser);
        caps.setCapability(CapabilityType.VERSION, browserVersion);

        return caps;
    }

    public DesiredCapabilities setDesiredCapabilities(){

        if(caps == null){
            caps = getCapabiltyObject();
        }
        caps.setCapability(CapabilityType.PLATFORM, "Windows 10");
        caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        caps.setCapability(CapabilityType.VERSION, "54");
        caps.setCapability("name", "Escenic Web Application Test");

        return caps;
    }


    public void createCapability(){

    }

    public void setAllCapabilities(){

    }
}
