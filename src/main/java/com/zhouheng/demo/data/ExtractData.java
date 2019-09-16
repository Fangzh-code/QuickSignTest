package com.zhouheng.demo.data;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class ExtractData {

	public static final String VALUE_NAME_SSN = "No S.S.";
	public static final String VALUE_NAME_SIRET = "sirEt";
	public static final String VALUE_NAME_ADDRESS = "adresse";
	
	public static final String KEY_NAME_SSN = "ssn";
	public static final String KEY_NAME_SIRET = "siret";
	public static final String KEY_NAME_ADDRESS = "address";
	public static final String KEY_NAME_DATE = "date";
	
	private JSONObject dataJSONObjectOCR = null;
	
	private List<String> ssn = new ArrayList<String>();
	private List<String> siret = new ArrayList<String>();
	private List<String> date = new ArrayList<String>();
	private String address;
	
	public ExtractData(JSONObject extractDataJSONObject) {
		dataJSONObjectOCR = extractDataJSONObject;
	}
	
	public JSONObject getExtratDataBeforeValidate() {
		JSONObject extractDataObject = new JSONObject();
		
		return extractDataObject;
	}
	
	public JSONObject getExtratDataAfterValidate() {
		JSONObject extractDataObject = new JSONObject();
		
		return extractDataObject;
	}
}
