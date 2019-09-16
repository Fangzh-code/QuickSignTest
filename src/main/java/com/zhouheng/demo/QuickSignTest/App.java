package com.zhouheng.demo.QuickSignTest;

import org.json.JSONObject;

import com.zhouheng.demo.data.ExtractData;
import com.zhouheng.demo.service.GetDataExterneService;
import com.zhouheng.demo.validate.AccountValidateUtils;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	JSONObject extractDataJSON = GetDataExterneService.getExtractData();
    	System.out.println("The JSON l'OCR is: \n" + extractDataJSON.toString(2));
    	JSONObject metaDataJSON = GetDataExterneService.getMetaData();
    	System.out.println("\nThe JSON metaData is: \n" + metaDataJSON.toString(2));
    	
    	
    	ExtractData extractData = new ExtractData(GetDataExterneService.getExtractData());
    	JSONObject extractDataObject = extractData.getExtratDataBeforeValidate();
    	System.out.println("\nThe JSON extractData is: \n" + extractDataObject.toString(2));
		JSONObject dataValidated = extractData.getExtratDataAfterValidate();
    	System.out.println("\nThe JSON validate data is: \n" + dataValidated.toString(2));
		JSONObject resultObject = AccountValidateUtils.checkAccountWithMetaData(dataValidated,metaDataJSON);
		System.out.println("\nThe result is: \n" + resultObject.toString(2));
    }
}
