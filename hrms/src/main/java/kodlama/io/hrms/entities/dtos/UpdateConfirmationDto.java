package kodlama.io.hrms.entities.dtos;

import javax.validation.constraints.NotNull;

import kodlama.io.hrms.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateConfirmationDto implements Dto{
	@NotNull
	private int id;
	
	@NotNull
	private boolean confirmation;
}
