package com.example.codingTaskIntership.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
@Entity
public class Candidate {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String fullName;
	@Column
	private Date dateOfBirth;
	@NotEmpty
	private String contactNumber;
	@Email
	@NotEmpty
	private String email;
	@ManyToMany
	@JoinTable(name="candidate_skill",
	joinColumns = @JoinColumn(name="candidate_id"),
	inverseJoinColumns = @JoinColumn(name="skill_id"))
	private Set<Skill> skills= new HashSet<Skill>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Skill> getSkills() {
		return skills;
	}
	public void setSkills(HashSet<Skill> skills) {
		this.skills = skills;
	}
	
	public void addSkill(Skill skill) {
		this.skills.add(skill);
		if(!skill.getCandidates().contains(this)) {
			skill.getCandidates().add(this);
		}
	}
	
	public void removeSkill(Skill skill) {
		this.skills.remove(skill);
		if(skill.getCandidates().contains(this)) {
			skill.getCandidates().remove(this);
		}
	}
	
	

}
