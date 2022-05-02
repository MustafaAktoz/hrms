package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_experiences")
public class JobExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;
	
	@NotNull
	@NotBlank
	@Column(name="workplace_name")
	private String workplaceName;
	
	@NotNull
	@NotBlank
	@Column(name="position")
	private String position;
	
	@NotNull
	@NotBlank
	@Column(name="starting_year")
	private String startingYear;
	
	@Column(name="end_year")
	private String endYear;
}
