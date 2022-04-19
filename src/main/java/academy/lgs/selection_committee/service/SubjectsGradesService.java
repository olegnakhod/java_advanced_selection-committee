package academy.lgs.selection_committee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.selection_committee.dao.SubjectsGradesRepository;
import academy.lgs.selection_committee.domain.SubjectsGrades;

@Service
public class SubjectsGradesService {
	
	private Logger logger = LoggerFactory.getLogger(SubjectsGradesService.class);
	
	@Autowired
	SubjectsGradesRepository subjectsRepository;
	
	public List<SubjectsGrades> findAll() {
		logger.info("Get all subjectsGrades items");
		return  subjectsRepository.findAll();
	}
	
	public SubjectsGrades add(SubjectsGrades subject) {
		logger.info("Save subjectsGrades item:" + subject);
		return subjectsRepository.save(subject);
	}
	
	public SubjectsGrades update(SubjectsGrades subject,Integer firstSubject, Integer secondSubject, Integer thirdSubject, Integer sumSchoolsCerticifate) {
		SubjectsGrades subjectDB = subjectsRepository.getById(subject.getId());
		subjectDB.setFirstSubject(firstSubject);
		subjectDB.setSecondSubject(secondSubject);
		subjectDB.setThirdSubject(thirdSubject);
		subjectDB.setSumSchoolsCerticifate(sumSchoolsCerticifate);
		subjectDB.setTotalGrades(firstSubject + secondSubject + thirdSubject + sumSchoolsCerticifate);
		logger.info("Update subjectsGrades item:" + subject + " to :" + subjectDB);
		return subjectsRepository.save(subjectDB);
	}
	
	public void delete(SubjectsGrades subject) {
		logger.info("Delete subjectsGrades item:" + subject);
		subjectsRepository.delete(subject);
	}
}