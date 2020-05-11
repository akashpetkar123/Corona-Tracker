/**
 * 
 */
package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Akash
 *
 */

@Controller
public class CoronaController {

	@RequestMapping("/home/coronaInformation")
	public String getCoronaInformation(HttpServletRequest request,Model model) {
		SimpleDateFormat dtf = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
		Date today;
		
		try {
			today = new Date();
			String date = dtf.format(today);
			//System.out.println("Latest Data for today dated="+date);
			
			URL url = new URL("https://corona-api.com/countries/IN");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			while ((output = br.readLine()) != null) {
				JSONObject jsonResult = new JSONObject(output);
				JSONObject jsonDataObject=(JSONObject) jsonResult.get("data");
				JSONObject jsonLatestDataObject=(JSONObject) jsonDataObject.get("latest_data");
				JSONObject jsonCalculatedObject=(JSONObject) jsonLatestDataObject.get("calculated");
				
				model.addAttribute("confirmed", jsonLatestDataObject.get("confirmed"));
				model.addAttribute("deaths", jsonLatestDataObject.get("deaths"));
				model.addAttribute("recovered", jsonLatestDataObject.get("recovered"));
				
				int confirmed=(Integer)jsonLatestDataObject.get("confirmed");
				int deaths=(Integer)jsonLatestDataObject.get("deaths");
				int recovered=(Integer)jsonLatestDataObject.get("recovered");
				int activeCases=confirmed-deaths-recovered;
				
				model.addAttribute("activeCases", activeCases);
				model.addAttribute("recoveryRate", jsonCalculatedObject.get("recovery_rate"));
				model.addAttribute("deathRate", jsonCalculatedObject.get("death_rate"));
			}
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		return "coronaDetails";
	}
}
