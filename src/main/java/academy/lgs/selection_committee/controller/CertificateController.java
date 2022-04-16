package academy.lgs.selection_committee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import academy.lgs.selection_committee.domain.Certificate;
import academy.lgs.selection_committee.domain.SubjectsGrades;
import academy.lgs.selection_committee.domain.User;
import academy.lgs.selection_committee.service.CertificateService;
import academy.lgs.selection_committee.service.SubjectsGradesHelperDTO;
import academy.lgs.selection_committee.service.SubjectsGradesService;
import academy.lgs.selection_committee.service.UserService;

@Controller
public class CertificateController {
	
	@Autowired
	private SubjectsGradesService subjectService;
	
	@Autowired
	private CertificateService certificateService;
	
	@Autowired
	private UserService userService;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}
	
	@RequestMapping(value = "/addCertificate", method = RequestMethod.GET)
	public ModelAndView startPage() {
			ModelAndView map = new ModelAndView("addCertificate");
		return map;
	}
	
	@RequestMapping(value = "/addCertificate", method = RequestMethod.POST)
	public String addCandidate(
			@RequestParam Integer firstSubject,
			@RequestParam Integer secondSubject,
			@RequestParam Integer thirdSubject,
			@RequestParam Integer sumSchoolsCerticifate) {

		Certificate certificate = new Certificate();
		Certificate certificateDB = certificateService.getByUserId(getCurrentUser().getId());
		SubjectsGrades subjectsGrades = SubjectsGradesHelperDTO.createSubjectsGrades(firstSubject, secondSubject, thirdSubject, sumSchoolsCerticifate);
		
		if(certificateDB == null || certificateService.getAll().isEmpty()) {
			subjectService.add(subjectsGrades);
			certificate.setUser(getCurrentUser());
			certificate.setSubject(subjectsGrades);
			certificateService.add(certificate);
		}else {
			SubjectsGrades subject = certificateDB.getSubject();
			subjectService.update(subject,firstSubject, secondSubject, thirdSubject, sumSchoolsCerticifate);
		}
		return "redirect:/home";
	}
}
