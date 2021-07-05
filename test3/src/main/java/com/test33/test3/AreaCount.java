package com.test33.test3;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Area")

public class AreaCount {
	
	private String Area;
	private Long Count;
	
	public AreaCount(){
		
	}
	
	public AreaCount(String Area, Long Count) {
		this.Area = Area;
		this.Count = Count;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public Long getCount() {
		return Count;
	}

	public void setCount(Long count) {
		Count = count;
	}
	
	
}
