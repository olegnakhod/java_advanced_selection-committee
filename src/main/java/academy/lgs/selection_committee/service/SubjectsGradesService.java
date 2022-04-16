package academy.lgs.selection_committee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.SubjectsGradesRepository;
import academy.lgs.selection_committee.domain.SubjectsGrades;

@Service
public class SubjectsGradesService {
	
	@Autowired
	SubjectsGradesRepository subjectsRepository;
	
	public List<SubjectsGrades> findAll() {
		return  subjectsRepository.findAll();
	}
	
	public SubjectsGrades add(SubjectsGrades subject) {
		return subjectsRepository.save(subject);
	}
	
	public SubjectsGrades update(SubjectsGrades subject,Integer firstSubject, Integer secondSubject, Integer thirdSubject, Integer sumSchoolsCerticifate) {
		SubjectsGrades subjectDB = subjectsRepository.getById(subject.getId());

		subjectDB.setFirstSubject(firstSubject);
		subjectDB.setSecondSubject(secondSubject);
		subjectDB.setThirdSubject(thirdSubject);
		subjectDB.setSumSchoolsCerticifate(sumSchoolsCerticifate);
		subjectDB.setTotalGrades(firstSubject + secondSubject + thirdSubject + sumSchoolsCerticifate);
		return subjectsRepository.save(subjectDB);
	}
	
	public void delete(SubjectsGrades subject) {
		subjectsRepository.delete(subject);
	}
}