package com.zhouheng.demo.validate;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataValidateUtilsTest {

	@Test
	public void testDateFormateCheck() {
		assertEquals(true, DataValidateUtils.dateFormateCheck("10/10/2019"));
		assertEquals(true, DataValidateUtils.dateFormateCheck("4/1/2018"));
		assertEquals(false, DataValidateUtils.dateFormateCheck("30/2/2018"));
	}
	
	@Test
	public void testSsnFormateCheck() {
		assertEquals(true, DataValidateUtils.ssnFormateCheck("289037511324218"));
		assertEquals(true, DataValidateUtils.ssnFormateCheck("189109921628783"));
	}
	
	@Test
	public void testSiretFormateCheck() {
		assertEquals(true, DataValidateUtils.siretFormateCheck("45590010040001"));
		assertEquals(false, DataValidateUtils.siretFormateCheck("900000000000008"));
	}

}
