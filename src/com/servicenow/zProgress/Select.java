package com.servicenow.zProgress;



import java.util.List;

import com.servicenow.utilities.Report;
import org.openqa.selenium.WebElement;



/**
 *
 *
 *
 * @author Vijaya Bhaskar Devireddy (DELL Badge Id: 614269,
 *         Vijaya_Bhaskar_Devir@dell.com)
 * @version 1.0
 * @since 2015-01-01
 */
public class Select extends org.openqa.selenium.support.ui.Select {
    public Select(WebElement element) {
        super(element);
        if (element == null) {
            select = null;
        } else {
            select = new org.openqa.selenium.support.ui.Select(element);
        }
    }

    org.openqa.selenium.support.ui.Select select = null;

    @Override
    public void deselectAll() {
        try {
            if (select == null) {
                Report.log("ERROR", "deselectAll - failed - Exception: select is null");
            } else {
                super.deselectAll();
                Report.log("DONE", "select:" + select.toString() + " - deselectAll - successful");
            }
        } catch (Exception e) {
            Report.log("ERROR", "deselectAll - failed - Exception:" + e.getMessage());
        }
    }

    @Override
    public void deselectByIndex(int index) {
        try {
            if (select == null) {
                Report.log("ERROR", "deselectByIndex - failed - Exception: Element is null");
            } else {
                super.deselectByIndex(index);
                Report.log("DONE", "Element:" + select.toString() + " - deselectByIndex - successful");
            }
        } catch (Exception e) {
            Report.log("ERROR", "deselectByIndex - failed - Exception:" + e.getMessage());
        }
    }

    @Override
    public void deselectByValue(java.lang.String value) {
        try {
            if (select == null) {
                Report.log("ERROR", "deselectByValue - failed - Exception: Element is null");
            } else {
                super.deselectByValue(value);
                Report.log("DONE", "Element:" + select.toString() + " - deselectByValue - successful");
            }
        } catch (Exception e) {
            Report.log("ERROR", "deselectByValue - failed - Exception:" + e.getMessage());
        }
    }

    @Override
    public void deselectByVisibleText(java.lang.String text) {
        try {
            if (select == null) {
                Report.log("ERROR", "deselectByVisibleText - failed - Exception: Element is null");
            } else {
                super.deselectByVisibleText(text);
                Report.log("DONE", "Element:" + select.toString() + " - deselectByVisibleText - successful");
            }
        } catch (Exception e) {
            Report.log("ERROR", "deselectByVisibleText - failed - Exception:" + e.getMessage());
        }
    }
    //
    // @Override
    // public String escapeQuotes(java.lang.String toEscape) {
    // try {
    // if (select == null) {
    // Report.log("ERROR", "escapeQuotes - failed - Exception: Element is
    // null");
    // return null;
    // } else {
    // Report.log("DONE", "Element:" + select.toString() + " -
    // escapeQuotes - successful");
    // return super.escapeQuotes(toEscape);
    // }
    // } catch (Exception e) {
    // Report.log("ERROR", "escapeQuotes - failed - Exception:" +
    // e.getMessage());
    // return null;
    // }
    //
    // }

    @Override
    public List<WebElement> getAllSelectedOptions() {
        try {
            if (select == null) {
                Report.log("ERROR", "getAllSelectedOptions - failed - Exception: Element is null");
                return null;
            } else {
                Report.log("DONE", "Element:" + select.toString() + " - getAllSelectedOptions - successful");
                return super.getAllSelectedOptions();
            }
        } catch (Exception e) {
            Report.log("ERROR", "getAllSelectedOptions - failed - Exception:" + e.getMessage());
            return null;
        }
    }

    @Override
    public WebElement getFirstSelectedOption() {
        try {
            if (select == null) {
                Report.log("ERROR", "getFirstSelectedOption - failed - Exception: Element is null");
                return null;
            } else {
                Report.log("DONE", "Element:" + select.toString() + " - getFirstSelectedOption - successful");
                return super.getFirstSelectedOption();
            }
        } catch (Exception e) {
            Report.log("ERROR", "getFirstSelectedOption - failed - Exception:" + e.getMessage());
            return null;
        }
    }

    @Override
    public List<WebElement> getOptions() {
        try {
            if (select == null) {
                Report.log("ERROR", "getOptions - failed - Exception: Element is null");
                return null;
            } else {
                Report.log("DONE", "Element:" + select.toString() + " - getOptions - successful");
                return super.getOptions();
            }
        } catch (Exception e) {
            Report.log("ERROR", "getOptions - failed - Exception:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean isMultiple() {
        try {
            if (select == null) {
                Report.log("ERROR", "isMultiple - failed - Exception: Element is null");
                return false;
            } else {
                Report.log("DONE", "Element:" + select.toString() + " - isMultiple - successful");
                return super.isMultiple();
            }
        } catch (Exception e) {
            Report.log("ERROR", "isMultiple - failed - Exception:" + e.getMessage());
            return false;
        }
    }

    @Override
    public void selectByIndex(int index) {
        try {
            if (select == null) {
                Report.log("ERROR", "selectByIndex - failed - Exception: Element is null");
            } else {
                super.selectByIndex(index);
                Report.log("DONE", "Element:" + select.toString() + " - selectByIndex - successful");
            }
        } catch (Exception e) {
            Report.log("ERROR", "selectByIndex - failed - Exception:" + e.getMessage());
        }
    }

    @Override
    public void selectByValue(java.lang.String value) {
        try {
            if (select == null) {
                Report.log("ERROR", "selectByValue - failed - Exception: Element is null");
            } else {
                super.selectByValue(value);
                Report.log("DONE", "Element:" + select.toString() + " - selectByValue - successful");
            }
        } catch (Exception e) {
            Report.log("ERROR", "selectByValue - failed - Exception:" + e.getMessage());
        }
    }

    @Override
    public void selectByVisibleText(java.lang.String text) {
        try {
            if (select == null) {
                Report.log("ERROR", "selectByVisibleText - failed - Exception: Element is null");
            } else {
                super.selectByVisibleText(text);
                Report.log("DONE", "Element:" + select.toString() + " - selectByVisibleText - successful");
            }
        } catch (Exception e) {
            Report.log("ERROR", "selectByVisibleText - failed - Exception:" + e.getMessage());
        }
    }
}
