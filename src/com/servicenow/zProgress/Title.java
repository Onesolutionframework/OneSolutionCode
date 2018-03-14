package com.servicenow.zProgress;

import com.servicenow.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by Deepak on 5/4/17.
 */
public class Title extends BasePage {

    public Title(WebDriver inputDriver) {
        super(inputDriver);
    }

    public void TitleTest(){
        Assert.assertEquals(driver.getTitle(), "KC Breaking News, Sports, Weather & More | KansasCity.com & The Kansas City Star");
        System.out.println(driver.getTitle());
    }

    @FindBy(xpath = ("//*[@id='login-subscribe']/ul/li[1]/a"))
    private WebElement signIn;
    public void clickSignIn(){
        signIn.click();
    }

}
