package com.zhouheng.demo.service;

import org.json.JSONObject;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class GetDataExterneService {

	public static final String EXTRACTDATA_NAME = "extractData";
	public static final String METADATA_NAME = "metaData";
	
	public static final JSONObject getExtractData() {
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.execfile("extractDataService.py");
		
		PyObject pyobjExtractData = interpreter.get(EXTRACTDATA_NAME, PyObject.class);
		return new JSONObject(pyobjExtractData.toString());
	}
	
	public static final JSONObject getMetaData() {
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.execfile("metaDataService.py");
		
		PyObject pyobjMetaData = interpreter.get(METADATA_NAME, PyObject.class);
		return new JSONObject(pyobjMetaData.toString());
	}
}
