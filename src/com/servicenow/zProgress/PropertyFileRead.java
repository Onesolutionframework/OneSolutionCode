package com.servicenow.zProgress;

import java.io.*;
import java.util.Properties;

public  class PropertyFileRead {
    static Properties Prop = new Properties();
    static String FileName = "TestData.properties";
    public static String getArticleUrl(String objValue)
    {
        try {
            // Prop.load(new FileInputStream("D:\\automation-testing\\automation-testing\\frontend\\src\\main\\resources\\"+FileName));
            Prop.load(new FileInputStream(".\\src\\main\\resources\\" + FileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         String keyValue = Prop.getProperty(objValue);
         return keyValue;
    }


}
    /*protected Properties Prop=null;
    public PropertyFileRead(){
        try {
            File src=new File("./frontend/src/main/resources/TestData.properties");
            FileInputStream fis=new FileInputStream(src);
            Prop=new Properties();
            Prop.load(fis);
        }
        catch (Exception e) {
            System.out.println("Exception is "+ e.getMessage());
        }
    }

    public String getArticleUrl(){
        return Prop.getProperty("StoryDetailsPageURL");
    }*/



