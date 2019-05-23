package practice.project.hrstructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practice.project.hrstructure.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
