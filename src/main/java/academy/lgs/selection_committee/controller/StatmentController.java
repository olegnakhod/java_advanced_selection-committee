package academy.lgs.selection_committee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import academy.lgs.selection_committee.domain.Certificate;
import academy.lgs.selection_committee.domain.Faculty;
import academy.lgs.selection_committee.domain.Statment;
import academy.lgs.selection_committee.domain.User;
import academy.lgs.selection_committee.service.CertificateService;
import academy.lgs.selection_committee.service.FacultyService;
import academy.lgs.selection_committee.service.StatmentService;
import academy.lgs.selection_committee.service.UserService;

@Controller
public class StatmentController {
	
	@Autowired
	private StatmentService statmentService;
	
	@Autowired
	private FacultyService facultyService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CertificateService certificateService;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}
	
	@RequestMapping(value = "/applyToFaculty", method = RequestMethod.GET)
	private ModelAndView getFaculty() {
		ModelAndView map = new ModelAndView("applyToFaculty");
		map.addObject("facultyes", facultyService.readAllFaculties());
		return map;
	}

	@RequestMapping(value = "/applyToFaculty", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView addCandidate(@RequestParam Integer facultyId) {

		Statment statment = new Statment();
		User user =  getCurrentUser();
		Faculty faculty = facultyService.getFacultyById(facultyId);
		Certificate certificate = certificateService.getByUserId(user.getId());
		
		boolean findCreateStatmentForUser = statmentService.getAllByUserId(user.getId()).stream().filter(x->x.getFaculty().getId().equals(faculty.getId())).findFirst().isEmpty();
		
		statment.setFaculty(faculty);
		statment.setUser(user);

		if(certificate.getSubject().getTotalGrades() > faculty.getMinimumPassingScore() & 
				findCreateStatmentForUser) {
			
			statmentService.add(statment);
		}
		return new ModelAndView("redirect:/applyToFaculty");
		
	}
	
	@RequestMapping(value = "/viewCandidatesInFaculty", method = RequestMethod.GET)
	private ModelAndView viewCandidatesInFaculty(@RequestParam Integer facultyId,HttpServletRequest req) {
		ModelAndView map = new ModelAndView("viewCandidateInFaculty");
		req.setAttribute("mode", "VIEW_CANDIDATE");
		List<User> users = new ArrayList<>();
		List<Statment> facultyIncludCandidates = statmentService.getAllByFacultyId(facultyId);
		facultyIncludCandidates.stream().forEach(x -> users.add(x.getUser()));
		map.addObject("candidates", users);
		return map;
	}
	
	@RequestMapping(value = "/viewCandidateInFaculty", method = RequestMethod.GET)
	private ModelAndView viewFaculty(HttpServletRequest req) {
		ModelAndView map = new ModelAndView("viewCandidateInFaculty");
		req.setAttribute("mode", "VIEW_FACULTY");
		map.addObject("faculityes",  facultyService.getAll());
		return map;
	}
	
	@RequestMapping(value = "/viewTotalGrades", method = RequestMethod.GET)
	private ModelAndView viewTotalGrades(@RequestParam Integer userId) {
		ModelAndView map = new ModelAndView("viewCandidateInFaculty");
		map.addObject("subject",  certificateService.getByUserId(userId).getSubject().getTotalGrades());
		return map;
	}
	
	@RequestMapping(value = "/deleteCandidate", method = RequestMethod.GET)
	private ModelAndView deleteCandidate(@RequestParam Integer userId) {
		ModelAndView map = new ModelAndView("viewCandidateInFaculty");
		statmentService.deleteByUserId(userId);
		return map;
	}
	
}
