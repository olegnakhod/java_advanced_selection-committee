package academy.lgs.selection_committee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.FacultyIncludCandidatesRepository;
import academy.lgs.selection_committee.domain.FacultyIncludCandidates;

@Service
public class FacultyIncludCandidatesService {
	
	@Autowired
	private FacultyIncludCandidatesRepository candidatesRepo;
	
	public List<FacultyIncludCandidates> readAll(){
		return candidatesRepo.findAll();
	}
	
	public FacultyIncludCandidates add(FacultyIncludCandidates usersInFaculty) {
		return candidatesRepo.save(usersInFaculty);
	}
	
	public void delete(FacultyIncludCandidates usersInFaculty) {
		candidatesRepo.save(usersInFaculty);
	}
	
	
}
