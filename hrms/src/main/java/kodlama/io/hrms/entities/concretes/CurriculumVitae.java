package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="curriculum_vitaes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schools","jobExperiences","languages","programmingLanguages"})
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@NotBlank
	@NotNull
	@Column(name="photo_path")
	private String photoPath;
	
	@NotBlank
	@NotNull
	@Column(name="git_hub_address")
	private String gitHubAddress;
	
	@NotBlank
	@NotNull
	@Column(name="linked_in_address")
	private String linkedInAddress;
	
	@NotBlank
	@NotNull
	@Column(name="cover_letter")
	private String coverLetter;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<School> schools;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobExperience> jobExperiences;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<ProgrammingLanguage> programmingLanguages;
}
