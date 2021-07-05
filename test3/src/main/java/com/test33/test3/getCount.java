package com.test33.test3;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import smile.data.DataFrame;

public class getCount {
	
	//Calculate each company with its repetition
	public List<CompaniesCount> companyCount(DataFrame df){
		//Get map of companies count (Key:Company Name, Value:Count)
		Map<String, Long> res = df.stream().collect(java.util.stream.Collectors.groupingBy(row -> row.getString("Company"), Collectors.counting()));
		
		//Sort Map by values
		Map<String, Long> sorted = res .entrySet() .stream() .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
		List<CompaniesCount> x = sorted.entrySet()
	     		   .stream()
	     		   .map(e -> new CompaniesCount(e.getKey(), e.getValue()))
	     		   .collect(Collectors.toList());
		return x;
	}
	
	//Calculate each Title with its repetition
	public List<TitleCount> titleCount(DataFrame df) {
    	//Map of job title count (Key:Job title, Value:Count)  
		Map<String, Long> res = df.stream().collect(java.util.stream.Collectors.groupingBy(row -> row.getString("Title"), Collectors.counting()));
		
		//Sort Map by value
		Map<String, Long> sorted = res .entrySet() .stream() .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
		List<TitleCount> x = sorted.entrySet()
	     		   .stream()
	     		   .map(e -> new TitleCount(e.getKey(), e.getValue()))
	     		   .collect(Collectors.toList());
		//GenericEntity<List<MostTitles>> entity = new GenericEntity<List<MostTitles>>(x){};
		
    	return x;
    }
	
	//Calculate each area with its repetition
	public List<AreaCount> areaCount(DataFrame df){
		//Map of Areas count
		Map<String, Long> res = df.stream().collect(java.util.stream.Collectors.groupingBy(row -> row.getString("Location"), Collectors.counting()));
				
		//Sort Map by value
		Map<String, Long> sorted = res .entrySet() .stream() .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) .limit(10) .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
		List<AreaCount> x = sorted.entrySet()
	     		   .stream()
	     		   .map(e -> new AreaCount(e.getKey(), e.getValue()))
	     		   .collect(Collectors.toList());
		return x;
	}
	
	//Calculate each skill with its repetition
	public List<SkillCount> skillCount(DataFrame df){
		List<String> skill =  df.stream().map(row -> row.getString("Skills")).collect(Collectors.toList());
        
        List<String> skills = skill.stream().flatMap(l -> Arrays.stream(l.split(","))).map(String::trim).collect(Collectors.toList());
        
        Map<String, Long> skills_count = skills.stream().collect(java.util.stream.Collectors.groupingBy(s -> s, Collectors.counting()));
		Map<String, Long> skills_sorted = skills_count .entrySet() .stream() .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
		List<SkillCount> x = skills_sorted.entrySet()
	     		   .stream()
	     		   .map(e -> new SkillCount(e.getKey(), e.getValue()))
	     		   .collect(Collectors.toList());
		return x;
	}
	
}
