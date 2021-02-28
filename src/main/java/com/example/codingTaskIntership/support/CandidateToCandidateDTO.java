package com.example.codingTaskIntership.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.codingTaskIntership.dto.CandidateDTO;
import com.example.codingTaskIntership.model.Candidate;

@Component
public class CandidateToCandidateDTO implements Converter<Candidate,CandidateDTO> {

	@Override
	public CandidateDTO convert(Candidate candidate) {
		CandidateDTO dto= new CandidateDTO();
		dto.setContactNumber(candidate.getContactNumber());
		dto.setDateOfBirth(candidate.getDateOfBirth());
		dto.setEmail(candidate.getEmail());
		dto.setFullName(candidate.getFullName());
		dto.setId(candidate.getId());
		
		return dto;
	}
	
	public List<CandidateDTO> convert(List<Candidate> candidates){
		List<CandidateDTO> dtos= new ArrayList<CandidateDTO>();
		for (Candidate candidate : candidates) {
			CandidateDTO dto= convert(candidate);
			dtos.add(dto);
		}
		return dtos;
	}
	
	

}
