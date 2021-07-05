package com.test33.test3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;

import jakarta.ws.rs.core.GenericEntity;
import smile.data.DataFrame;
import smile.data.Tuple;
import smile.data.vector.IntVector;
import smile.io.Read;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JobProvider {
	private DataFrame jopDataFrame;
    public DataFrame readCSV(String path) {
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ();
        DataFrame df = null;
        try {
            df = Read.csv (path, format);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace ();
        }
        jopDataFrame = df;
        
        return df;
    }
    
    //Print some rows of the DataFrame
    public String structure(DataFrame df) {
    	return df.structure().toString();
    }
    
    public String viewData(DataFrame df) {
    	return df.toString();
    }
    
    
    //Cleaning Data
    public DataFrame cleaningData(DataFrame df) {
    	//Removing Null rows
    	df =df.omitNullRows();
    	
    	//Encoding Years of experience to Integer
    	String[] string_experience = df.stringVector("YearsExp").toArray();
    	String pattern = "([0-9]+)";
        Pattern r = Pattern.compile(pattern);
    	int n = string_experience.length;
    	int[] dst = new int[n];
    	for(int i=0; i<n; i++){
            Matcher m = r.matcher(string_experience[i]);
            if(m.find()){
                dst[i] = Integer.parseInt(m.group(0));
            }
            else{
                dst[i] = 0;
            }
        }
    	//adding new column to DataFrame contains Integer numbers of Experience
    	df = df.merge(IntVector.of("IntExp", dst));
    	
    	return df;
    }
    
    //Creating list of job to view it as JSON
    public List<Jop> getJobList(){
    	assert jopDataFrame != null;
    	List<Jop> jobs = new ArrayList();
        ListIterator<Tuple> iterator = jopDataFrame.stream ().collect (Collectors.toList ()).listIterator ();
        while (iterator.hasNext () ) {
            Tuple t = iterator.next ();
            Jop j = new Jop();
            Jop.id += 1;
            
            j.setTitle((String) t.get("Title"));
            j.setCompany((String)t.get("Company"));
            j.setLocation((String)t.get("Location"));
            j.setType((String)t.get("Type"));
            j.setLevel((String)t.get("Level"));
            j.setYears((String)t.get("YearsExp"));
            j.setCountry((String)t.get("Country"));
            j.setSkills((String)t.get("Skills"));
            jobs.add(j);
        }
        return jobs;
    }
    
}
