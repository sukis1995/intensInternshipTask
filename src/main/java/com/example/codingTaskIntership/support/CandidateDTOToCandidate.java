package com.example.codingTaskIntership.support;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.codingTaskIntership.dto.CandidateDTO;
import com.example.codingTaskIntership.model.Candidate;
import com.example.codingTaskIntership.service.CandidateService;

@Component
public class CandidateDTOToCandidate implements Converter<CandidateDTO, Candidate>{
	@Autowired
	private CandidateService candidateService;

	@Override
	public Candidate convert(CandidateDTO dto) {
		Candidate candidate;
		if(dto.getId()!=null) {
			candidate=candidateService.findOne(dto.getId()).get();
		}else {
			candidate= new Candidate();
		}

		candidate.setContactNumber(dto.getContactNumber());
		candidate.setEmail(dto.getEmail());
		candidate.setFullName(dto.getFullName());
		candidate.setDateOfBirth(dto.getDateOfBirth());
		return candidate;
	}

}
