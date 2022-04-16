package academy.lgs.selection_committee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import academy.lgs.selection_committee.domain.Statment;

@Repository
public interface StatmentRepository extends JpaRepository<Statment, Integer>{

	@Query("SELECT s FROM Statment s WHERE s.faculty.id =:id")
	List<Statment> getAllByFacultyId(Integer id);
	
	@Query("SELECT s FROM Statment s WHERE s.user.id =:id")
	List<Statment> getAllByUserId(Integer id);

}
