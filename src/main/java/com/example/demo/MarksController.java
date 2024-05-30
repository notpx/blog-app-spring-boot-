package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class MarksController {

	@Autowired
	MarksRepo marksrepo;
	
	@Autowired
	StudentRepo studrepo;

	@GetMapping("/allmarks")
	public String showMarks(Model model) {
		List<Marks> marks = marksrepo.findAll();
		model.addAttribute("marks", marks);
		return "markpage";

	}

	@GetMapping("/addmarks")
	public String AddMarks(Model model) {
		List<Student> students = studrepo.findAll();
        model.addAttribute("students", students);
		model.addAttribute("marks", new Marks());
		return "addmarkspage";

	}

	@PostMapping("/addmarks")
	public String SavingGatheredMarks(@ModelAttribute Marks marks) {
	    Student student = studrepo.findById((long) 1).orElse(null);
	    
		marks.setStudent(student);
		marksrepo.save(marks);
	    
		return "redirect:/allmarks";

	}

}
