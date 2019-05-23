package practice.project.hrstructure.dto;

import java.util.Date;
import java.util.List;

public class CandidateDTO {
	private String name;
	private Date dateOfBirth;
	private String contact;
	private String email;
	private List<SkillDTO> skills;
	
	public CandidateDTO() {}
	
	public CandidateDTO(String name, Date dateOfBirth, String contact, String email, List<SkillDTO> skills) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
		this.email = email;
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<SkillDTO> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillDTO> skills) {
		this.skills = skills;
	}
	
}
