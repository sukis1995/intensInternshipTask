package com.example.codingTaskIntership.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.codingTaskIntership.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
	@Query("Select c from Candidate c where c.fullName like :name")
	public List<Candidate> findByName(@Param("name") String name);
	@Query("Select  c from Candidate c  join c.skills s where s.id in (:idSkill1,:idSkill2,:idSkill3) group by c.id"
			+ "	having count (s.id)>=:num")
	public List<Candidate> findBySkill(@Param("idSkill1") Long idSkill1,@Param("idSkill2") Long idSkill2,@Param("idSkill3") Long idSkill3,@Param("num") Long numOfParams);

}
