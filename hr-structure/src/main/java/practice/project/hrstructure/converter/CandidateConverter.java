package practice.project.hrstructure.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import practice.project.hrstructure.dto.CandidateDTO;
import practice.project.hrstructure.dto.SkillDTO;
import practice.project.hrstructure.model.Candidate;
import practice.project.hrstructure.model.Skill;

@Component
public class CandidateConverter {
	
	@Autowired
	private SkillConverter skillConverter;
	
	public CandidateDTO toDTO (Candidate c) {
		CandidateDTO ret = new CandidateDTO(c.getName(), c.getDateOfBirth(), c.getContact(), c.getEmail(), null);
		
		List<SkillDTO> retList = new ArrayList<>();
		List<Skill> list = c.getSkills();
		
		for (Skill skill : list) {
			retList.add(skillConverter.toDTO(skill));
		}
		
		ret.setSkills(retList);
		return ret;
	}
	
	public Candidate toCandidate(CandidateDTO dto) {
		Candidate ret = new Candidate(dto.getName(), dto.getDateOfBirth(), dto.getContact(), dto.getEmail(), null);
		
		
		return ret;
	}
}
