package academy.lgs.selection_committee.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.lgs.selection_committee.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);

}
