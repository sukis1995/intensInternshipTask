package com.example.codingTaskIntership.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.codingTaskIntership.model.Candidate;
import com.example.codingTaskIntership.model.Skill;
@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
	@Query("Select  s from Skill s join s.candidates c where c=:candidate ") 
	public List<Skill> findByCandidate(@Param("candidate") Candidate candidate);

}
