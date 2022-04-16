package academy.lgs.selection_committee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import academy.lgs.selection_committee.domain.Faculty;
import academy.lgs.selection_committee.service.FacultyService;

@Controller
public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;
	
	
    @RequestMapping(value = "/addFaculty", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("facultyForm", new Faculty());

        return "addFaculty";
    }
    
    @RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
    public String registration(@ModelAttribute("facultyForm") Faculty facultyForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "addFaculty";
        }
        facultyService.save(facultyForm);
        return "redirect:/home";
    }

}
