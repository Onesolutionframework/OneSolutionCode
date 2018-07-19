package com.project.pages;

import com.project.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.project.utilities.FuncLib.*;

public class CreateKnowledgeArticle extends BasePage{
    public static String pCaption="//nav[@class='navbar navbar-default section_zero ']//div[@class='navbar-title-caption']";
    public static String num = "//*[@id='kb_knowledge.number']";
    public static String topic="//*[@id='kb_knowledge.topic']";
    public static String opts="Service Desk|Field Services|L2Ops|IMS|Peoplesoft Support";
    public static String catagory="//*[@id='kb_knowledge.category']";
    public static String ConfigItem="//*[@id='sys_display.kb_knowledge.cmdb_ci']";
    public static String pConfigurationItemSearchButton="//*[@id='lookup.kb_knowledge.cmdb_ci']";
    public static String SearchField="//*[@class='input-group']//input[contains(@id,'_text')]";
    public static String FilterLink="//a[text()='Name contains ";
    public static String TableFirstItem="//div[@class=' ']//table[contains(@class,'data_list_table list_table table table-hover')]/tbody//tr[1]/td[3]/a";
    public static String pVersionNumber="//*[@id='kb_knowledge.u_version_number']";
    public static String pNextAuditDate="//*[@id='kb_knowledge.u_next_audit_date']";
    public static String pState="//*[@id='kb_knowledge.workflow_state']";
    public static String pAssignedTo="//*[@id='sys_display.kb_knowledge.u_assigned_to']";
    public static String pAssignedToSearchButton="//*[@id='lookup.kb_knowledge.u_assigned_to']";
    public static String pKnowledgeOwner="//*[@id='sys_display.kb_knowledge.u_knowledge_owner']";
    public static String pKnowledgeOwnerSearchButton="//*[@id='lookup.kb_knowledge.u_knowledge_owner']";
    public static String pAuditCycle="//*[@id='kb_knowledge.u_audit_cycle']";
    public static String pShortDescription="//*[@id='kb_knowledge.short_description']";
    public static String pNotificationForPublishing="//*[@id='kb_knowledge.u_notification_for_publishing']";
    public static String pComments="//*[@id='kb_knowledge.u_comment']";
    public static String pText="//*[@id='tinymce']";  //THIS LOCATOR MAY NOT WORK, PLEASE CHECK AGAIN
    public static String pParentOfText="//*[@class='mce-tinymce mce-container mce-panel']";
    public static String pPublished="//*[@id='kb_knowledge.published']";
    public static String pSubmissionType="//*[@id='kb_knowledge.u_submission_type']";
    public static String pSubmit="(//*[@id='submit_click'])[1]";

    public CreateKnowledgeArticle(WebDriver inputDriver) {
        super(inputDriver);
    }
    {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(pMainFrame);
    }

