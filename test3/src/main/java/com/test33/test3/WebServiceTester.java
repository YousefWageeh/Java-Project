package com.test33.test3;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

public class WebServiceTester {
	
	private Client client;
	private String COMPANIES_REST_SERVICE_URL = "http://localhost:8080/test3/webapi/myresource/companies";
	private String TITLES_REST_SERVICE_URL = "http://localhost:8080/test3/webapi/myresource/companies";
	private String AREAS_REST_SERVICE_URL = "http://localhost:8080/test3/webapi/myresource/companies";
	private String SKILLS_REST_SERVICE_URL = "http://localhost:8080/test3/webapi/myresource/companies";
	private String HELLO_REST_SERVICES_URL = "http://localhost:8080/test3/webapi/myresource/hello";
	private String STRUCTURE_REST_SERVICES_URL = "http://localhost:8080/test3/webapi/myresource/structure";
	private String GETDATA_REST_SERVICES_URL = "http://localhost:8080/test3/webapi/myresource/getdata";
	private String NEWSTRICTURE_REST_SERVICES_URL = "http://localhost:8080/test3/webapi/myresource/newstructure";
	private String GETNEWDATA_REST_SERVICES_URL = "http://localhost:8080/test3/webapi/myresource/getnewdata";
	private String GETDATAJSON_REST_SERVICES_URL = "http://localhost:8080/test3/webapi/myresource/getdatajson";
	
	private void init() {
		this.client = ClientBuilder.newClient();
	}
	
	public static void main(String[] args) {
		WebServiceTester tester = new WebServiceTester();
		//initialize the tester
		tester.init();
		
		//test helloWorld
		tester.testHello();
		
		//test getStructure
		tester.testGetStructure();
		
		//test getData
		tester.testGetData();
		
		//test getnewStructure
		tester.testGetnewStructure();
		
		//test getNewData
		tester.testGetNewData();
		
		//test getDataJson Web Service method
		tester.testGetDataJson();
		
		//test getMostCompany Web Service method
		tester.testGetMostCompany();
		
		//test getMostTitles Web Service method
		tester.testGetMostTitles();
		
		//test getMostArea Web Service method
		tester.testGetMostArea();
		
		//test getMostSkill Web Service method
		tester.testGetMostSkill();
		
	}
	
	private void testHello() {
		GenericType<String> str = new GenericType<String>() {};
		String s = client.target(HELLO_REST_SERVICES_URL).request(MediaType.TEXT_PLAIN).get(str);
		
		String result = "PASS";
		if(s.length() == 0) {
			result = "FAIL";
		}
		System.out.println("Test case name: testHello, Result: " + result);
	}
	
	private void testGetStructure() {
		GenericType<String> str = new GenericType<String>() {};
		String s = client.target(STRUCTURE_REST_SERVICES_URL).request(MediaType.TEXT_PLAIN).get(str);
		
		String result = "PASS";
		if(s.length() == 0) {
			result = "FAIL";
		}
		System.out.println("Test case name: testGetStructure, Result: " + result);
	}
	
	private void testGetData() {
		GenericType<String> str = new GenericType<String>() {};
		String s = client.target(GETDATA_REST_SERVICES_URL).request(MediaType.TEXT_PLAIN).get(str);
		
		String result = "PASS";
		if(s.length() == 0) {
			result = "FAIL";
		}
		System.out.println("Test case name: testGetData, Result: " + result);
	}
	
	private void testGetnewStructure() {
		GenericType<String> str = new GenericType<String>() {};
		String s = client.target(NEWSTRICTURE_REST_SERVICES_URL).request(MediaType.TEXT_PLAIN).get(str);
		
		String result = "PASS";
		if(s.length() == 0) {
			result = "FAIL";
		}
		System.out.println("Test case name: testGetnewStructure, Result: " + result);
	}
	
	private void testGetNewData() {
		GenericType<String> str = new GenericType<String>() {};
		String s = client.target(GETNEWDATA_REST_SERVICES_URL).request(MediaType.TEXT_PLAIN).get(str);
		
		String result = "PASS";
		if(s.length() == 0) {
			result = "FAIL";
		}
		System.out.println("Test case name: testGetNweData, Result: " + result);
	}
	
	private void testGetDataJson() {
		GenericType<List<Jop>> list = new GenericType<List<Jop>>() {};
		
		List<Jop> jobs = client.target(GETDATAJSON_REST_SERVICES_URL).request(MediaType.APPLICATION_JSON).get(list);
		
		String result = "PASS";
		if(jobs.isEmpty()) {
			result = "FAIL";
		}
		System.out.println("Test case name: testGetDataJson, Result: " + result);
	}
	
	private void testGetMostCompany() {
		GenericType<List<CompaniesCount>> list = new GenericType<List<CompaniesCount>>() {};
		
		List<CompaniesCount> companies = client.target(COMPANIES_REST_SERVICE_URL).request(MediaType.APPLICATION_JSON).get(list);
		
		String result = "PASS";
		if(companies.isEmpty()) {
			result = "FAIL";
		}
		System.out.println("Test case name: testGetMostCompany, Result: " + result);
	}
	
	private void testGetMostTitles() {
		GenericType<List<TitleCount>> list = new GenericType<List<TitleCount>>() {};
		
		List<TitleCount> titles = client.target(TITLES_REST_SERVICE_URL).request(MediaType.APPLICATION_JSON).get(list);
		
		String result = "PASS";
		if(titles.isEmpty()) {
			result = "FAIL";
		}
		System.out.println("Test case name: testGetMostTitles, Result: " + result);
	}
	
	private void testGetMostArea() {
		GenericType<List<AreaCount>> list = new GenericType<List<AreaCount>>() {};
		
		List<AreaCount> areas = client.target(AREAS_REST_SERVICE_URL).request(MediaType.APPLICATION_JSON).get(list);
		
		String result = "PASS";
		if(areas.isEmpty()) {
			result = "FAIL";
		}
		System.out.println("Test case name: testGetMostArea, Result: " + result);
	}
	
	private void testGetMostSkill() {
		GenericType<List<SkillCount>> list = new GenericType<List<SkillCount>>() {};
		
		List<SkillCount> skills = client.target(SKILLS_REST_SERVICE_URL).request(MediaType.APPLICATION_JSON).get(list);
		
		String result = "PASS";
		if(skills.isEmpty()) {
			result = "FAIL";
		}
		System.out.println("Test case name: testGetMostSkill, Result: " + result);
	}

}
