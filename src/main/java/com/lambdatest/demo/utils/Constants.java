package com.lambdatest.demo.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String LOGIN_PAGE_TITLE ="Log in";
//	public static final String LOGIN_PAGE_URL_FRACTION ="freedomemployeeqa";
	public static final int DEFAULT_TIMEOUT = 20;
	public static final String HOME_PAGE_TITLE = "user-welcome";
	
	
	public static List<String> getFMModulesList(){
		List<String> modulelist = new ArrayList<String>(); 
		modulelist.add("Order Fulfillment");
		modulelist.add("Asset Management");
		modulelist.add("Logistics");
		return modulelist;
	}
}
