package com.test33.test3;

import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 

public class CompaniesCount {
	private String Company;
	private Long Count;
	
	public CompaniesCount() {
		
	}
	
	public CompaniesCount(String Company, Long Count) {
		this.Company = Company;
		this.Count = Count;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public Long getCount() {
		return Count;
	}

	public void setCount(Long count) {
		Count = count;
	}
	
	
}
