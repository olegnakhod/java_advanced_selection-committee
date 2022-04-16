package academy.lgs.selection_committee.service;

import academy.lgs.selection_committee.domain.SubjectsGrades;

public class SubjectsGradesHelperDTO {
	
	public static SubjectsGrades createSubjectsGrades(Integer firstSubject,Integer secondSubject,Integer thirdSubject,Integer sumSchoolsCerticifate) {
		
		SubjectsGrades subject = new SubjectsGrades();
		
		subject.setFirstSubject(firstSubject);
		subject.setSecondSubject(secondSubject);
		subject.setThirdSubject(thirdSubject);
		subject.setSumSchoolsCerticifate(sumSchoolsCerticifate);
		subject.setTotalGrades(sumSchoolsCerticifate + thirdSubject + secondSubject + firstSubject);
		return subject;
	}

}
