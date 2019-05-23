package practice.project.hrstructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.project.hrstructure.converter.CandidateConverter;
import practice.project.hrstructure.dto.CandidateDTO;
import practice.project.hrstructure.model.Candidate;
import practice.project.hrstructure.model.Skill;
import practice.project.hrstructure.repository.CandidateRepository;
import practice.project.hrstructure.repository.SkillRepository;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateConverter candidateConverter;
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	public CandidateDTO findOne(Long id) {
		Optional<Candidate> candidate = candidateRepository.findById(id);
		
		if(!candidate.isPresent())
			return null;
		
		return candidateConverter.toDTO(candidate.get());
	}
	
	public List<CandidateDTO> findAll() {
		List<CandidateDTO> ret = new ArrayList<CandidateDTO>();
		List<Candidate> list =  candidateRepository.findAll();
		
		for (Candidate candidate : list) {
			ret.add(candidateConverter.toDTO(candidate));
		}
		
		return ret;
	}
	
	public List<CandidateDTO> search(String name) {
		List<CandidateDTO> ret = new ArrayList<CandidateDTO>();
		List<Candidate> list = candidateRepository.findByNameIgnoreCaseContaining(name);
		
		for (Candidate c : list) {
			ret.add(candidateConverter.toDTO(c));
		}
		
		return ret;
	}
	
	public List<CandidateDTO> getCandidatesWithSkill(Long id) {
		Optional<Skill> skill = skillRepository.findById(id);
		
		if(!skill.isPresent())
			return null;
		
		List<CandidateDTO> ret = new ArrayList<CandidateDTO>();
		List<Candidate> list = skill.get().getCandidates();
		
		for (Candidate c : list) {
			ret.add(candidateConverter.toDTO(c));
		}
		
		return ret;
	}
	
	public CandidateDTO create(CandidateDTO dto) {
		Candidate candidate = candidateConverter.toCandidate(dto);
		candidate.setId(null);
		
		return candidateConverter.toDTO(candidateRepository.save(candidate));
	}
	
	public CandidateDTO addSKillToCandidate(Long idCand, Long idSkill) {
		Optional<Candidate> candidate = candidateRepository.findById(idCand);
		Optional<Skill> skill = skillRepository.findById(idSkill);
		
		if(!skill.isPresent() || !candidate.isPresent()) {
			return null;
		}
		
		Candidate can = candidate.get();
		List<Skill> list = can.getSkills();
		list.add(skill.get());
		can.setSkills(list);
		
		
		return candidateConverter.toDTO(candidateRepository.save(can));
	}
	
	public CandidateDTO removeSKillFromCandidate(Long idCand, Long idSkill) {
		Optional<Candidate> candidate = candidateRepository.findById(idCand);
		Optional<Skill> skill = skillRepository.findById(idSkill);
		
		if(!skill.isPresent() || !candidate.isPresent()) 
			return null;
		
		Candidate can = candidate.get();
		List<Skill> list = can.getSkills();
		list.remove(skill.get());
		can.setSkills(list);
		
		return candidateConverter.toDTO(candidateRepository.save(can));
	}
	
	public Long remove(Long id) {
		Optional<Candidate> candidate = candidateRepository.findById(id);
		
		if(candidate.isPresent())
			return null;
		
		candidateRepository.delete(candidate.get());
		return id;
	}
}
