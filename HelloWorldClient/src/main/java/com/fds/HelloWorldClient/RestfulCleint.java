package com.fds.HelloWorldClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestfulCleint {
	   public static void main(String a[]){
	         
	        String url = "http://localhost:8080/HelloWorld/rest/helloworld/sayHello?key=0";
	        HttpURLConnection urlConn = null;
	        BufferedReader reader = null;
	        OutputStream ouputStream = null;
	        ObjectMapper mapper = new ObjectMapper();
	        Msg msg = new Msg();
	        msg.setMsg("333");
	        try {
	        	String jsonInput = mapper.writeValueAsString(msg);

	            URL urlObj = new URL(url);
	            urlConn = (HttpURLConnection) urlObj.openConnection();
	            urlConn.setDoOutput(true);
	            urlConn.setRequestMethod("POST");
	            urlConn.setRequestProperty("Content-Type", "application/json");
	            urlConn.setConnectTimeout(5000);
	            urlConn.setReadTimeout(5000);
	            urlConn.setRequestProperty("Accept", "application/json");
	            // send json input request
	            ouputStream = urlConn.getOutputStream();
	            ouputStream.write(jsonInput.getBytes());
	            ouputStream.flush();
	            if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	                System.err.println("Unable to connect to the URL...");
	                return;
	            }
	            System.out.println("Connected to the server...");
	            InputStream is = urlConn.getInputStream();
	            reader = new BufferedReader(new InputStreamReader((is)));
	            String tmpStr = null;
	            String result = "";
	            while((tmpStr = reader.readLine()) != null){
	                result += tmpStr;
	            }
	            
	            Result resultObj = mapper.readValue(result, Result.class);
	            System.out.println(result);
	            System.out.println(resultObj.getStatus());
	            System.out.println(resultObj.getMsg());
	            System.out.println(resultObj.getDate());
	            System.out.println(resultObj.getItemList().size());
	            
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            try {
	                if(reader != null) reader.close();
	                if(urlConn != null) urlConn.disconnect();
	            } catch(Exception ex){
	                 
	            }
	        }
	   }
}