    public static boolean VerifyCaption() throws ExceptionHandler {
        try {
            return NavBar.getNavTitle().contains("Knowledge");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }
    public static void Validation() throws ExceptionHandler {
        try{
            isReadonly(num, "Number", true);
            isAutoPopulated(num, "Number");
            isMandatory(topic, "Topic", true);
            isReadonly(ConfigItem, "Configuration Item", false);
            isReadonly(pVersionNumber, "Version Number", true);
            isReadonly(pNextAuditDate, "Next Audit Date", true);
            isReadonly(pState, "State", true);
            isReadonly(pPublished, "Published", true);
            isReadonly(pAssignedTo, "AssignedTo", false);
            isReadonly(pKnowledgeOwner, "KnowledgeOwner", false);
            isMandatory(pAuditCycle, "AuditCycle", true);
            isReadonly(pShortDescription, "ShortDescription", false);
            isReadonly(pNotificationForPublishing, "NotificationForPublishing", false);
            isReadonly(pComments, "Comments", false);
            //isMandatory(pParentOfText,"Text",true);
            isMandatory(pSubmissionType, "SubmissionType", true);
        }catch (Exception e){
                throw new ExceptionHandler(e);
        }
    }

    public static String captureNumber() throws ExceptionHandler {
        try{
            return getElementText(num);
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void verifyNumberAutoPopulated() throws ExceptionHandler {
        try {
            String currentVal = driver.findElement(By.xpath(num)).getAttribute("value");
            if (currentVal.trim().equalsIgnoreCase("")) {
                Report.log("fail", "Initial value of Number is blank");
            } else {
                Report.log("pass", "Number is Autopopulated with '" + currentVal + "'");
            }
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void verifyTopicDropdownValues(String opts) throws ExceptionHandler {
        try {
            String expectedVal = "Service Desk";
            VerifyDropdownValues(topic, opts, "Topic");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void selectTopic(String opt) throws ExceptionHandler {
        try{
            FuncLib.selectByVisibleText(topic,opt,"Topic");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void verifyCatagoryDropdownValues() throws ExceptionHandler {
        try {
            String opts = "Service Desk|Field Services|L2Ops|IMS|Peoplesoft Support";
            VerifyDropdownValues(catagory, opts, "Catagory");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void selectCatagory(String opt) throws ExceptionHandler {
        try {
            String expectedVal = "Account";
            selectByVisibleText(catagory, opt, "Catagory");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void Lookup(String SearchButton,String SearchData, String name) throws ExceptionHandler {
        try {
            //iClick(ConfigurationItemSearchButton,name + "SearchButton");
            do {
                //JSE.iClick(ConfigurationItemSearchButton, name + "SearchButton");
                IActions.iClick(SearchButton, name + "SearchButton");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (driver.getWindowHandles().size() < 2);

            String mainWinHandle = driver.getWindowHandle();
            SwitchToNewWindow();
            if (SmartWait.waitForElementVisible(driver, By.xpath(SearchField), 60) == null) {
                Report.log("fail", "Search field is not enabled.");
                throw new ExceptionHandler("Search field is not enabled.");
            } else {
                Report.log("pass", "Search field is enabled.");
            }
            String filterSelect = "//*[@class='input-group-addon input-group-select']//select";

            selectByVisibleText(filterSelect, "Name", "GoTo");

            iSendData(SearchField, SearchData, "Search");

            KeyPress(SearchField, "enter");
            String pFilterLink = FilterLink + SearchData + "']";

            if (SmartWait.waitForElementVisible(driver, By.xpath(pFilterLink), 60) == null) {
                Report.log("fail", "Search results not displayed.");
                CloseChildWindowsAndSwitchToMainWindow(mainWinHandle);
                return;
            }

            if (SmartWait.waitForElementVisible(driver, By.xpath(TableFirstItem), 60) == null) {
                Report.log("fail", "No records displayed.");
                CloseChildWindowsAndSwitchToMainWindow(mainWinHandle);
                return;
            }

            driver.findElement(By.xpath(TableFirstItem)).click();
            Report.message("pass", "Clicked on '" + SearchData + "'");
            CloseChildWindowsAndSwitchToMainWindow(mainWinHandle);
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void setConfigurationItem(String SearchData) throws ExceptionHandler {
        try {
            Lookup(pConfigurationItemSearchButton, SearchData, "Configuration Item");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void verifyVersionNumberAutoPopulated(String txt) throws ExceptionHandler {
        try {
            String expectedVal = "1.00";

            String currentVal = driver.findElement(By.xpath(pVersionNumber)).getAttribute("value");

            if (driver.findElement(By.xpath(pVersionNumber)).getAttribute("value").equalsIgnoreCase(expectedVal)) {
                Report.log("pass", "Initial value of Version Number is: " + expectedVal);
            } else {
                Report.log("fail", "Version Number is: " + currentVal + " Expected is: " + expectedVal);
            }
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void verifyPublishedAutoPopulated(String txt) throws ExceptionHandler {
        try {
            String expectedVal = txt;

            String currentVal = driver.findElement(By.xpath(pPublished)).getAttribute("value");

            if (driver.findElement(By.xpath(pPublished)).getAttribute("value").equalsIgnoreCase(expectedVal)) {
                Report.log("pass", "Initial value of Published is: " + expectedVal);
            } else {
                Report.log("fail", "Published is: " + currentVal + " Expected is: " + expectedVal);
            }
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }
    public static void verifyNextAuditDateAutoPopulated(String txt) throws ExceptionHandler {
        try {
            String expectedVal = "";

            String currentVal = driver.findElement(By.xpath(pNextAuditDate)).getAttribute("value");
            if (driver.findElement(By.xpath(pNextAuditDate)).getAttribute("value").equalsIgnoreCase(expectedVal)) {
                Report.log("pass", "Initial value of NextAuditDate is blank");
            } else {
                Report.log("fail", "NextAuditDate is: " + currentVal + " Expected is blank");
            }
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void verifyStateAutoPopulated(String txt) throws ExceptionHandler {
        try {
            String expectedVal = "Draft";

            String currentVal = driver.findElement(By.xpath(pState)).getAttribute("value");
            if (driver.findElement(By.xpath(pState)).getAttribute("value").equalsIgnoreCase(expectedVal)) {
                Report.log("pass", "Initial value of State is " + expectedVal);
            } else {
                Report.log("fail", "State is: " + currentVal + " Expected is " + expectedVal);
            }
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void setAssignedTo(String txt) throws ExceptionHandler {
        try {
            Lookup(pAssignedToSearchButton, txt, "AssignTo");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void setKnowledgeOwner(String txt) throws ExceptionHandler {
        try {
            Lookup(pKnowledgeOwnerSearchButton, txt, "KnowledgeOwner");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void verifyAuditCycleDropDownValues(String opts) throws ExceptionHandler {
        try {
            opts = "Six Months|One Year|Two Years|Three Years";
            String data = "One Year";

            FuncLib.VerifyDropdownValues(pAuditCycle, opts, "AuditCycle");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void selectAuditCycle(String data) throws ExceptionHandler {
        try {
            FuncLib.selectByVisibleText(pAuditCycle, data, "AuditCycle");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void verifyShortDescriptionAutoPopulated(String txt) throws ExceptionHandler {
        try {
            String expectedVal = txt;

            String currentVal = driver.findElement(By.xpath(pShortDescription)).getAttribute("value");
            if (driver.findElement(By.xpath(pShortDescription)).getAttribute("value").equalsIgnoreCase(expectedVal)) {
                Report.log("pass", "The value of the short description is same as the Short Description of the Incident Ticket " + expectedVal);
            } else {
                Report.log("fail", "The value of the short description is not the same as the Short Description of the Incident Ticket\n " + " Current value: " + currentVal + " Expected is " + expectedVal);
            }
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void setShortDescription(String txt) throws ExceptionHandler {
        try {
            iSendData(pShortDescription, txt, "Short Description");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void compareShortDescription(String txt) throws ExceptionHandler {
        try {
            String expectedVal = txt;

            String currentVal = driver.findElement(By.xpath(pShortDescription)).getAttribute("value");
            if (driver.findElement(By.xpath(pShortDescription)).getAttribute("value").equalsIgnoreCase(expectedVal)) {
                Report.log("pass", "The value of the short description is same as the Short Description of the Incident Ticket " + expectedVal);
            } else {
                Report.log("fail", "The value of the short description is not the same as the Short Description of the Incident Ticket\n " + " Current value: " + currentVal + " Expected is " + expectedVal);
            }
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void verifyNotificationForPublishing(String txt) throws ExceptionHandler {
        try {
            String expectedVal = txt;
            iSendData(pNotificationForPublishing, expectedVal, "NotificationForPublishing");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void setComments(String txt) throws ExceptionHandler {
        try {
            String expectedVal = txt;
            iSendData(pComments, expectedVal, "Comments");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void verifyText(String txt) throws ExceptionHandler, InterruptedException {
        try {
            String expectedVal = txt;

            driver.switchTo().frame("kb_knowledge.text_ifr");

            if (FuncLib.isReadonly(pText, "Text"))
                Report.log("fail", "Text field is readonly.");
            else
                Report.log("pass", "Text field is editable.");

            iSendData(pText, expectedVal, "Text");
            driver.switchTo().defaultContent();
            driver.switchTo().frame(pMainFrame);
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void verifySubmissionTypeDropDownValues(String opts) throws ExceptionHandler {
        try {
            opts = "New Article";
            String data = "New Article";
            FuncLib.VerifyDropdownValues(pSubmissionType, opts, "SubmissionType");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void selectSubmissionType(String data) throws ExceptionHandler {
        try {
            FuncLib.selectByVisibleText(pSubmissionType, data, "SubmissionType");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void Submit() throws ExceptionHandler {
        try {
            iClick(pSubmit, "Submit");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }
}
