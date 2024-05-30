package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {

	@Autowired
	private MarksRepo marksrepo;

	@Autowired
	private StudentRepo sturepo;

	@Override
	//id is generated automatically, generated auto
	public void run(String... args) throws Exception {

		Student student1 = new Student();
		student1.setName("yadav");
		student1.setDep("cse");
		

//		Student student2 = new Student();
//		student2.setId(3); // Corrected
//		student2.setName("thirdname"); // Corrected
//		student2.setDep("ele"); // Corrected

		Marks marks = new Marks();
		marks.setStudent(student1);
		marks.setMarks((long) 24);
		marks.setSub("disco");
		marks.setName(student1.getName());

		Marks marks1 = new Marks();
		marks1.setStudent(student1);
		marks1.setMarks((long) 23);
		marks1.setSub("ece");
		marks1.setName(student1.getName());

		Marks marks2 = new Marks();
		marks2.setStudent(student1); // Corrected// Corrected
		marks2.setMarks((long) 223); // Corrected
		marks2.setSub("cse"); // Corrected
		marks2.setName(student1.getName()); // Corrected
		
		
		sturepo.saveAndFlush(student1);
		marksrepo.saveAndFlush(marks);
		marksrepo.saveAndFlush(marks1);
		marksrepo.saveAndFlush(marks2);
		
//		sturepo.saveAndFlush(student1);

//		marksrepo.saveAndFlush(marks);
//		marksrepo.saveAndFlush(marks1);
//		marksrepo.saveAndFlush(marks2);

	}
}
