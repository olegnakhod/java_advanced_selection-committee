package academy.lgs.selection_committee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import academy.lgs.selection_committee.domain.Certificate;
import academy.lgs.selection_committee.domain.Grades;
import academy.lgs.selection_committee.domain.Subject;
import academy.lgs.selection_committee.domain.User;
import academy.lgs.selection_committee.service.CertificateService;
import academy.lgs.selection_committee.service.SubjectService;
import academy.lgs.selection_committee.service.UserService;

@Controller
public class CertificateController {
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private CertificateService certificateService;
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/addCertificate", method = RequestMethod.GET)
    public ModelAndView registration(Model model) {
        model.addAttribute("subjectForm", new Subject());

        return getSubjectsItems();
    }
	
	@RequestMapping(value = "/addCertificate", method = RequestMethod.POST)
	public ModelAndView addCandidate(@ModelAttribute("subjectForm") Subject subjectForm) {

		Certificate certificate = new Certificate();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		
		subjectService.add(subjectForm);
		
		certificate.setUser(user);
		certificate.setSubject(subjectForm);
		
		certificateService.add(certificate);


		return getSubjectsItems() ;
	}
	
	private ModelAndView getSubjectsItems() {
		ModelAndView map = new ModelAndView("addCertificate");
		List<Subject> subjects = new ArrayList<>();
		List<Certificate> certificates = certificateService.getAll();
		certificates.stream().forEach(x -> subjects.add(x.getSubject()));
		map.addObject("subjects", subjects);
		return map;
	}
	
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping(value = "/averageScore", method = RequestMethod.POST)
	public ModelAndView addCandidate(@RequestParam Integer userId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		
		ModelAndView map = new ModelAndView("addCertificate");
		
		Integer averageScore = null;
		List<Grades> grades = null;
		List<Subject> subjects = certificateService.getAllSubjectByUserId(user.getId());
		subjects.stream().forEach(x->grades.add(x.getGrade()));
		for(int i = 0; i < grades.size(); i++ ) {
			averageScore += grades.get(i).getValue();
		}

		map.addObject("averageScore", averageScore.toString());
		return map;
	}
}
