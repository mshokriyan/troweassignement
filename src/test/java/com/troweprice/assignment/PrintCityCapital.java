package com.troweprice.assignment;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class PrintCityCapital {

	

	public static void getCapitalCity(String entryCountry) {
		String baseUrl = "https://restcountries.eu/rest/v2/";
		String inline = "";
		String getRequestURL = "";

		if (entryCountry.trim().length() <= 3) {

			getRequestURL = baseUrl + "name/" + entryCountry.trim().toLowerCase();
		} else {
			if (entryCountry.contains(" ")) {
				getRequestURL = baseUrl + "name/" + entryCountry.trim().replace(" ", "").toLowerCase()
						+ "?fullText=true";
			} else {
				getRequestURL = baseUrl + "name/" + entryCountry.trim().toLowerCase() + "?fullText=true";
			}
		}

		try {
			URL url = new URL(getRequestURL);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");

			if (http.getResponseCode() != 200) {
				System.out.println("Bad Request " + http.getResponseCode());
				
			} else {
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {

					inline += sc.nextLine();
				}
				sc.close();
			}
			
			JSONArray jsonArray = new JSONArray(inline);

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jObject = jsonArray.getJSONObject(i);
				String value = jObject.getString("capital");
				System.out.println(value);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		boolean stopFlag = false;
		Scanner sc = new Scanner(System.in);
		while (!stopFlag) {

			System.out.println("Enter Country name or Alpha Code:");
			String country = sc.next();
			
				getCapitalCity(country);
			
			System.out.println("do you want to Countinue y/n?");
			String flag = sc.next();
			if (flag.equalsIgnoreCase("n")) {
				stopFlag = true;
				System.out.println("Thank you :)");
				sc.close();
				System.exit(0);
			}

		}

		sc.close();
	}

}
