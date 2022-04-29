package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import kodlama.io.hrms.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDetailDto implements Dto {
	private int id;
	private String companyName;
	private String jobPositionName;
	private int numberOfPositions;
	private LocalDate date;
	private LocalDate applicationDeadline;
}
