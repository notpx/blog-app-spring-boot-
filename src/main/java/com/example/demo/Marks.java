package com.example.demo;


import jakarta.*;
import java.util.List;
import java.util.Objects;
import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Marks {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long marks;
	private String sub;
	private String name;
	
	
	  //many marks can be attached to one student. Getters and Setters and generated using Lombok.
	  @ManyToOne
	  @JoinColumn(name = "disco", referencedColumnName = "id")
	  Student student;



	public void setStudent(Student student2) {
		// TODO Auto-generated method stub
		this.student = student2;
	}


	


	

}
