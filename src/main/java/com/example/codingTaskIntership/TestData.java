package com.example.codingTaskIntership;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.codingTaskIntership.model.Candidate;
import com.example.codingTaskIntership.model.Skill;
import com.example.codingTaskIntership.service.CandidateService;
import com.example.codingTaskIntership.service.SkillService;

@Component
public class TestData {
	@Autowired
	private SkillService skillService;
	@Autowired
	private CandidateService candidateService;
	
	@PostConstruct
	public void init() {
		
		Candidate candidate= new Candidate();
		candidate.setContactNumber("065 444 41 86");
		candidate.setDateOfBirth(new Date(System.currentTimeMillis()));
		candidate.setEmail("marko@gmail.com");
		candidate.setFullName("Marko Markovic");
		candidateService.save(candidate);
		Candidate candidate2= new Candidate();
		candidate2.setContactNumber("063 3159 40 80");
		candidate2.setDateOfBirth(new Date(System.currentTimeMillis()));
		candidate2.setEmail("mika@gmail.com");
		candidate2.setFullName("Mika Mikic");
		candidateService.save(candidate2);
		Candidate candidate1= new Candidate();
		candidate1.setContactNumber("063 3553 41 80");
		candidate1.setDateOfBirth(new Date(System.currentTimeMillis()));
		candidate1.setEmail("petar@gmail.com");
		candidate1.setFullName("Petar Petrovic");
		candidateService.save(candidate1);
		
		Skill skill= new Skill();
		skill.setName("Java");
		Skill skill1= new Skill();
		skill1.setName("JavaScript");
		Skill skill2= new Skill();
		skill2.setName("Python");
		skillService.save(skill);
		skillService.save(skill1);
		skillService.save(skill2);
		skill.addCandidate(candidate);
		skill1.addCandidate(candidate);
		skill2.addCandidate(candidate);
		skill.addCandidate(candidate1);
		skill.addCandidate(candidate1);
		skill1.addCandidate(candidate2);
		
		candidateService.save(candidate);
		candidateService.save(candidate1);
		candidateService.save(candidate2);
		skillService.save(skill);
		skillService.save(skill1);
		skillService.save(skill2);
		
		
		
	}

}
