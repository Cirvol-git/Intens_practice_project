package practice.project.hrstructure.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Candidate { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 45)
	private String name;
	
	@NotNull
	@Size(min = 2, max = 45)
	private Date dateOfBirth;
	
	@Size(min = 2, max = 45)
	private String contact;
	
	@NotNull
	@Size(min = 2, max = 45)
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinTable(name = "candidate_skills",
			joinColumns = @JoinColumn(name = "candidate_id"),
			inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> skills;
	
	public Candidate() {}
	
	public Candidate(String name, Date dateOfBirth, String contact, String email, ArrayList<Skill> skills) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
		this.email = email;
		this.skills = skills;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
}
