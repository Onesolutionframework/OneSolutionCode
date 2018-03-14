package com.servicenow.zProgress;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONutils {

    public static JSONObject jsonObject = null;
    FileReader input = null;
    BufferedReader br = null;
    public static String tRequest;
    //ReportGenerator rGen=new ReportGenerator();
    // HTTP Post request
    public static void sendingGetRequest(String url) {

        try
        {
            //tRequest=Request;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Setting basic post request
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Apache-HttpClient/4.5.2");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type","application/json");

            //String postJsonData =Request;

            // Send post request
            //con.setDoOutput(false);
            con.connect();
            //DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            //wr.writeBytes(postJsonData);
            //wr.flush();
            //wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("Sending 'GET' request to URL : " + url);
            //System.out.println("Post Data : " + postJsonData);
            System.out.println("Response Code : " + responseCode);
            //CommonUtils.httpCode=responseCode;
            Object responseMessage = con.getContent();
            String res= responseMessage.toString();

            System.out.println("Response content : " + responseMessage);
            System.out.println("Response content : " + res);
            System.out.println("Response content : " + con.getInputStream());

            int resp=Integer.parseInt(Integer.toString(responseCode).substring(0,1));

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String output;
            StringBuffer response = new StringBuffer();

            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();

            //printing result from response
            String sResponse=response.toString();
            System.out.println(sResponse);
            //CommonUtils.tResponse=response.toString();
            if(sResponse.startsWith("<!DOCTYPE html>"))
            {
                System.out.println("Service is down or under maintenance");
                //CommonUtils.tStatus="FAIL";
                System.out.println("Service is down or under maintenance");

            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


    public String jsonParser(JSONObject jsonObj,String jString) throws JSONException {
        String[] JSonPath = jString.split(",");
        int JSPLen = JSonPath.length;
        System.out.println(JSPLen);
        int p;
        for(p=0;p<JSPLen-1;p++)
        {
            jsonObj = (JSONObject) jsonObj.get(JSonPath[p]);
            //System.out.println("yes");
            //System.out.println(jsonObject.toJSONString());
            //System.out.println(j);

        }
        //System.out.println(jsonObject.get(JSonPath[j]));
        return (String) jsonObj.get(JSonPath[p]);


    }

}
