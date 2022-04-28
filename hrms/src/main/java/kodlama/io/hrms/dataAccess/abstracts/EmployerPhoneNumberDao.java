package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.EmployerPhoneNumber;

public interface EmployerPhoneNumberDao extends JpaRepository<EmployerPhoneNumber, Integer> {

}
