package com.example.codingTaskIntership.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Skill {
	@Id
	@GeneratedValue
	private Long id; 
	@NotEmpty
	private String name;
	@ManyToMany(mappedBy = "skills")
	private Set<Candidate> candidates=new HashSet<Candidate>();
	
	
	
	public Skill() {
		super();
	}
	public Skill(Long id, @NotEmpty String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Candidate> getCandidates() {
		return candidates;
	}
	public void setCandidates(HashSet<Candidate> candidates) {
		this.candidates = candidates;
	}
	
	public void addCandidate (Candidate candidate) {
		this.candidates.add(candidate);
		if(!candidate.getSkills().contains(this)) {
			candidate.getSkills().add(this);
		}
	}
	
	public void removeCandidate(Candidate candidate) {
		this.candidates.remove(candidate);
		if(candidate.getSkills().contains(this)) {
			candidate.getSkills().remove(this);
		}
	}
	

}
