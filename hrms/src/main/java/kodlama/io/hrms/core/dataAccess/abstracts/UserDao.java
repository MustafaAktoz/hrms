package kodlama.io.hrms.core.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.core.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getByEmail(String email);
}
