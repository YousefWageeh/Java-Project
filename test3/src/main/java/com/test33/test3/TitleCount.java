package com.test33.test3;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Title")

public class TitleCount {
	
	private static final long serialVersionUID = 1L; 
	private String title;
	private Long count;
	
	public TitleCount() {
		
	}
	
	public TitleCount(String title, Long count) {
		this.title = title;
		this.count = count;
	}
	
	@XmlElement
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlElement
	public Long getCount() {
		return count;
	}
	
	public void setCount(Long count) {
		this.count = count;
	}
	
}
