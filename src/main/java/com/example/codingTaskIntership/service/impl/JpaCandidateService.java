package com.example.codingTaskIntership.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codingTaskIntership.model.Candidate;
import com.example.codingTaskIntership.model.Skill;
import com.example.codingTaskIntership.repository.CandidateRepository;
import com.example.codingTaskIntership.service.CandidateService;
import com.example.codingTaskIntership.service.SkillService;

@Service
public class JpaCandidateService implements CandidateService {
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private SkillService skillService;

	@Override
	public List<Candidate> findAll() {
		List<Candidate> candidates= candidateRepository.findAll();
		System.out.println("result from DB" + candidates);
		return candidates;
	}

	@Override
	public Optional<Candidate> findOne(Long id) {
		// TODO Auto-generated method stub
		return candidateRepository.findById(id);
	}

	@Override
	public Candidate addCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		return candidateRepository.save(candidate);
	}

	@Override
	public Optional<Candidate> delete(Long id) {
		Optional<Candidate> deleted= findOne(id);
		if(deleted.isPresent()) {
			candidateRepository.deleteById(id);
			return deleted;
		}
		return deleted;
	}

	
	@Override
	public Candidate removeSkill(Long idCandidate, Long idSkill) {
		Optional<Candidate> candidate= findOne(idCandidate);
		Optional<Skill> skill= skillService.findOne(idSkill);
		if(!candidate.isPresent() || !skill.isPresent()) {
			return null;
		}
		candidate.get().removeSkill(skill.get());
		return candidate.get();
	}

	@Override
	public Candidate addSkill(Long idCandidate, Long idSkill) {
		Optional<Candidate> candidate= findOne(idCandidate);
		Optional<Skill> skill= skillService.findOne(idSkill);
		if(!candidate.isPresent() || !skill.isPresent()) {
			return null;
		}
		candidate.get().addSkill(skill.get());
		
		return candidate.get();
	}

	@Override
	public Candidate save(Candidate candidate) {
		// TODO Auto-generated method stub
		return candidateRepository.save(candidate);
	}

	@Override
	public List<Candidate> findByName(String name) {
		if(name!=null) {
			name= "%" + name + "%";
		}
		return candidateRepository.findByName(name);
	}

	@Override
	public List<Candidate> findBySkill(Long idSkill1, Long idSkill2, Long idSkill3,Long numOfParams) {
		
		return candidateRepository.findBySkill(idSkill1, idSkill2, idSkill3,numOfParams);
	}

}
