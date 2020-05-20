package com.demo.hooksutil;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.demo.utilities.ReadConfig;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksTest {

	protected ReadConfig rc;
	public static String rootPath;
	public static String fileName ;
	public static String sheetName;
	public static String uri;
	
	@Before
	public   void before() throws Throwable, IOException
	{
		
		rc =new ReadConfig();
//		rootPath = System.getProperty("user.dir");
//		fileName = rootPath+ "\\Data\\"+rc.getKeyValues("TestDataFileName");
//		sheetName=rc.getKeyValues("TestDataSheetName");
//		
//		System.out.println("File Name : " + fileName + " Sheet Name : " + sheetName);
		uri= rc.getKeyValues("baseURI")+rc.getKeyValues("basePath");
		System.out.println("I will run before every scenario.");
	}
	
	@After
	public void after()
	{
		System.out.println("I will run after after every scenario.");
	}
}