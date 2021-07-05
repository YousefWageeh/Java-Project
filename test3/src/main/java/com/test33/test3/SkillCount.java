package com.test33.test3;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Skill")

public class SkillCount {
	private String Skill;
	private Long Count;
	
	public SkillCount() {
		
	}
	
	public SkillCount(String Skill, Long Count) {
		this.Skill = Skill;
		this.Count = Count;
	}

	public String getSkill() {
		return Skill;
	}

	public void setSkill(String skill) {
		Skill = skill;
	}

	public Long getCount() {
		return Count;
	}

	public void setCount(Long count) {
		Count = count;
	}
	
}
