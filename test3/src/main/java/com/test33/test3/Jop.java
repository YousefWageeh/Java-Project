package com.test33.test3;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Job")

public class Jop {
	static int id = 0;
	private String title;
	private String company;
	private String location;
	private String type;
	private String level;
	private String years;
	private String country;
	private String skills;
	
	public Jop() {
		
	}
	
	public Jop(String title, String company, String location, String type, String level, String years, String country, String skills) {
		this.company = company;
		this.location = location;
		this.type = type;
		this.level = level;
		this.years = years;
		this.country = country;
		this.skills = skills;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Jop.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
	
}
