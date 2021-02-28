package com.example.codingTaskIntership.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codingTaskIntership.model.Candidate;
import com.example.codingTaskIntership.model.Skill;
import com.example.codingTaskIntership.repository.SkillRepository;
import com.example.codingTaskIntership.service.CandidateService;
import com.example.codingTaskIntership.service.SkillService;

@Service
public class JpaSkillService implements SkillService {
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private CandidateService candidateService;

	@Override
	public List<Skill> findAll() {
		List<Skill> skills= skillRepository.findAll();
		System.out.println("REsulut from database" + skills);
		return skills;
	}

	@Override
	public Optional<Skill> findOne(Long id) {
		// TODO Auto-generated method stub
		return skillRepository.findById(id);
	}

	@Override
	public Skill save(Skill skill) {
		// TODO Auto-generated method stub
		return skillRepository.save(skill);
	}

	@Override
	public List<Skill> findByCandidate(Long idCandidate) {
		Optional<Candidate> candidate= candidateService.findOne(idCandidate);
		if(candidate.isPresent()) {
			return skillRepository.findByCandidate(candidate.get());
		}
		return null;
	}

}
