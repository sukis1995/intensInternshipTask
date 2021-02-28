package com.example.codingTaskIntership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.codingTaskIntership.dto.CandidateDTO;
import com.example.codingTaskIntership.dto.SkillDTO;
import com.example.codingTaskIntership.model.Skill;
import com.example.codingTaskIntership.service.SkillService;
import com.example.codingTaskIntership.support.SkillDTOToSkill;
import com.example.codingTaskIntership.support.SkillToSkillDTO;

@Controller
@RequestMapping("/api/skills")
public class SkillController {
	@Autowired
	private SkillService skillService;
	@Autowired
	private SkillToSkillDTO toDto;
	@Autowired
	private SkillDTOToSkill toSkill;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SkillDTO> save (@Validated @RequestBody SkillDTO dto){
		Skill skill= toSkill.convert(dto);
		if(skill==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Skill saved = skillService.save(skill);
		if(saved==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(toDto.convert(skill), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/findByCandidate/{id}")
	public ResponseEntity<List<SkillDTO>> findByCandidate(@PathVariable Long id){
		List<Skill> skills= skillService.findByCandidate(id);
		if(skills==null || skills.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(toDto.convert(skills), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SkillDTO>> findAll(){
		List<Skill> skills= skillService.findAll();
		if(skills==null || skills.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(toDto.convert(skills), HttpStatus.OK);
	}
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> exceptionHandler(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	

}
