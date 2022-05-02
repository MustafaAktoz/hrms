package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;

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
@Table(name="job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "employer_user_id")
	private Employer employer;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@NotBlank
	@NotNull
	@Column(name="description")
	private String description;

	@NotNull
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@NotNull
	@Column(name="number_of_positions")
	private int numberOfPositions;
	
	@NotNull
	@Column(name="status")
	private boolean status;
}
