package com.zhouheng.demo.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidateUtils {

public static final String REGEX_SSN = "^([1-3])[\\s\\.\\-]?([0-9]{2})[\\s\\.\\-]?(0[0-9]|[2-35-9][0-9]|[14][0-2])[\\s\\.\\-]?(0[1-9]|[1-8][0-9]|9[0-57-9]|2[ab])[\\s\\.\\-]?(00[1-9]|0[1-9][0-9]|[1-8][0-9]{2}|9[0-8][0-9]|990)[\\s\\.\\-]?([0-9]{3})[\\s\\.\\-]?([0-8][0-9]|9[0-7])$";
	
	public static boolean dateFormateCheck(String sDate) {
		boolean convertSuccess=true;
	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	       try {
	          format.setLenient(false);
	          format.parse(sDate);
	       } catch (ParseException e) {
	           convertSuccess=false;
	       } 
	       return convertSuccess;
	}
	
	public static boolean ssnFormateCheck(String sSsn) {
		boolean isValidate = true;
		
		Pattern p = Pattern.compile(REGEX_SSN);
		Matcher m = p.matcher(sSsn);
		isValidate = m.matches();
		return isValidate;
	}
	
	public static boolean siretFormateCheck(String sSiret) {
		boolean isValidate = true;
		int total = 0;
		int digit = 0;
		for (int i=0; i<sSiret.length(); i++) {
			if (i%2 == 0) {
				digit = Integer.parseInt(String.valueOf(sSiret.charAt(i)))*2;
				if (digit>9) {
					digit-=9;
				} 
			} else {
				digit = Integer.parseInt(String.valueOf(sSiret.charAt(i)));
			}
			total+=digit;
		}
		isValidate = (total%10 == 0);
		
		return isValidate;
	}
}
