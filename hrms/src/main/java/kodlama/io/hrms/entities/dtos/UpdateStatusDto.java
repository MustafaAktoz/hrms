package kodlama.io.hrms.entities.dtos;

import kodlama.io.hrms.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusDto implements Dto{
	private int id;
	private boolean status;
}
