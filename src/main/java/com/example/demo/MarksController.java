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
	
	
	@GetMapping("/marks")
	public String showMarks(Model model) {
		List<Marks> marks = marksrepo.findAll();
        model.addAttribute("marks", marks);
		return "markpage";
		
	}
	
	@GetMapping("/data")
	public String addingDataForm(Model model) {
		model.addAttribute("data", new Marks());
		return "add";
	}
	
	@PostMapping("/addm")
	public String processData(@ModelAttribute Marks marks, Model model) {
		model.addAttribute("data", marks);
		List<Marks> ma = marksrepo.findAll();
		ma.add(marks);
		return "markpage";
		
	}
	
	@GetMapping("/addstudent")
	public String addingStudent(Model model) {
		model.addAttribute("student", new Marks());
		return "data";
	}
	
	@PostMapping("/addstudent")
	public String addingStudent(@ModelAttribute Marks marks, Model model) {
		model.addAttribute("data", marks);
		List<Marks> ma = marksrepo.findAll();
		ma.add(marks);
		return "markpage";
		
	}
	
	
	@GetMapping("/addmarks")
	public String addMarks(Model model) {
		return "add";
		
	}


}
