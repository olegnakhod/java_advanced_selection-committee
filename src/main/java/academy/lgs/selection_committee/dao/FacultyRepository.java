package academy.lgs.selection_committee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.lgs.selection_committee.domain.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	
	Faculty findByName(String name);
		
}
