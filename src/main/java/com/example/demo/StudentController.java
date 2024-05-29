package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private final StudentRepo studrepo;

	public StudentController(StudentRepo studrepo) {
		this.studrepo = studrepo;
	}

	@GetMapping("/")
	public String home(Model model) {
		List<Student> posts = studrepo.findAll();
		model.addAttribute("posts", posts);
		return "home";
	}

	@GetMapping("/addnew")
	public String addnew() {

		return "add";
	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studrepo.findAll();
	}

	@PutMapping("/studentu")
	private Student update(@RequestBody Student student) {
		studrepo.save(student);
		return student;
	}

	@DeleteMapping("student/{id}")
	public void deleteById(@PathVariable("id") long id) {
		studrepo.deleteById(id);
	}
	//
	// @GetMapping("/stu")
	// public String getStudents(Model model) {
	// List<Student> students = studrepo.findAll();
	// model.addAttribute("students", students);
	// return "students"; // This will resolve to the "students.html" Thymeleaf
	// template
	// }

	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return studrepo.save(student);

	}

}
