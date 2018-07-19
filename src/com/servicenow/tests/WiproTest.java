package com.servicenow.tests;

import com.servicenow.base.PageInitialize;
import com.servicenow.pages.*;
import com.servicenow.utilities.BasePage;
import com.servicenow.utilities.DataTable;
import com.servicenow.utilities.FuncLib;
import com.servicenow.utilities.Report;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.lang.reflect.Method;

import static com.servicenow.utilities.Report.extent;

/**
 * Name: WiproTest
 * Description: Sample.
 * Author: Muni
 * Date: 05/01/2018
 * Notes: Every test class should inherit PageInitialize class
 *
 */
public class WiproTest extends PageInitialize {
    @Test
    public void CreateNewKBArticleFromChangeTest() throws InterruptedException, AWTException {
        CreateKnowledgeArticle();
    }
    @Test
    public void CreateNewKBArticleFromIncident() throws InterruptedException, AWTException {
        CreateKnowledgeArticle();
    }
    public void CreateKnowledgeArticle(){
        try {
            //************************Data Section***********************************************************
            String dFile=System.getProperty("user.dir") + "/TestData/Regression.xlsx";
            String dSh="CreateKnowledgeArticle";
            DataTable DataMgr = new DataTable(dFile,dSh,dSh);
            int iRowNo = 3;
            String dURL="https://corningtest.service-now.com/login.do";
            String dUserName=DataMgr.getValue("UserName",iRowNo);
            String dPassword=DataMgr.getValue("Password",iRowNo);
            String dLeftPaneOption=DataMgr.getValue("LeftPaneOption",iRowNo);
            String dCreateKnowledgeArticle=DataMgr.getValue("CreateKnowledgeArticle",iRowNo);
            String dTopicFieldDefaultValues=DataMgr.getValue("TopicFieldDefaultValues",iRowNo);
            String dTopic=DataMgr.getValue("Topic",iRowNo);
            String dCategory=DataMgr.getValue("Category",iRowNo);
            String dConfigurationItem=DataMgr.getValue("ConfigurationItem",iRowNo);
            String dVersionNumber=DataMgr.getValue("VersionNumber",iRowNo);
            String dNextAuditDate=DataMgr.getValue("NextAuditDate",iRowNo);
            String dState=DataMgr.getValue("State",iRowNo);
            String dAssignedTo=DataMgr.getValue("AssignedTo",iRowNo);
            String dKnowledgeOwner=DataMgr.getValue("KnowledgeOwner",iRowNo);
            String dPublished=DataMgr.getValue("Published",iRowNo);
            String dAuditCycleDefaultValues=DataMgr.getValue("AuditCycleDefaultValues",iRowNo);
            String dAuditCycle=DataMgr.getValue("AuditCycle",iRowNo);
            String dNotificationForPublishing=DataMgr.getValue("NotificationForPublishing",iRowNo);
            String dComments=DataMgr.getValue("Comments",iRowNo);
            String dText=DataMgr.getValue("Text",iRowNo);
            String dSubmissionType=DataMgr.getValue("SubmissionType",iRowNo);
            String dSubmissionTypeDefaultValues=DataMgr.getValue("SubmissionTypeDefaultValues",iRowNo);
            //***************************************************************************************************

            FuncLib.launch(dURL);
            Login.login(dUserName,dPassword);
            /*LeftNav.selectOption(dLeftPaneOption);
            Incidents.selectIndcident();
            String ShortDesc=IncidentDetails.getShortDescription();
            NavBar.RightClick();
            ContextMenu.selectOption(dCreateKnowledgeArticle);

            CreateKnowledgeArticle KB = new CreateKnowledgeArticle(driver);
            CreateKnowledgeArticle.VerifyCaption();
            CreateKnowledgeArticle.captureNumber();
            CreateKnowledgeArticle.Validation();
            //CreateKnowledgeArticle.verifyNumberAutoPopulated();

            CreateKnowledgeArticle.verifyTopicDropdownValues(dTopicFieldDefaultValues);
            CreateKnowledgeArticle.selectTopic(dTopic);
            CreateKnowledgeArticle.selectCatagory(dCategory);
            CreateKnowledgeArticle.setConfigurationItem(dConfigurationItem);
            CreateKnowledgeArticle.verifyVersionNumberAutoPopulated(dVersionNumber);
            CreateKnowledgeArticle.verifyNextAuditDateAutoPopulated(dNextAuditDate);
            CreateKnowledgeArticle.verifyStateAutoPopulated(dState);
            CreateKnowledgeArticle.setAssignedTo(dAssignedTo);
            CreateKnowledgeArticle.setKnowledgeOwner(dKnowledgeOwner);
            CreateKnowledgeArticle.verifyPublishedAutoPopulated(dPublished);
            CreateKnowledgeArticle.verifyAuditCycleDropDownValues(dAuditCycleDefaultValues);
            CreateKnowledgeArticle.selectAuditCycle(dAuditCycle);
            CreateKnowledgeArticle.compareShortDescription(ShortDesc);
            CreateKnowledgeArticle.verifyNotificationForPublishing(dNotificationForPublishing);
            CreateKnowledgeArticle.setComments(dComments);
            CreateKnowledgeArticle.verifyText(dText);
            CreateKnowledgeArticle.verifySubmissionTypeDropDownValues(dSubmissionTypeDefaultValues);
            CreateKnowledgeArticle.selectSubmissionType(dSubmissionType);
            String kb=CreateKnowledgeArticle.captureNumber();
            CreateKnowledgeArticle.Submit();
            DataMgr.setValue("ArticleNum",iRowNo,kb);*/
            Logout.Logout();
        }catch(Exception e)
        {
            Report.message("fail", "test failed.." + e.getMessage());
            BasePage.softAssert.assertAll();
        }
    }


   }
