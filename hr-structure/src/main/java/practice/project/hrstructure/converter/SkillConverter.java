package practice.project.hrstructure.converter;

import org.springframework.stereotype.Component;

import practice.project.hrstructure.dto.SkillDTO;
import practice.project.hrstructure.model.Skill;

@Component
public class SkillConverter {
	
	public SkillDTO toDTO(Skill skill) {
		SkillDTO ret = new SkillDTO(skill.getId(), skill.getName(), skill.getDescription());
		return ret;
	}
	
	public Skill toSkill(SkillDTO dto) {
		Skill ret = new Skill(dto.getId(), dto.getName(), dto.getDescription());
		return ret;
	}
 }
