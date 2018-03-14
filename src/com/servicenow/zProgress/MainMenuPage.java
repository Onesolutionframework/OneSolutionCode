package com.servicenow.zProgress;

/**
 * Created by V0067376 on 5/8/2017.
 */

import com.servicenow.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by V0067376 on 5/6/2017.
 */
public class MainMenuPage extends BasePage {
    public MainMenuPage(WebDriver inputDriver) {
        super(inputDriver);
    }

    @FindBy(id = "masthead-container")
    private WebElement mastHead;

    @FindBy(css="#main-nav button")
    private WebElement fullMenu;

    @FindBy(css = "[role='main'] article .title")
    private List<WebElement> Articles;

    public boolean exists() {
        return mastHead != null;
    }

    public WebElement getFullMenu(){
        return fullMenu;
    }

    public  WebElement getLoginLink() {
        return getSubscribeLinks().get(0);
    }

    public  List<WebElement> getSubscribeLinks() {
        // List<WebElement> getLogSubscribeLinks = driver.findElements(By.cssSelector("#login-subscribe .paywall-links a"));
        return  driver.findElements(By.cssSelector("#login-subscribe .paywall-links a"));
    }

    public  WebElement getSubscribeLink() {
        return getSubscribeLinks().get(1);
    }

    public boolean hasArticles() {
        return getArticles().size() > 0;
    }

    public List<WebElement> getArticles() {
        return Articles;
    }

}
