package com.servicenow.zProgress;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestResponse {
	public static String isLinkBroken(URL url) throws Exception
	{
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		try
		{
		    connection.connect();
		    String response = connection.getResponseMessage();	        
		    connection.disconnect();
		    return response;
		}
		catch(Exception exp)
		{
			return exp.getMessage();
		}				
	}
}
