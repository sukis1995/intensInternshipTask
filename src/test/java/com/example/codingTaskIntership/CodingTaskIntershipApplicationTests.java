package com.example.codingTaskIntership;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.example.codingTaskIntership.controller.CandidateController;
import com.example.codingTaskIntership.dto.CandidateDTO;
import com.example.codingTaskIntership.model.Candidate;
import com.example.codingTaskIntership.model.Skill;
import com.example.codingTaskIntership.repository.CandidateRepository;
import com.example.codingTaskIntership.repository.SkillRepository;
import com.example.codingTaskIntership.service.CandidateService;
import com.example.codingTaskIntership.service.SkillService;


@SpringBootTest
class CodingTaskIntershipApplicationTests {
	
	@Autowired
	private CandidateService candidateService;
	@MockBean
	private CandidateRepository candidateRepository;
	@MockBean
	private SkillRepository skillRepository;
	@Autowired
	private SkillService skillService;
	@Test
	public void getSkills() {
		Mockito.when(skillRepository.findAll()).thenReturn(java.util.stream.Stream.of(new Skill(1L,"Java"),new Skill(2L,"JavaScript")).collect(Collectors.toList()));
		assertEquals(2, skillService.findAll().size());
	}
	
	@Test
	public void getCandidates() {
		Optional<Candidate> dto=candidateService.findOne(4L);
		assertFalse(dto.isPresent());
	}
	@Test
	public void saveSkill() {
	

	}
}
