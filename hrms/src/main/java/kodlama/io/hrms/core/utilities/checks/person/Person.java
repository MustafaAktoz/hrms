package kodlama.io.hrms.core.utilities.checks.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private String firstName;
	private String lastName;
	private String nationalityIdentity;
	private int year_of_birth;
}
