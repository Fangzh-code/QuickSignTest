package com.zhouheng.demo.data;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.zhouheng.demo.service.GetDataExterneService;

public class ExtractDataTest {
	
	private ExtractData extractData = null;

	@Before
	public void setUp() throws Exception {
		extractData = new ExtractData(GetDataExterneService.getExtractData());
	}

	@Test
	public void testGetExtratDataBeforeValidate() {
		JSONObject extractDataBefore = extractData.getExtratDataBeforeValidate();
		System.out.println("The extractData before validation is: " + extractDataBefore.toString(2));
	}

	@Test
	public void testGetExtratDataAfterValidate() {
		extractData.getExtratDataBeforeValidate();
		JSONObject extractDataAfter = extractData.getExtratDataAfterValidate();
		System.out.println("The extractData after validation is: " + extractDataAfter.toString(2));
	}

}
