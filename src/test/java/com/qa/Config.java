package com.qa;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
public class Config {



	public static ChromeOptions chromecfg() {
			
		Map <String, Object > prefs =new HashMap<String, Object>();
		ChromeOptions coptions= new ChromeOptions ();
		prefs.put("profile.defaul_content_setting_values.cookies", 2);
		prefs.put("network.cookies.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", 2);
		coptions.setExperimentalOption("prefs", prefs);
		 return coptions;
		
		}

}
