package com.zhouheng.demo.validate;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.zhouheng.demo.data.ExtractData;
import com.zhouheng.demo.service.GetDataExterneService;

public class AccountValidateUtilsTest {

	private JSONObject metaData = null;
	private JSONObject dataValidated = null;
	
	@Before
	public void setUp() throws Exception {
		metaData = GetDataExterneService.getMetaData();
		ExtractData extractData = new ExtractData(GetDataExterneService.getExtractData());
		extractData.getExtratDataBeforeValidate();
		dataValidated = extractData.getExtratDataAfterValidate();
	}

	@Test
	public void testCheckAccountWithMetaData() {
		JSONObject resultObject = AccountValidateUtils.checkAccountWithMetaData(dataValidated,metaData);
		System.out.println("The result is: " + resultObject.toString(2));
	}

}
