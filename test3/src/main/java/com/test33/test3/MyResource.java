package com.test33.test3;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import smile.data.DataFrame;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class MyResource {
	
	//Create objects of class
	JobProvider jProvider = new JobProvider();
	getCount count = new getCount();
	Charts chart = new Charts();
	
	//Loading the original data from csv file
    DataFrame originalData = jProvider.readCSV("F:\\youssef lap\\ITI\\7 Java\\project\\Wuzzuf_jobs.csv");
	
    
	//For testing
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    //For testing
    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
    	return "Hello world";
    }
    
    
    /////////////////////Tasks//////////////////////
    //Display the structure of data before cleaning
    @GET
    @Path("/structure")
    @Produces(MediaType.TEXT_PLAIN)
    public String getStructure() {
    	return jProvider.structure(originalData).toString();
    }
    
    //Display Data
  	@GET
    @Path("/getdata")
    @Produces(MediaType.TEXT_PLAIN)
    public String getData() {
  		return jProvider.viewData(originalData);
    }
    
    //Cleaning data and adding a column of integer values of experience
    DataFrame trainData = jProvider.cleaningData(originalData);
    
    //Display the structure of data after cleaning
    @GET
    @Path("/newstructure")
    @Produces(MediaType.TEXT_PLAIN)
    public String getnewStructure() {
    	return jProvider.structure(trainData).toString();
    }
    
    //Display new Data
  	@GET
    @Path("/getnewdata")
    @Produces(MediaType.TEXT_PLAIN)
    public String getNewData() {
  		return jProvider.viewData(trainData);
    }
  	
  	//Display data as JSON
  	@GET
    @Path("/getdatajson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Jop> getDataJson() {
  		return jProvider.getJobList();
    }
    
    ////////////////////Counting Methods///////////////////
    //Return most demanding companies for jobs with its jobs count as JSON
    @GET
    @Path("/companies")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CompaniesCount> getMostCompany(){
    	return count.companyCount(trainData);
    }
    
    //Return Most popular job title with the count as JSON
    @GET
    @Path("/titles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TitleCount> getMostTitles() {
    	return count.titleCount(trainData);
    }
    
    //Return most popular areas with its count as JSON
    @GET
    @Path("/areas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AreaCount> getMostArea(){
    	return count.areaCount(trainData);
    }
    
    //Return most important skills with its count as JSON
    @GET
    @Path("/skills")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SkillCount> getMostSkill(){
    	return count.skillCount(trainData);
    }
    
    ///////////////Charts Methods////////////////////
    //Companies Chart
    @GET
    @Path("/companiesChart")
    public void getCompaniesChart() {
    	chart.companiesChart(trainData);
    }
    
    //Job Titles Chart
    @GET
    @Path("/titlesChart")
    public void getTitlessChart() {
    	chart.titlesChart(trainData);
    }
    
    //Area Chart
    @GET
    @Path("/areasChart")
    public void getAreasChart() {
    	chart.areasChart(trainData);
    }
}
