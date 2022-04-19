package academy.lgs.selection_committee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.FacultyRepository;
import academy.lgs.selection_committee.domain.Faculty;

@Service
public class FacultyService {
	
	private Logger logger = LoggerFactory.getLogger(FacultyService.class);
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public void save(Faculty faculty) {
		logger.info("Save faculty item:" + faculty);
		facultyRepository.save(faculty);
	}
	
	public List<Faculty> getAll(){
		logger.info("Get all facultyes items");
		return facultyRepository.findAll();
	}
	
	public Faculty getFacultyByName(String name) {
		logger.info("Get faculty item by name: " + name);
		return facultyRepository.findByName(name);
	}
	
	public Faculty getFacultyById(Integer id) {
		logger.info("Get faculty item by id: " + id);
		return facultyRepository.getById(id);
	}
}
