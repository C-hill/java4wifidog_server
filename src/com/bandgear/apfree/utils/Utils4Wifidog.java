package com.bandgear.apfree.utils;

public class Utils4Wifidog {
	public static boolean checkUserAgent(String user_agent){
		if(user_agent!=null&"WiFiDog 20131213".equals(user_agent)){
			return true;
		}
		return false;
	}
}
