package practice.project.hrstructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.project.hrstructure.converter.SkillConverter;
import practice.project.hrstructure.dto.SkillDTO;
import practice.project.hrstructure.model.Skill;
import practice.project.hrstructure.repository.SkillRepository;


@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private SkillConverter skillConverter;
	
	public SkillDTO findOne(Long id) {
		
		Optional<Skill> ret = skillRepository.findById(id);
		
		return ret.isPresent() ? skillConverter.toDTO(ret.get()) : null;
	}
	
	public List<SkillDTO> findAll() {
		List<SkillDTO> ret = new ArrayList<SkillDTO>();
		List<Skill> list = new ArrayList<Skill>();
		
		list = skillRepository.findAll();
		
		if(!list.isEmpty()) {
			
			for (Skill skill : list) {
				ret.add(skillConverter.toDTO(skill));
			}
			return ret;		
		}else {
			return null;
		}
	}
	
	public SkillDTO create(SkillDTO dto) {
		Optional<Skill> skill = skillRepository.findById(dto.getId());	
		
		if(skill.isPresent())
			return null;
		
		return skillConverter.toDTO(skillRepository.save(skillConverter.toSkill(dto)));
	}
	
	public SkillDTO update(SkillDTO dto) {
		Optional<Skill> skill = skillRepository.findById(dto.getId());	
		
		if(skill.isPresent()) 
			return skillConverter.toDTO(skillRepository.save(skillConverter.toSkill(dto)));
		
		return null;
		
	}
	
	public boolean remove(Long id) {
		Optional<Skill> skill = skillRepository.findById(id);
		
		if(skill.isPresent()) {
			skillRepository.deleteById(id);
			return true;
		}
		
		return false;
	}
}
