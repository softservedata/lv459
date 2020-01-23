package com.softserve.edu;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ApplRest {

    public String getJson() throws MalformedURLException, IOException {
//		String postal = "http://ua-postalcodes.rhcloud.com/api/regions";
		String github = "https://api.github.com/users/nikita-pivovarov";
    	//String github = "https://api.github.com/orgs/dotnet/repos";
    	//String github = "https://api.github.com/orgs/dotnet";
    	//String github = "https://api.github.com/users/softservedata";
    	//String heroku = "http://schedule-lv215.herokuapp.com/meetings/restByRoom";
    	//String heroku = "https://schedule-lv215.herokuapp.com/meetings/restByRoom?start=2017-02-14&end=2017-02-14&roomId=100"; 
    	//String localHost = "http://localhost:8080/";
    	//String localHost = "http://localhost:8080/admins?token=FXVYJMPKS3RJ170RHJMUD0VSS8D3D044";
    	String localHost = "http://localhost:8080/user?token=FXVYJMPKS3RJ170RHJMUD0VSS8D3D044&name=petro";
    	//String localHost = "http://localhost:8080/tokenlifetime?token=FXVYJMPKS3RJ170RHJMUD0VSS8D3D044&time=1000000";
    	//String localHost = "http://localhost:8080/tokenlifetime";
    	
		String resultString;
		//URL url = new URL(heroku);
		URL url = new URL(github);
		//URL url = new URL(localHost);
        //URL url = new URL(city);
		//URL url = new URL(partners);
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConnection = (HttpURLConnection) connection;
		//httpConnection.setRequestMethod("POST");
		//httpConnection.setRequestMethod("PUT");
		//httpConnection.setRequestMethod("DELETE");
		httpConnection.setRequestMethod("GET");
		connection.setReadTimeout(15000);
		// httpConnection.setRequestProperty("lng", "en");
		//httpConnection.setRequestProperty("changed", "1403802820");
		//
//		httpConnection.setRequestProperty("token", "FXVYJMPKS3RJ170RHJMUD0VSS8D3D044");
//		httpConnection.setRequestProperty("time", "1100000");
		//httpConnection.setRequestProperty("name", "petro");
		//httpConnection.setRequestProperty("password", "qwerty");
		//
		httpConnection.setDoOutput(true);
		httpConnection.setDoInput(true);
		httpConnection.connect();
//		OutputStream os = httpConnection.getOutputStream();
		//String str = "changed=1403803787";
        //String str = "changed=0026183574";
		//String str = "changed=1403803788";
		//String str = "?start=2017-02-14";
		//str += "&end=2017-02-14";
		//str += "&roomId=100";
		//
		//String str = "token=FXVYJMPKS3RJ170RHJMUD0VSS8D3D044";
		//str += "&name=petro";
		//str += "&password=qwerty";
		//
//		String str = "token=FXVYJMPKS3RJ170RHJMUD0VSS8D3D044";
//		str += "&time=1100000";
		//
//		String str = "token=FXVYJMPKS3RJ170RHJMUD0VSS8D3D044";
//		str += "&name=petro";
		//
//		os.write(str.getBytes());
//		os.flush();
//		os.close();
		int responseCode = httpConnection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			InputStream in = httpConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			// InputStreamReader isr = new InputStreamReader(in,
			// "windows-1251");
			StringBuffer data = new StringBuffer();
			int c;
			while ((c = isr.read()) != -1) {
				data.append((char) c);
			}
			resultString = new String(data.toString());
		} else {
			resultString = "Server does not respond";
		}
		httpConnection.disconnect();
		return resultString;
	}

	public static void main(String[] args) {
		ApplRest appl = new ApplRest();
		try {
			System.out.println(appl.getJson());
		} catch (MalformedURLException ex) {
			System.out.println("\nMalformedURLException:" + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("\nIOException:" + ex.getMessage());
		}
		System.out.println("\nThe End");
	}
}