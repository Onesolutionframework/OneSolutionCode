package com.servicenow.browser;


import org.openqa.selenium.WebDriver;

import java.awt.*;

public abstract interface Browser
{
    public abstract void quit();

    public abstract void changeWindowSize(Dimension paramDimension);

    public abstract void load(String paramString);

    public abstract Object executeJavascript(String paramString);

    //public abstract Page getPage();

    public abstract void refresh();

    public abstract String getUrl();

    public abstract Dimension getScreenSize();


}