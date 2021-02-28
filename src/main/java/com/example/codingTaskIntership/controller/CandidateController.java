package com.example.codingTaskIntership.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codingTaskIntership.dto.CandidateDTO;
import com.example.codingTaskIntership.dto.SkillDTO;
import com.example.codingTaskIntership.model.Candidate;
import com.example.codingTaskIntership.model.Skill;
import com.example.codingTaskIntership.service.CandidateService;
import com.example.codingTaskIntership.support.CandidateDTOToCandidate;
import com.example.codingTaskIntership.support.CandidateToCandidateDTO;
import com.example.codingTaskIntership.support.SkillDTOToSkill;

@Controller
@RequestMapping("/api/candidates")
public class CandidateController {
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private CandidateToCandidateDTO toDto;
	@Autowired
	private CandidateDTOToCandidate toCandidate;
	
	/**@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CandidateDTO>> findAll(){
		List<Candidate> candidates=candidateService.findAll();
		if(candidates==null || candidates.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<CandidateDTO>>(toDto.convert(candidates), HttpStatus.OK);
		
	}*/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CandidateDTO> save (@Validated  @RequestBody CandidateDTO dto){
		Candidate candidate = toCandidate.convert(dto);
		if(candidate==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Candidate saved= candidateService.save(candidate);
		if(saved==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<CandidateDTO>(toDto.convert(saved),HttpStatus.CREATED);
		
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/addSkill/{idCandidate}")
	public ResponseEntity<CandidateDTO> upadteCandidateAddSkill(@PathVariable("idCandidate") Long idCandidate,
																@RequestBody SkillDTO skillDto){
		
		
		Candidate candidate= candidateService.addSkill(idCandidate, skillDto.getId());
		if(candidate==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Candidate saved= candidateService.save(candidate);
		if(saved==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<CandidateDTO>(toDto.convert(saved),HttpStatus.ACCEPTED);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/removeSkill/{idCandidate}/{idSkill}")
	public ResponseEntity<CandidateDTO> upadteCandidateRemoveSkill(@PathVariable("idCandidate") Long idCandidate,
																@PathVariable("idSkill") Long idSkill){
		Candidate candidate= candidateService.removeSkill(idCandidate, idSkill);
		if(candidate==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Candidate saved= candidateService.save(candidate);
		if(saved==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<CandidateDTO>(toDto.convert(saved),HttpStatus.NO_CONTENT);
		
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<CandidateDTO> delete (@PathVariable Long id){
		Optional<Candidate> candidate = candidateService.findOne(id);
		if(!candidate.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Candidate> deleted= candidateService.delete(id);
		if(!deleted.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<CandidateDTO>(toDto.convert(deleted.get()),HttpStatus.NO_CONTENT);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<CandidateDTO> findOne(@PathVariable Long id){
		Optional<Candidate> candidate = candidateService.findOne(id);
		if(!candidate.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<CandidateDTO>(toDto.convert(candidate.get()),HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET,value = "/findByName")
	public ResponseEntity<List<CandidateDTO>> findByName(@RequestParam(required = true) String fullName){
		List<Candidate> candidates = candidateService.findByName(fullName);
		if(candidates==null || candidates.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<CandidateDTO>>(toDto.convert(candidates), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CandidateDTO>> findBySkills(@RequestParam(required = false) Long Skill1,
															@RequestParam(required = false) Long Skill2,
															@RequestParam(required = false) Long Skill3,
															@RequestParam(required = false) Long numOfParams){
		List<Candidate> candidates;
		if(Skill1!=null || Skill2!=null || Skill3!=null) {
			 candidates= candidateService.findBySkill(Skill1, Skill2, Skill3,numOfParams);
		}else {
			candidates=candidateService.findAll();
		}
		
		if(candidates==null || candidates.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<CandidateDTO>>(toDto.convert(candidates), HttpStatus.OK);
		
	}
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> exceptionHandler(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	

}
