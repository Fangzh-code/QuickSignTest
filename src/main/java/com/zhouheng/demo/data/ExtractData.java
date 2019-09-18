package com.zhouheng.demo.data;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zhouheng.demo.validate.DataValidateUtils;

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
		
		JSONArray dataList = dataJSONObjectOCR.getJSONArray("data");
		for (int i = 0; i<dataList.length(); ) {
			JSONObject dataObject = dataList.getJSONObject(i);
			String value = dataObject.getString("value");
			
			if (value.equals(VALUE_NAME_SSN)) {
				while(dataObject.getInt("y") == dataList.getJSONObject(++i).getInt("y")) {
					ssn.add(dataList.getJSONObject(i).getString("value"));
				}
			} else if (value.equals(VALUE_NAME_SIRET)) {
				while(dataObject.getInt("y") == dataList.getJSONObject(++i).getInt("y")) {
					siret.add(dataList.getJSONObject(i).getString("value"));
				}
			} else if (value.equals(VALUE_NAME_ADDRESS)) {
				if (dataObject.getInt("y") == dataList.getJSONObject(++i).getInt("y")) {
					address = dataList.getJSONObject(i).getString("value");
				}
			} else if (value.split("/").length == 3) {
				date.add(value);
				i++;
			} else {
				i++;
			}
		}
	}
	
	public JSONObject getExtratDataBeforeValidate() {
		JSONObject extractDataObject = new JSONObject();
		
		
		/*JSONArray dataList = dataJSONObjectOCR.getJSONArray("data");
		for (int i = 0; i<dataList.length(); ) {
			JSONObject dataObject = dataList.getJSONObject(i);
			String value = dataObject.getString("value");
			
			if (value.equals(VALUE_NAME_SSN)) {
				while(dataObject.getInt("y") == dataList.getJSONObject(++i).getInt("y")) {
					ssn.add(dataList.getJSONObject(i).getString("value"));
				}
			} else if (value.equals(VALUE_NAME_SIRET)) {
				while(dataObject.getInt("y") == dataList.getJSONObject(++i).getInt("y")) {
					siret.add(dataList.getJSONObject(i).getString("value"));
				}
			} else if (value.equals(VALUE_NAME_ADDRESS)) {
				if (dataObject.getInt("y") == dataList.getJSONObject(++i).getInt("y")) {
					address = dataList.getJSONObject(i).getString("value");
				}
			} else if (value.split("/").length == 3) {
				date.add(value);
				i++;
			} else {
				i++;
			}
		}*/
		
		extractDataObject.put(KEY_NAME_SSN, ssn);
		extractDataObject.put(KEY_NAME_SIRET, siret);
		extractDataObject.put(KEY_NAME_ADDRESS, address);
		extractDataObject.put(KEY_NAME_DATE, date);
		
		return extractDataObject;
	}
	
	public JSONObject getExtratDataAfterValidate() {
		JSONObject extractDataObject = new JSONObject();
		List<String> ssnList = new ArrayList<String>();
		List<String> siretList = new ArrayList<String>();
		List<String> dateList = new ArrayList<String>();
		
		for (String sSsn : ssn) {
			if (DataValidateUtils.ssnFormateCheck(sSsn)) {
				ssnList.add(sSsn);
			}
		}
		
		for (String sSiret : siret) {
			if (DataValidateUtils.siretFormateCheck(sSiret)) {
				siretList.add(sSiret);
			}
		}
		
		for (String sDate : date) {
			if (DataValidateUtils.dateFormateCheck(sDate)) {
				dateList.add(sDate);
			}
		}
		
		extractDataObject.put(KEY_NAME_SSN, ssnList.get(0));
		extractDataObject.put(KEY_NAME_SIRET, siretList.get(0));
		extractDataObject.put(KEY_NAME_ADDRESS, address);
		extractDataObject.put(KEY_NAME_DATE, dateList);
		
		return extractDataObject;
	}
}
