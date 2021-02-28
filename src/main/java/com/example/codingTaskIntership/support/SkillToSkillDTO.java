package com.example.codingTaskIntership.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.codingTaskIntership.dto.SkillDTO;
import com.example.codingTaskIntership.model.Skill;

@Component
public class SkillToSkillDTO implements Converter<Skill, SkillDTO> {

	@Override
	public SkillDTO convert(Skill skill) {
		SkillDTO dto= new SkillDTO();
		dto.setId(skill.getId());
		dto.setName(skill.getName());
		return dto;
	}
	
	public List<SkillDTO> convert(List<Skill> skills){
		List<SkillDTO> dtos= new ArrayList<SkillDTO>();
		for (Skill skill : skills) {
			SkillDTO dto = convert(skill);
			dtos.add(dto);
		}
		
		return dtos;
	}

}
