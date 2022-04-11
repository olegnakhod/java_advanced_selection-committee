package academy.lgs.selection_committee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.lgs.selection_committee.domain.FacultyIncludCandidates;

@Repository	
public interface FacultyIncludCandidatesRepository extends JpaRepository<FacultyIncludCandidates, Integer>{
}
