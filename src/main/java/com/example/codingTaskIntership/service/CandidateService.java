package com.example.codingTaskIntership.service;

import java.util.List;
import java.util.Optional;

import com.example.codingTaskIntership.model.Candidate;
import com.example.codingTaskIntership.model.Skill;

public interface CandidateService {
	
	
	public List<Candidate> findAll();
	public Optional<Candidate> findOne(Long id);
	public Candidate addCandidate (Candidate candidate);
	public Optional<Candidate> delete(Long id);
	public Candidate addSkill (Long idCandidate, Long idSkill);
	public Candidate removeSkill (Long idCandidate, Long idSkill);
	public Candidate save (Candidate candidate);
	public List<Candidate> findByName(String name);
	public List<Candidate> findBySkill(Long idSkill1, Long idSkill2, Long idSkill3, Long numOfParams);

}
