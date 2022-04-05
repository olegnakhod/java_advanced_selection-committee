package academy.lgs.selection_committee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.lgs.selection_committee.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer>{

}
