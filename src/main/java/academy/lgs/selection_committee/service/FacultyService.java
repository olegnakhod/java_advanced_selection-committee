package academy.lgs.selection_committee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.FacultyRepository;
import academy.lgs.selection_committee.domain.Faculty;

@Service
public class FacultyService {
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public void save(Faculty faculty) {
		facultyRepository.save(faculty);
	}
	
	public Faculty getFacultyByName(String name) {
		return facultyRepository.findByName(name);
	}
	
	public Faculty getFacultyById(Integer id) {
		return facultyRepository.getById(id);
	}
	
	public List<Faculty> readAllFaculties(){
		return facultyRepository.findAll();
	}
	

}
