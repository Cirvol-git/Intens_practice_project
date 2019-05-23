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

import practice.project.hrstructure.dto.CandidateDTO;
import practice.project.hrstructure.service.CandidateService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/candidate")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@GetMapping("/getone/{id}")
	public ResponseEntity<CandidateDTO> getCandidate(@PathVariable Long id) {
		System.out.println("getCandidate()");
		
		CandidateDTO candDto = candidateService.findOne(id);
		
		return (candDto == null) ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<CandidateDTO>(candDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<CandidateDTO>> getAllCandidates() {
		System.out.println("getAllCandidates()");
		
		List<CandidateDTO> listDto = candidateService.findAll();
		
		return (listDto.isEmpty()) ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<List<CandidateDTO>>(listDto, HttpStatus.OK);
	}
	
	@GetMapping("/search/{name}")
	public ResponseEntity<List<CandidateDTO>> searchCandidates(@PathVariable("name") String name) {
		System.out.println("search()");
		
		List<CandidateDTO> list = candidateService.search(name);
		
		return (list.isEmpty()) ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<List<CandidateDTO>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/skills/{id}")
	public ResponseEntity<List<CandidateDTO>> getCandidatesWithSkill(@PathVariable("id") Long id) {
		System.out.println("getCandidatesWithSkill()");
		
		List<CandidateDTO> list = candidateService.getCandidatesWithSkill(id);
		
		return (list == null) ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<List<CandidateDTO>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<CandidateDTO> addCandidate(@RequestBody CandidateDTO dto) {
		System.out.println("addCandidate()");
		
		CandidateDTO candidate = candidateService.create(dto);
		return new ResponseEntity<>(candidate, HttpStatus.OK);
	}
	
	@PutMapping("/addskill/{id}")
	public ResponseEntity<CandidateDTO> addSKillToCandidate(@PathVariable("id") Long id, @RequestBody Long idSkill) {
		System.out.println("addSkillToCandidate()");
		
		CandidateDTO candidate = candidateService.addSKillToCandidate(id, idSkill);
		
		return (candidate == null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(candidate, HttpStatus.OK);
	}
	
	@PutMapping("/removeskill/{id}")
	public ResponseEntity<CandidateDTO> removeSKillFromCandidate(@PathVariable("id") Long id, @RequestBody Long idSkill) {
		System.out.println("addSkillToCandidate()");
		
		CandidateDTO candidate = candidateService.removeSKillFromCandidate(id, idSkill);
		
		return (candidate == null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(candidate, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<Long> deleteCandidate(@RequestBody Long id) {
		System.out.println("deleteCandidate()");
		
		return candidateService.remove(id) == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(id, HttpStatus.OK);
	}
	
}
