package com.zhouheng.demo.validate;

import org.json.JSONArray;
import org.json.JSONObject;

public class AccountValidateUtils {
	
	public static final String VALUE_MATCH = "MATCH";
	public static final String VALUE_NOT_MATCH = "NOT MATCH";
	
	public static final String FIRST_NAME_CHECK = "firstName";
	public static final String LAST_NAME_CHECK = "lastName";
	public static final String BIRTHDAT_CHECK = "birthDate";

	public static final JSONObject checkAccountWithMetaData(JSONObject accountJSONObject, JSONObject metaDataJSONObject) {
		JSONObject returnObject = new JSONObject();
		String sAddress = accountJSONObject.getString("address");
		String[] sAddressSplited = sAddress.split(" ");

		String firstName = sAddressSplited[0];
		String lastName = sAddressSplited[1];
		JSONArray dateList = accountJSONObject.getJSONArray("date");
		
		if (firstName.equals(metaDataJSONObject.getString(FIRST_NAME_CHECK))) {
			returnObject.put(FIRST_NAME_CHECK, VALUE_MATCH);
		} else {
			returnObject.put(FIRST_NAME_CHECK, VALUE_NOT_MATCH);
		}
		
		if (lastName.equals(metaDataJSONObject.getString(LAST_NAME_CHECK))) {
			returnObject.put(LAST_NAME_CHECK, VALUE_MATCH);
		} else {
			returnObject.put(LAST_NAME_CHECK, VALUE_NOT_MATCH);
		}
		
		boolean dateMatch = false;
		String sDate = metaDataJSONObject.getString(BIRTHDAT_CHECK);
		for (int i=0; i<dateList.length(); i++) {
			if (sDate.equals(dateList.getString(i))) {
				dateMatch = true;
			}
		}
		if (dateMatch) {
			returnObject.put(BIRTHDAT_CHECK, VALUE_MATCH);
		} else {
			returnObject.put(BIRTHDAT_CHECK, VALUE_NOT_MATCH);
		}
		
		return returnObject;
	}
}
