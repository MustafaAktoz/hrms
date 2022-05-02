package kodlama.io.hrms.entities.concretes;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="languages")
public class Language {
	
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
	@Min(1)
	@Max(5)
	@Column(name="level")
	private int level;
}
