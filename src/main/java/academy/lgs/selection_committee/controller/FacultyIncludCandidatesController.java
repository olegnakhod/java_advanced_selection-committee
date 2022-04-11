package academy.lgs.selection_committee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import academy.lgs.selection_committee.domain.Faculty;
import academy.lgs.selection_committee.domain.FacultyIncludCandidates;
import academy.lgs.selection_committee.domain.User;
import academy.lgs.selection_committee.service.FacultyIncludCandidatesService;
import academy.lgs.selection_committee.service.FacultyService;
import academy.lgs.selection_committee.service.UserService;

@Controller
public class FacultyIncludCandidatesController {

	@Autowired
	private FacultyIncludCandidatesService candidatesService;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/applyToFaculty", method = RequestMethod.GET)
	private ModelAndView getFaculty() {
		ModelAndView map = new ModelAndView("applyToFaculty");
		map.addObject("facultyes", facultyService.readAllFaculties());
		return map;
	}

	@RequestMapping(value = "/applyToFaculty", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView addCandidate(@RequestParam Integer facultyId) {

		FacultyIncludCandidates candidates = new FacultyIncludCandidates();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());

		Faculty faculty = facultyService.getFacultyById(facultyId);

		candidates.setFaculty(faculty);
		candidates.setUser(user);
		
		candidatesService.add(candidates);


		return getApplicantsItems();
	}

	@RequestMapping(value = "/viewCandidateInFaculty", method = RequestMethod.GET)
	public ModelAndView viewAllCandidate() {
		return getApplicantsItems();
	}

	private ModelAndView getApplicantsItems() {
		ModelAndView map = new ModelAndView("viewCandidateInFaculty");
		List<User> users = new ArrayList();
		List<FacultyIncludCandidates> facultyIncludCandidates = candidatesService.readAll();
		facultyIncludCandidates.stream().forEach(x -> users.add(x.getUser()));
		map.addObject("candidates", users);
		return map;
	}

}
