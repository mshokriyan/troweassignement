package stepDef;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class Library {

	public static URL url; 
	public static HttpURLConnection httpUrlCon;

	public static String getEndPointURL(String entryCountry) {

		String baseUrl = "https://restcountries.eu/rest/v2/name/";
		String getRequestURL = "";

		if (entryCountry.trim().length() <= 3) {

			getRequestURL = baseUrl + entryCountry.trim().toLowerCase();
		} else {
			if (entryCountry.contains(" ")) {
				getRequestURL = baseUrl + entryCountry.trim().replace(" ", "").toLowerCase() + "?fullText=true";
			} else {
				getRequestURL = baseUrl + entryCountry.trim().toLowerCase() + "?fullText=true";
			}
		}

		return getRequestURL;
	}

	public static void setURLConnection(String entryCountry) {

		String getRequest = getEndPointURL(entryCountry);

		try {
			 url = new URL(getRequest);
			httpUrlCon = (HttpURLConnection) url.openConnection();
			httpUrlCon.setRequestMethod("GET");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int getResponseCode() {
		int responeseCode = 0;
		try {
			responeseCode = httpUrlCon.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return responeseCode;
	}
	
	public static String getCapitalCity() {
		
		String capitalCity=""; 
		String inline = ""; 
		try {
			Scanner sc = new Scanner(url.openStream());
			while(sc.hasNext()) {
				inline +=sc.nextLine();
			}
			sc.close(); 
			
			JSONArray jArray = new JSONArray(inline);
			for (int i = 0; i<jArray.length(); i++) {
				JSONObject jObject = jArray.getJSONObject(i);
				capitalCity = jObject.getString("capital").toString(); 
			}
		}catch(IOException exc) {
			exc.printStackTrace(); 
		}
		
		return capitalCity; 
		
	}

}
