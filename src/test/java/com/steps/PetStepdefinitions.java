package com.steps;
//import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.demo.hooksutil.HooksTest;

//import org.testng.Assert;

import com.demo.otherutils.PetSteps;
import com.demo.otherutils.StepData;
import com.demo.utilities.ReadConfig;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;

public class PetStepdefinitions {
	ReadConfig rc; 
	String uri;
	
	@Steps
	PetSteps petSteps;
	
	@Shared
	StepData data;
	
	
	
	@Before
	public void before() throws Throwable, IOException
	{
		
		rc =new ReadConfig();
//		rootPath = System.getProperty("user.dir");
//		fileName = rootPath+ "\\Data\\"+rc.getKeyValues("TestDataFileName");
//		sheetName=rc.getKeyValues("TestDataSheetName");
//		
//		System.out.println("File Name : " + fileName + " Sheet Name : " + sheetName);
		
		 uri=	rc.getKeyValues("baseURI")+rc.getKeyValues("basePath");
		System.out.println("I will run before every scenario.");
	}
	
	@Given("I have the pet details ready with me.")
	public void readyTestData() throws FileNotFoundException, IOException
	{
	
//		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		RestAssured.baseURI = uri;
		data.request = petSteps.getRequest();
		

	}
	
	@When("I posted the requested to the {string} endpoint.")
	public void requestEndPoint(String endpoint)
	{
		
		data.response =  petSteps.postRequestToEndPoint(data.request, endpoint); 
		data.response.prettyPrint();
		System.out.println("Post Request");
	}

	@Then("Response should be {int}.")
	public void validateStatusCode(int statuscode)
	{
		Assert.assertEquals(data.response.getStatusCode(),statuscode);
		
	}
	
	@Then("Response should have pet breed as german.")
	public void validateBreed()
	{
	Assert.assertTrue(data.response.getBody().asString().contains("tummy"));
	}

}