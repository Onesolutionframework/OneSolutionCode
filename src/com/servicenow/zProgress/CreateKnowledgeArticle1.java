package com.servicenow.zProgress;

import com.servicenow.utilities.ExceptionHandler;
import com.servicenow.utilities.FuncLib;
import com.servicenow.utilities.SmartWait;
import com.servicenow.utilities.Report;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateKnowledgeArticle1 extends FuncLib{
    public CreateKnowledgeArticle1(WebDriver inputDriver) {
        super(inputDriver);
    }

    {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("gsft_main");
    }
    public static boolean VerifyCaption(){
        String caption="//nav[@class='navbar navbar-default section_zero ']//div[@class='navbar-title-caption']";
        if(driver.findElement(By.xpath(caption)).getText().contains("Knowledge"))
            return true;
        else
            return false;
    }

    public static void VerifyNumber(){
        String num = "//*[@id='kb_knowledge.number']";
        if(FuncLib.isReadonly(num,"Number"))
            Report.log("pass","Number field is readonly.");
        else
            Report.log("fail","Number field is not readonly.");

        String val= FuncLib.getAttributeValue(num,"Number");
        if(val!=null){
            Report.log("pass","Number is auto populated " + val);
        }
        else{
            Report.log("fail","Number is blank ");
            return;
        }
    }
    public static void VerifyTopic(){
        String topic="//*[@id='kb_knowledge.topic']";
        String opts="Service Desk|Field Services|L2Ops|IMS|Peoplesoft Support";
        String expectedVal="Service Desk";

        if(FuncLib.isMandatory(topic,"Topic"))
            Report.log("pass","Topic element is mandatory." );
        else
            Report.log("fail","Topic element is Not mandatory." );

        FuncLib.VerifyDropdownValues(topic,opts,"Topic");
        FuncLib.selectByVisibleText(topic,expectedVal,"Topic");
    }

    public static void setTopic(String txt){

    }
    public static void VerifyCatagory(){
        String catagory="//*[@id='kb_knowledge.category']";
        String opts="Service Desk|Field Services|L2Ops|IMS|Peoplesoft Support";
        String expectedVal="Account";
        if(FuncLib.isMandatory(catagory,"Catagory"))
            Report.log("pass","Catagory element is mandatory." );
        else
            Report.log("fail","Catagory element is Not mandatory." );

        FuncLib.VerifyDropdownValues(catagory,opts,"Catagory");
        FuncLib.selectByVisibleText(catagory,expectedVal,"Catagory");
    }

    public static void VerifyConfigurationItem() throws ExceptionHandler {
        String ConfigItem="//*[@id='sys_display.kb_knowledge.cmdb_ci']";
        String ConfigurationItemSearchButton="//*[@id='lookup.kb_knowledge.cmdb_ci']";

        if(FuncLib.isReadonly(ConfigItem,"Configuration Item"))
            Report.log("fail","Configuration Item field is readonly.");
        else
            Report.log("pass","Configuration Item field is editable.");

       iClick(ConfigurationItemSearchButton,"ConfigurationItemSearchButton");

        FuncLib.SwitchToNewWindow();
        String SearchField="//*[@class='input-group']//input[contains(@id,'_text')]";

        if(SmartWait.waitForElementVisible(driver,By.xpath(SearchField),60)==null){
            Report.log("fail","Search field is not enabled.");
            return;
        }else{
            Report.log("pass","Search field is enabled.");
        }

        String SearchData="abc";
        iSendData(SearchField,SearchData,"Search");

        String FilterLink="//a[text()='Name contains " + SearchData + "']";

        if(SmartWait.waitForElementVisible(driver,By.xpath(FilterLink),60)==null){
            Report.log("fail","Search results not displayed.");
            return;
        }

        String TableFirstItem="//div[@class=' ']//table[contains(@class,'data_list_table list_table table table-hover')]/tbody//tr[1]/td[3]/a";

        if(SmartWait.waitForElementVisible(driver,By.xpath(TableFirstItem),60)==null){
            Report.log("fail","No records displayed.");
            driver.close();
            driver.switchTo().defaultContent();
            return;
        }
        iClick(TableFirstItem,SearchData);

    }

    public static void VerifyVersionNumber(){
        String prop="//*[@id='kb_knowledge.u_version_number']";
        String expectedVal="1.00";

        if(FuncLib.isReadonly(prop,"Version Number"))
            Report.log("pass","Version Number field is readonly.");
        else
            Report.log("fail","Version Number field is not readonly.");
        String currentVal=driver.findElement(By.xpath(prop)).getAttribute("value");
        if(driver.findElement(By.xpath(prop)).getAttribute("value").equalsIgnoreCase(expectedVal)){
            Report.log("pass","Initial value of Version Number is: " + expectedVal);
        }else{
            Report.log("fail","Version Number is: " + currentVal + " Expected is: " + expectedVal);
        }
    }

    public static void VerifyNextAuditDate(){
        String prop="//*[@id='kb_knowledge.u_next_audit_date']";
        String expectedVal="";

        if(FuncLib.isReadonly(prop,"Next Audit Date"))
            Report.log("pass","Next AuditDate field is readonly.");
        else
            Report.log("fail","Next AuditDate field is not readonly.");
        String currentVal=driver.findElement(By.xpath(prop)).getAttribute("value");
        if(driver.findElement(By.xpath(prop)).getAttribute("value").equalsIgnoreCase(expectedVal)){
            Report.log("pass","Initial value of NextAuditDate is blank");
        }else{
            Report.log("fail","NextAuditDate is: " + currentVal + " Expected is blank");
        }
    }

    public static void VerifyState(){
        String prop="//*[@id='kb_knowledge.workflow_state']";
        String expectedVal="Draft";

        if(FuncLib.isReadonly(prop,"State"))
            Report.log("pass","State field is readonly.");
        else
            Report.log("fail","State field is not readonly.");

        String currentVal=driver.findElement(By.xpath(prop)).getAttribute("value");
        if(driver.findElement(By.xpath(prop)).getAttribute("value").equalsIgnoreCase(expectedVal)){
            Report.log("pass","Initial value of State is " + expectedVal);
        }else{
            Report.log("fail","State is: " + currentVal + " Expected is " + expectedVal);
        }
    }

    public static void VerifyAssignedTo() throws ExceptionHandler {
        String AssignedTo="//*[@id='sys_display.kb_knowledge.u_assigned_to']";
        String AssignedToSearchButton="//*[@id='lookup.kb_knowledge.u_assigned_to']";

        if(FuncLib.isReadonly(AssignedTo,"AssignedTo"))
            Report.log("fail","AssignedTo field is readonly.");
        else
            Report.log("pass","AssignedTo field is editable.");

        iClick(AssignedToSearchButton,"AssignedToSearchButton");

        FuncLib.SwitchToNewWindow();
        String SearchField="//*[@class='input-group']//input[contains(@id,'_text')]";

        if(SmartWait.waitForElementVisible(driver,By.xpath(SearchField),60)==null){
            Report.log("fail","Search field is not enabled.");
            return;
        }else{
            Report.log("pass","Search field is enabled.");
        }

        String SearchData="Support04, Test";
        iSendData(SearchField,SearchData,"Search");

        String FilterLink="//a[text()='Name contains " + SearchData + "']";

        if(SmartWait.waitForElementVisible(driver,By.xpath(FilterLink),60)==null){
            Report.log("fail","Search results not displayed.");
            return;
        }

        String TableFirstItem="//div[@class=' ']//table[contains(@class,'data_list_table list_table table table-hover')]/tbody//tr[1]/td[3]/a";

        if(SmartWait.waitForElementVisible(driver,By.xpath(TableFirstItem),60)==null){
            Report.log("fail","No records displayed.");
            driver.close();
            driver.switchTo().defaultContent();
            return;
        }
        iClick(TableFirstItem,SearchData);

    }

    public static void VerifyKnowledgeOwner() throws ExceptionHandler {
        String KnowledgeOwner="//*[@id='sys_display.kb_knowledge.u_knowledge_owner']";
        String KnowledgeOwnerSearchButton="//*[@id='lookup.kb_knowledge.u_knowledge_owner']";

        if(FuncLib.isReadonly(KnowledgeOwner,"KnowledgeOwner"))
            Report.log("fail","KnowledgeOwner field is readonly.");
        else
            Report.log("pass","KnowledgeOwner field is editable.");

        iClick(KnowledgeOwnerSearchButton,"AssignedToSearchButton");

        FuncLib.SwitchToNewWindow();
        String SearchField="//*[@class='input-group']//input[contains(@id,'_text')]";

        if(SmartWait.waitForElementVisible(driver,By.xpath(SearchField),60)==null){
            Report.log("fail","Search field is not enabled.");
            return;
        }else{
            Report.log("pass","Search field is enabled.");
        }

        String SearchData="Support04, Test";
        iSendData(SearchField,SearchData,"Search");

        String FilterLink="//a[text()='Name contains " + SearchData + "']";

        if(SmartWait.waitForElementVisible(driver,By.xpath(FilterLink),60)==null){
            Report.log("fail","Search results not displayed.");
            return;
        }

        String TableFirstItem="//div[@class=' ']//table[contains(@class,'data_list_table list_table table table-hover')]/tbody//tr[1]/td[3]/a";

        if(SmartWait.waitForElementVisible(driver,By.xpath(TableFirstItem),60)==null){
            Report.log("fail","No records displayed.");
            driver.close();
            driver.switchTo().defaultContent();
            return;
        }
        iClick(TableFirstItem,SearchData);

    }

    public static void VerifyAuditCycle(){
        String AuditCycle="//*[@id='kb_knowledge.u_audit_cycle']";
        String opts="Six Months|One Year|Two Years|Three Years";
        String data="One Year";
        if(FuncLib.isMandatory(AuditCycle,"AuditCycle"))
            Report.log("pass","AuditCycle element is mandatory." );
        else
            Report.log("fail","AuditCycle element is Not mandatory." );

        FuncLib.VerifyDropdownValues(AuditCycle,opts,"AuditCycle");

        FuncLib.selectByVisibleText(AuditCycle,data,"AuditCycle");
    }

    public static void VerifyShortDescription(String txt){
        String prop="//*[@id='kb_knowledge.short_description']";
        String expectedVal=txt;

        if(FuncLib.isReadonly(prop,"ShortDescription"))
            Report.log("fail","ShortDescription field is readonly.");
        else
            Report.log("pass","ShortDescription field is editable.");

        String currentVal=driver.findElement(By.xpath(prop)).getAttribute("value");
        if(driver.findElement(By.xpath(prop)).getAttribute("value").equalsIgnoreCase(expectedVal)){
            Report.log("pass","The value of the short description is same as the Short Description of the Incident Ticket " + expectedVal);
        }else{
            Report.log("fail","The value of the short description is not the same as the Short Description of the Incident Ticket\n " + " Current value: " + currentVal + " Expected is " + expectedVal);
        }
    }

    public static void VerifyNotificationForPublishing(String txt){
        String prop="//*[@id='kb_knowledge.u_notification_for_publishing']";
        String expectedVal=txt;

        if(FuncLib.isReadonly(prop,"NotificationForPublishing"))
            Report.log("fail","NotificationForPublishing field is readonly.");
        else
            Report.log("pass","NotificationForPublishing field is editable.");

        iSendData(prop,expectedVal,"NotificationForPublishing");
    }

    public static void VerifyComments(String txt){
        String prop="//*[@id='kb_knowledge.u_comment']";
        String expectedVal=txt;

        if(FuncLib.isReadonly(prop,"Comments"))
            Report.log("fail","Comments field is readonly.");
        else
            Report.log("pass","Comments field is editable.");

        iSendData(prop,expectedVal,"Comments");
    }

    public static void VerifyText(String txt){
        String prop="//*[@id='tinymce']";  //THIS LOCATOR MAY NOT WORK, PLEASE CHECK AGAIN
        String parentprop="//*[@class='mce-tinymce mce-container mce-panel']";
        String expectedVal=txt;

        if(FuncLib.isMandatory(parentprop,"Text"))
            Report.log("pass","Text element is mandatory." );
        else
            Report.log("fail","Text element is Not mandatory." );

        driver.switchTo().frame("kb_knowledge.text_ifr");

        if(FuncLib.isReadonly(prop,"Text"))
            Report.log("fail","Text field is readonly.");
        else
            Report.log("pass","Text field is editable.");

        iSendData(prop,expectedVal,"Text");
        driver.switchTo().defaultContent();
    }

    public static void VerifySubmissionType(){
        String AuditCycle="//*[@id='kb_knowledge.u_submission_type']";
        String opts="New Article";
        String data="New Article";
        if(FuncLib.isMandatory(AuditCycle,"SubmissionType"))
            Report.log("pass","SubmissionType element is mandatory." );
        else
            Report.log("fail","SubmissionType element is Not mandatory." );

        FuncLib.VerifyDropdownValues(AuditCycle,opts,"SubmissionType");

        FuncLib.selectByVisibleText(AuditCycle,data,"SubmissionType");
    }
    public static void Submit() throws ExceptionHandler {
        String prop="//*[@id='submit_click']";
        iClick(prop,"Submit");
    }
}
