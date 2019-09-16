package com.zhouheng.demo.service;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;


public class GetDataExterneServiceTest {
	

	@Test
	public void testGetExtractData() {
		JSONObject extractData = GetDataExterneService.getExtractData();
		System.out.println("The extractData is: " + extractData.toString(2));
	}

	@Test
	public void testGetMetaData() {
		JSONObject metaData = GetDataExterneService.getMetaData();
		System.out.println("The metaData is: " + metaData.toString(2));
	}

}
