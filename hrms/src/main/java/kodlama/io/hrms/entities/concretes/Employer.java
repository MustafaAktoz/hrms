package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlama.io.hrms.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements","employerPhoneNumbers"})
public class Employer extends User{
	
	@NotNull
	@NotBlank
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank
	@NotNull
	@Column(name="web_address")
	private String webAddress;	
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
	@OneToMany(mappedBy = "employer")
	private List<EmployerPhoneNumber> employerPhoneNumbers;
}