package com.example.codingTaskIntership.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.codingTaskIntership.dto.SkillDTO;
import com.example.codingTaskIntership.model.Skill;
import com.example.codingTaskIntership.service.SkillService;

@Component
public class SkillDTOToSkill implements Converter<SkillDTO, Skill> {
	@Autowired
	private SkillService skillService;
	@Override
	public Skill convert(SkillDTO dto) {
		Skill skill;
		if(dto.getId()==null) {
			skill= new Skill();
		}else {
			skill=skillService.findOne(dto.getId()).get();
		}
		
		skill.setName(dto.getName());
		
		return skill;
	}

}
