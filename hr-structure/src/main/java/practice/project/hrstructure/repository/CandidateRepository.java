package practice.project.hrstructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practice.project.hrstructure.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	List<Candidate> findByNameIgnoreCaseContaining(String name);

}
