package com.example.codingTaskIntership.service;

import java.util.List;
import java.util.Optional;

import com.example.codingTaskIntership.model.Skill;

public interface SkillService {
	
	public List<Skill> findAll();
	public Optional<Skill> findOne(Long id);
	public Skill save (Skill skill);
	public List<Skill> findByCandidate(Long idCandidate);
	

}
