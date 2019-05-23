package practice.project.hrstructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practice.project.hrstructure.dto.SkillDTO;
import practice.project.hrstructure.service.SkillService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/skill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	public ResponseEntity<SkillDTO> getSkill(@PathVariable Long id) {
		System.out.println("getSkill()");
		
		SkillDTO ret = skillService.findOne(id);
		
		return (ret == null) ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<SkillDTO>(ret, HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<SkillDTO>> getAllSkills() {
		System.out.println("getAllSkills()");
		
		List<SkillDTO> listDto = skillService.findAll();
		
		return (listDto == null) ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<List<SkillDTO>>(listDto, HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<SkillDTO> addSkill(@RequestBody SkillDTO skill) {
		System.out.println("addSkill()");
		
		return (skillService.create(skill) == null) ? new ResponseEntity<>(null, HttpStatus.BAD_REQUEST) : new ResponseEntity<SkillDTO>(skill, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<SkillDTO> updateSkill(@RequestBody SkillDTO dto) {
		System.out.println("updateSkill()");
		
		SkillDTO updated = skillService.update(dto);
		
		return (updated == null) ? new ResponseEntity<>(null, HttpStatus.BAD_REQUEST) : new ResponseEntity<SkillDTO>(updated, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Long> deleteSkill(@PathVariable("id") Long id) {
		System.out.println("deleteSkill()");
		
		return (!skillService.remove(id)) ? new ResponseEntity<Long>(id, HttpStatus.NOT_FOUND) : new ResponseEntity<Long>(id, HttpStatus.OK);
	}
}
