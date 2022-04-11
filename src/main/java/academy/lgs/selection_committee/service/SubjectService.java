package academy.lgs.selection_committee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.SubjectsRepository;
import academy.lgs.selection_committee.domain.Subject;

@Service
public class SubjectService {
	
	@Autowired
	SubjectsRepository subjectsRepository;
	
	public List<Subject> findAll() {
		return  subjectsRepository.findAll();
	}
	
	public Subject add(Subject subject) {
		return subjectsRepository.save(subject);
	}
	
	public void delete(Subject subject) {
		subjectsRepository.delete(subject);
	}
}