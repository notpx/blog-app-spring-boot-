package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class SeedData implements CommandLineRunner{
	
	@Autowired
	private MarksRepo marksrepo;
	
	@Autowired
	private StudentRepo sturepo;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		
		Student student = new Student();
		student.setId(1);
		student.setName("firstname");
		student.setDep("ece");
		
		Student student1 = new Student();
		student1.setId(2);
		student1.setName("hero");
		student1.setDep("cse");
		
		Student student3 = new Student();
		student3.setId(2);
		student3.setName("hero");
		student3.setDep("cse");
		
		
		sturepo.save(student3);
		
		sturepo.save(student);
		sturepo.save(student1);
		
		Marks marks1 = new Marks();
		marks1.setStudent(student);
		marks1.setId((long) 1);
		marks1.setMarks((long) 23);
		marks1.setSub("ece");
		marks1.setName(student1.getName());
		
		Marks marks = new Marks();
		marks.setStudent(student1);
		marks.setId((long) 2);
		marks.setMarks((long) 24);
		marks.setSub("disco");
		marks.setName(student.getName());
		
		
		Marks marks2 = new Marks();
		marks2.setStudent(student3);
		marks2.setId((long) 2);
		marks2.setMarks((long) 24);
		marks2.setSub("sd");
		marks2.setName(student.getName());
		
		marksrepo.save(marks1);
		marksrepo.save(marks);
		marksrepo.save(marks2);
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		
		
		
	}

}
