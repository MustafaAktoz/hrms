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
@Table(name="schools")
public class School {

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
	@Column(name="name")
	private String name;
	
	@NotNull
	@NotBlank
	@Column(name="department")
	private String department;
	
	@NotNull
	@NotBlank
	@Column(name="starting_year")
	private String startingYear;
	
	@Column(name="end_year")
	private String endYear;
}